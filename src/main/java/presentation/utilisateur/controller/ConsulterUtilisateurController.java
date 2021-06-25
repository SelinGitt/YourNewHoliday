/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR00 pour consulter un profil Utilisateur
 *
 * @author Damien D.
 */
@Controller
@RequestMapping({"/consulterUtilisateur.do", "/supprimerUtilisateur.do"})
public class ConsulterUtilisateurController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet de traiter les requêtes en GET affiche la page de consultation de profil Utilisateur
     * 
     * @param  request            : la requête HTTP
     * @param  session            : la session en cours
     * @param  redirectAttributes : attributs de redirection
     * @return                    un modelAndView
     */
    @GetMapping
    public ModelAndView afficherPage(final HttpServletRequest request, final HttpSession session,
            final RedirectAttributes redirectAttributes) {
        final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        if (request.getRequestURI().contains("/supprimerUtilisateur.do")) {
            return supprimerUtilisateur(utilisateurConnecte, redirectAttributes);
        }
        return consulterUtilisateur(utilisateurConnecte);
    }

    private ModelAndView consulterUtilisateur(final UtilisateurConnecteDto utilisateurConnecte) {
        final var modelAndView = new ModelAndView();
        final UtilisateurDto utilisateurDto = recupererUtilisateurDto(utilisateurConnecte);

        modelAndView.setViewName("consulterUtilisateur");
        modelAndView.getModelMap().addAttribute("utilisateurDto", utilisateurDto);
        return modelAndView;
    }

    private ModelAndView supprimerUtilisateur(final UtilisateurConnecteDto utilisateurConnecteDto,
            final RedirectAttributes redirectAttributes) {
        final Integer id = Integer.valueOf(utilisateurConnecteDto.getIdUtilisateur());
        final Integer role = Integer.valueOf(utilisateurConnecteDto.getIdRole());

        final var modelAndView = new ModelAndView();

        final boolean result;
        try {
            //appel de la méthode de suppression et stockage du retour dans variable result
            result = iUtilisateurService.deleteUtilisateurById(id, role);
        } catch (final UnexpectedRollbackException exception) {
            //Erreur inconnue, on reste sur la page + message d'erreur générique
            modelAndView.getModelMap().addAttribute("error", "usr00.erreur.failure");
            modelAndView.setViewName("forward:/consulterUtilisateur.do");
            return modelAndView;
        }
        if (result) {
            //redirection vers deconnecter.do si suppression réussie, 
            //puis vers listerProduits.do ensuite (voir dans ConnecterController)
            redirectAttributes.addFlashAttribute("deletionSuccess", "usr00.success.deleted");
            modelAndView.setViewName("redirect:/deconnecter.do");
            return modelAndView;
        }
        //Un seul administrateur en BD -> suppression impossible, + message d'erreur
        modelAndView.getModelMap().addAttribute("error", "usr00.erreur.last_admin");
        modelAndView.setViewName("forward:/consulterUtilisateur.do");
        return modelAndView;
    }

    private UtilisateurDto recupererUtilisateurDto(final UtilisateurConnecteDto utilisateurConnecteDto) {
        final Integer id = Integer.valueOf(utilisateurConnecteDto.getIdUtilisateur());
        return iUtilisateurService.findUtilisateurById(id);
    }
}
