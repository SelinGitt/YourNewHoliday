/**
 * 
 */
package service.panier.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;

/**
 * Classe représentant l'interface métier {@link IPanierService}
 *
 * @author NathanR
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PanierService implements IPanierService {

    @Autowired
    private IProduitService iProduitService;

    @Override
    public PanierDto updatePanier(final PanierDto panier, final Integer idProduit, final Integer quantite) {
        final ProduitDto produitAjout = iProduitService.trouverProduitEnVente(idProduit);
        // si le produit à ajouter n'est pas en vente ou n'est pas en base, 
        // alors le panier reste inchangé.
        if (produitAjout == null) {
            return panier;
        }
        final Map<ProduitDto, Integer> mapPanier = panier.getMapPanier();
        Integer quantiteProduit = mapPanier.get(produitAjout);
        // si le produit était déjà dans le panier, on met à jour sa quantité.
        if (quantiteProduit == null) {
            quantiteProduit = quantite;
            // sinon, le nombre de produits ajoutés à la map correspondra à la quantité en paramètre.
        } else {
            quantiteProduit += quantite;
        }
        // si la quantité du produit que l'on met à jour devient nulle ou négative, 
        // alors le produit est supprimé du panier.
        if (quantiteProduit < 1) {
            mapPanier.remove(produitAjout);
            // on met à jour le produit dans la map du panier avec sa nouvelle quantité.
        } else {
            mapPanier.put(produitAjout, quantiteProduit);
        }
        // on met à jour le nombre de référence dans le panier.
        panier.setNombreDeReferences(panier.getMapPanier().size());
        return panier;
    }

}
