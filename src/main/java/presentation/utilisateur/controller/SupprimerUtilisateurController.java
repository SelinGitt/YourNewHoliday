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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.utilisateur.IUtilisateurService;
import service.utilisateur.impl.UtilisateurServiceReturn;

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
     * @param  origin             : page d'origine (USR_00 ou USR_01)
     * @param  ref                : r�f�rence de l'utilisateur � supprimer
     * @param  redirectAttributes : attributs de redirection
     * @return                    un ModelAndView
     */
    @GetMapping
    public ModelAndView supprimerUtilisateur(final HttpSession session, final @RequestParam(name = "origin") String origin,
            final @RequestParam(name = "ref") String ref, final RedirectAttributes redirectAttributes) {

        final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        final Integer id = Integer.valueOf(utilisateurConnecte.getIdUtilisateur());

        //appel de la m�thode de suppression et stockage du retour dans variable result
        final UtilisateurServiceReturn result = iUtilisateurService.deleteUtilisateurByRef(id, ref, origin);

        System.out.println(result.isSucceeded() + " is same : " + result.isSameUserFromList());
        final ModelAndView modelAndView = new ModelAndView();

        //Si l'admin se supprime depuis la liste et que �a fonctionne
        if (result.isSameUserFromList() && result.isSucceeded()) {
            modelAndView.setViewName("redirect:/deconnecter.do");
            modelAndView.getModelMap().addAttribute("deletionSuccess", "usr00.success.deleted");
            return modelAndView;
        }

        //Si la suppression de fait depuis -> consulter son profil /USR00
        if ("1".equals(origin)) {
            if (result.isSucceeded()) {
                modelAndView.setViewName("redirect:/deconnecter.do");
                modelAndView.getModelMap().addAttribute("deletionSuccess", "usr00.success.deleted");
                return modelAndView;
            }
            modelAndView.setViewName("forward:/consulterUtilisateur.do");
            modelAndView.getModelMap().addAttribute("error", "usr00.erreur.last_admin");
            return modelAndView;
        } else
            if ("2".equals(origin)) {
                //Si la suppression de fait depuis -> liste des utilisateurs /USR01
                modelAndView.setViewName("forward:/listerUtilisateur.do");
                if (result.isSucceeded()) {
                    modelAndView.getModelMap().addAttribute("deletionSuccess", "usr01.success.deleted");
                    return modelAndView;
                }
                modelAndView.getModelMap().addAttribute("error", "usr01.erreur.last_admin");
                return modelAndView;
            } else {
                modelAndView.setViewName("/404.do");
                return modelAndView;
            }
    }
}
