/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Controller pour cr�ation d'un utilisateur
 *
 * @author Selin
 */
@Controller
@RequestMapping("/creerUtilisateur.do")
public class CreerUtilisateurController {

    /**
     * Permet de traiter les requ�tes GET<br/>
     * et de mettre un UtilisateurDto vide dans le mod�le
     * 
     * @return le Model and View
     */
    @GetMapping
    public ModelAndView afficher() {
        final ModelAndView modelAndView = new ModelAndView("creer");
        modelAndView.getModelMap().addAttribute("creer", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de traiter les requ�tes POST<br/>
     * et de cr�er un utilisateur
     *
     * @param  utilisateurDto l'utilisateur � cr�er
     * @return                lien vers la jsp
     */
    @PostMapping
    public String processSubmit(final UtilisateurDto utilisateurDto) {
        return "redirect:jsp/utilisateur/creerUtilisateur.jsp";
    }
}
