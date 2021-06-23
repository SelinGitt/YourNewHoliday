/**
 * 
 */
package presentation.panier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe représentant le controller de listerPanierAdresses
 *
 * @author Alexandre
 */
@Controller
@RequestMapping("/listerPanierAdresses.do")
public class listerPanierAdressesController {

    /**
     * Permet d'afficher la JSP listerPanierAdresses
     *
     * @return : le nom de la JSP
     */
    @GetMapping
    public String ListerAdresses() {

        return "listerPanierAdresses";
    }
}
