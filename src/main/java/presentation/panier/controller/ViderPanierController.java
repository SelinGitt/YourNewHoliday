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
 * Classe représentant le Controller de ViderPanier
 *
 * @author Alexandre
 */
@Controller
@RequestMapping("/viderPanier.do")
public class ViderPanierController {

    @Autowired
    private IPanierService panierService;

    /**
     * Permet de vider le panier
     *
     * @param  panierDto : le panier dto a vider
     * @return           : le panier
     */
    @GetMapping
    public ModelAndView viderPanierProduits(final @SessionAttribute("panierDto") PanierDto panierDto) {
        final var modelAndView = new ModelAndView();

        //appelle methode Service
        panierService.viderPanier(panierDto);
        
        //renvoyer vers listerPanierProduitController
        modelAndView.setViewName("redirect:listerPanierProduits.do");
        return modelAndView;
    }
}
