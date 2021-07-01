/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import service.panier.IPanierService;

/**
 * Class represents controller pour les boutons modifiant la quantité d'une produit du panier
 *
 * @author Steve
 */

@Controller
@RequestMapping("/modifierQuantite.do")
public class ModifierQuantiteController {
    @Autowired
    private IPanierService panierService;

    @GetMapping
    public ModelAndView modifierQuantite(final @SessionAttribute("panierDto") PanierDto panierDto) {
        final var modelAndView = new ModelAndView();

        System.out.println("coucou");
        //renvoyer vers listerPanierProduitController
        modelAndView.setViewName("redirect:listerPanierProduits.do");
        return modelAndView;
    }

}
