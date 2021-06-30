/**
 * 
 */
package presentation.panier.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.produit.IProduitService;
import service.produit.impl.ProduitService;

/**
 * Class represents PanierProduitsController
 *
 * @author Steve
 */
@Controller
@RequestMapping("/listerPanierProduits.do")
public class ListerPanierProduitsController {

    private IProduitService produitService = new ProduitService();

    /**
     * Permet d'afficher la page PanierProduits
     * 
     * @param  panierDto : panierDto vide
     * @return           le nom de la définition pour PanierProduits
     */
    @GetMapping
    public ModelAndView displayPanierProduits(final @SessionAttribute("panierDto") PanierDto panierDto) {
        final var modelAndView = new ModelAndView();

        //si le panier recuperer est vide
        if (panierDto.getMapPanier().isEmpty()) {
            modelAndView.setViewName("pan_00_vide");
        } else {
            modelAndView.setViewName("pan_00");
        }
        return modelAndView;
    }

    public String choixAction(final HttpSession session, final HttpServletRequest request) {
        final String action = request.getParameter("action");
        if ("supprimer_produit".equals(action)) {
            final PanierDto panier = (PanierDto) session.getAttribute("panierDto");
            final ProduitDto produitToDelete = produitService.trouverProduitEnVente(Integer.valueOf(request.getParameter("id")));
            session.setAttribute("panierDto", this.supprimerProduitPanier(panier, produitToDelete));
        }
        return "listerPanierProduits";
    }

    public PanierDto supprimerProduitPanier(final PanierDto panier, final ProduitDto produitToDelete) {
        final Map<ProduitDto, Integer> mapPanier = panier.getMapPanier();
        mapPanier.remove(produitToDelete);
        return panier;
    }

}
