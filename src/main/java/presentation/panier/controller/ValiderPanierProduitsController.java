/**
 * 
 */
package presentation.panier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller permettant de valider le panier produits
 *
 * @author NathanR
 */
@Controller
@RequestMapping("/validerPanierProduits.do")
public class ValiderPanierProduitsController {

    /**
     * Permet d'afficher la page PanierAdresses
     *
     * @return : la vue de la page PAN_08
     */
    @GetMapping
    public ModelAndView validatePanierProduits() {
        return new ModelAndView("redirect:listerPanierAdresses.do");
    }
}
