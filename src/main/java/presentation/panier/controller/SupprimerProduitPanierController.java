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

    /**
     * Permet de supprimer une ligne du panier
     *
     * @param  session : le scope session
     * @param  request : le scope request
     * @return         : le nom de la vue vers laquelle on souhaite se diriger
     */
    @GetMapping
    public String supprimerProduitPanier(final HttpSession session, final HttpServletRequest request) {
        final PanierDto panier = (PanierDto) session.getAttribute("panierDto");
        final ProduitDto produitToDelete = findProduitMap(panier, Integer.valueOf(request.getParameter("id")));
        final Map<ProduitDto, Integer> mapPanier = panier.getMapPanier();
        mapPanier.remove(produitToDelete);
        panier.setNombreDeReferences(mapPanier.size());
        if (mapPanier.isEmpty()) {
            return "pan_00_vide";
        }
        return "pan_00";
    }

    /**
     * Permet de retrouver un produit dans la map à partir de son ID
     *
     * @param  panier    : le panier en session
     * @param  idProduit : l'id du produit recherché
     * @return           : le produit recherché
     */
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
