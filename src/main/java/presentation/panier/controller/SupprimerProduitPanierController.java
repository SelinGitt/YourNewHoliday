/**
 * 
 */
package presentation.panier.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;

/**
 * Classe représentant le controller pour la suppression d'un produit du panier
 *
 * @author NathanR
 */
@Controller
@RequestMapping("/supprimerProduitPanier.do")
public class SupprimerProduitPanierController {

    @Autowired
    private IPanierService panierService;

    /**
     * Permet de supprimer une ligne du panier
     * 
     * @param  panier  : le panier en session
     * @param  request : le scope request
     * @return         : le nom de la vue vers laquelle on souhaite se diriger
     */
    @GetMapping
    public String supprimerProduitPanier(final @SessionAttribute("panierDto") PanierDto panier, final HttpServletRequest request) {
        final Map<ProduitDto, LigneCommandeProduitDto> mapPanier = panier.getMapPanier();
        final ProduitDto produitToDelete = panierService.findProduitMap(panier, Integer.valueOf(request.getParameter("id")));
        final Integer quantite = mapPanier.get(produitToDelete).getQuantite();
        panierService.updatePanier(panier, Integer.valueOf(request.getParameter("id")), -quantite);
        if (mapPanier.isEmpty()) {
            return "pan_00_vide";
        }
        return "pan_00";
    }
}
