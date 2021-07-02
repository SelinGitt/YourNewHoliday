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
 * Class represents PanierProduitsController
 *
 * @author Steve
 */
@Controller
@RequestMapping("/listerPanierProduits.do")
public class ListerPanierProduitsController {

    @Autowired
    private IPanierService panierService;

    /**
     * Permet d'afficher la page PanierProduits
     * 
     * @param  panierDto : panierDto vide
     * @return           le nom de la d�finition pour PanierProduits
     */
    @GetMapping
    public ModelAndView displayPanierProduits(final @SessionAttribute("panierDto") PanierDto panierDto) {
        final var modelAndView = new ModelAndView();
        // on met � jour le prix total du panier
        panierDto.setPrixTotal(panierService.calculerPrixTotal(panierDto));
        // on applique la remise si les conditions sont r�unies
        panierService.appliquerRemise(panierDto);

        // si le panier recuper� est vide
        if (panierDto.getMapPanier().isEmpty()) {
            modelAndView.setViewName("pan_00_vide");
        } else {
            modelAndView.setViewName("pan_00");
        }

        return modelAndView;
    }

}
