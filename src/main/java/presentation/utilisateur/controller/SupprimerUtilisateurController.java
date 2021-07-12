/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
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
     * @param  session             : la session en cours
     * @param  origin              : page d'origine (USR_00 ou USR_01)
     * @param  ref                 : référence de l'utilisateur à supprimer
     * @param  redirectAttributes  : attributs de redirection
     * @param  utilisateurConnecte : utilisateur connecté en session
     * @return                     un ModelAndView
     */
    @GetMapping
    public ModelAndView supprimerUtilisateur(final HttpSession session, final @RequestParam(name = "origin") String origin,
            final @RequestParam(name = "ref") String ref, final RedirectAttributes redirectAttributes,
            final @SessionAttribute("utilisateur") UtilisateurConnecteDto utilisateurConnecte) {

        final var idUtilisateurConnecte = Integer.valueOf(utilisateurConnecte.getIdUtilisateur());

        //appel de la méthode de suppression et stockage du retour dans variable result
        final var result = iUtilisateurService.deleteUtilisateurByRef(idUtilisateurConnecte, ref, origin);
        //Création du ModelAndView
        final var modelAndView = new ModelAndView();

        //Si la suppression est un succès
        if (result.isSucceeded()) {
            //Si depuis la vue Consulter son profil, ou si l'admin se supprime lui-même depuis la liste des utilisateurs
            if ("1".equals(origin) || result.isSameUserFromList()) {
                modelAndView.setViewName("redirect:/deconnecter.do");
                modelAndView.getModelMap().addAttribute("deletionSuccess", "usr00.success.deleted");
                return modelAndView;
            }
            //Si depuis la vue liste des utilisateurs
            modelAndView.setViewName("forward:/listerUtilisateur.do");
            modelAndView.getModelMap().addAttribute("deletionSuccess", "usr01.success.deleted");
            return modelAndView;
        }
        //La suppression est un échec
        //Si depuis la vue Consulter son profil
        if ("1".equals(origin)) {
            modelAndView.setViewName("forward:/consulterUtilisateur.do");
            modelAndView.getModelMap().addAttribute("error", "usr00.erreur.last_admin");
            return modelAndView;
        }
        //Si depuis la vue liste des utilisateurs
        modelAndView.setViewName("forward:/listerUtilisateur.do");
        modelAndView.getModelMap().addAttribute("error", "usr01.erreur.last_admin");
        return modelAndView;
    }
}
