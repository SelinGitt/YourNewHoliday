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

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;

/**
 * Classe représentant le controller pour la suppression d'un produit du panier
 *
 * @author NathanR
 */
@Controller
@RequestMapping("/supprimerProduitPanier.do")
public class SupprimerProduitPanierController {

    @GetMapping
    public String supprimerProduitPanier(final HttpSession session, final HttpServletRequest request) {
        final PanierDto panier = (PanierDto) session.getAttribute("panierDto");
        final ProduitDto produitToDelete = findProduitMap(panier, Integer.valueOf(request.getParameter("id")));
        panier.getMapPanier().remove(produitToDelete);
        return "listerPanierProduits";
    }

    public ProduitDto findProduitMap(final PanierDto panier, final Integer idProduit) {
        final Map<ProduitDto, Integer> mapPanier = panier.getMapPanier();
        for (final ProduitDto produit : mapPanier.keySet()) {
            if (Integer.valueOf(produit.getIdProduitOriginal()) == idProduit) {
                return produit;
            }
        }
        return null;
    }
}
