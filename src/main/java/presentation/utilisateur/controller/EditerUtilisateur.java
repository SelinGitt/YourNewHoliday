/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.utilisateur.IUtilisateurService;

/**
 * Classe EditerUtilisateur
 *
 * @author Valentin
 */
@Controller
@RequestMapping("/modifierUtilisateur.do")
public class EditerUtilisateur {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet de recuperer l'utilisateur et d'afficher la jsp
     * 
     * @param  reference Reference a rechercher
     * @return           ModelAndView avec le nom de la jsp et l'utilisateur en attribut
     */
    @GetMapping
    public ModelAndView modifierUtilisateur(@RequestParam("ref") final String reference) {
        final var modelAndView = new ModelAndView("modifierUtilisateur");
        modelAndView.getModelMap().addAttribute("utilisateur", this.iUtilisateurService.findByReference(reference));
        return modelAndView;
    }

}
