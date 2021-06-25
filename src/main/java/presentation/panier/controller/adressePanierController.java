/**
 * 
 */
package presentation.panier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe représentant le controller de adressePanierController
 *
 * @author Alexandre
 *
 */
@Controller
@RequestMapping("/listerPanierAdresses.do")
public class adressePanierController {

    
    /**
     * Permet d'aficher la jsp listerPanierAdresses
     *
     * @return : le nom de la jsp
     */
    @GetMapping
    public String listerAdresses() {
        
    return "listerPanierAdresses";
    }
}
