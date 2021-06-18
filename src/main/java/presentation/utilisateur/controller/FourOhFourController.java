/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe FourOhFourController <br>
 * Controller pour la page 404
 *
 * @author Valentin
 */
@Controller
@RequestMapping("/404.do")
public class FourOhFourController {

    /**
     * Permet de traiter les requêtes GET
     * 
     * @return le Model and View
     */
    @GetMapping
    public ModelAndView afficher() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("404");
        return modelAndView;
    }
}
