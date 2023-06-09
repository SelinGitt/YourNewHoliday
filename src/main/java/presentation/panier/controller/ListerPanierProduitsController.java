/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     * @param  panierDto   : panierDto vide
     * @param  listIdError : la liste des Id probl�matiques
     * @return             le nom de la d�finition pour PanierProduits
     */
    @GetMapping
    public ModelAndView displayPanierProduits(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @ModelAttribute("listIdError") String listIdError) {
        final var modelAndView = new ModelAndView();
        // on met � jour le prix total, la remise et le prix apr�s remise du panier
        panierService.actualiserPrix(panierDto);
        // si le panier recuper� est vide
        if (panierDto.getMapPanier().isEmpty()) {
            modelAndView.setViewName("pan_00_vide");
            modelAndView.getModelMap().addAttribute("errorPanVide", "pan00.erreur.vide");
        } else {
            // On passe la liste des Id probl�matiques en attribut pour les renvoyer au controller suivant
            modelAndView.getModelMap().addAttribute("listIdError", listIdError);
            modelAndView.setViewName("pan_00");
        }
        return modelAndView;
    }

}
