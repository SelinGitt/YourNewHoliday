/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller de la vue USR00 pour consulter un profil Utilisateur
 *
 * @author Damien D.
 */
@Controller
@RequestMapping("/consulterUtilisateur.do")
@SessionAttributes("utilisateur")
public class ConsulterUtilisateurController {

    /**
     * Permet de XX
     *
     * @return
     */
    @GetMapping
    public ModelAndView afficher() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterUtilisateur");
        return modelAndView;
    }
}
