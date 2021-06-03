/**
 * 
 */
package presentation.panier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class represents PanierProduitsController
 *
 * @author Steve
 *
 */
@Controller
@RequestMapping("/panierProduits.do")
public class PanierProduitsController {
    /**
     * Permet d'afficher la page PanierProduits
     *
     * @return le nom de la définition pour PanierProduits
     */
    @GetMapping
    public String displayPanierProduits() {
        return "pan_00";
    }   
}
