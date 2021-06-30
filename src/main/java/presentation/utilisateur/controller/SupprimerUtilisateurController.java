/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller pour supprimer un Utilisateur
 *
 * @author Damien D.
 */
@Controller
@RequestMapping("/supprimerUtilisateur.do")
public class SupprimerUtilisateurController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet supprimer un utilisateur
     *
     * @param  session            : la session en cours
     * @param  redirectAttributes : attributs de redirection
     * @return                    un ModelAndView
     */
    @GetMapping
    public ModelAndView supprimerUtilisateur(final HttpSession session, final RedirectAttributes redirectAttributes) {
        //On récupère l'utilisateur en session
        final var utilisateurConnecteDto = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        final var id = Integer.valueOf(utilisateurConnecteDto.getIdUtilisateur());
        final var role = Integer.valueOf(utilisateurConnecteDto.getIdRole());

        final var modelAndView = new ModelAndView();

        //appel de la méthode de suppression et stockage du retour dans variable result
        final boolean result = iUtilisateurService.deleteUtilisateurById(id, role);
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
}
