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
 * Classe repr�sentant l'interface m�tier {@link IPanierService}
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
        // si le produit � ajouter n'est pas en vente ou n'est pas en base, 
        // alors le panier reste inchang�.
        if (produitAjout == null) {
            return panier;
        }
        final Map<ProduitDto, Integer> mapPanier = panier.getMapPanier();
        Integer quantiteProduit = mapPanier.get(produitAjout);
        // si le produit �tait d�j� dans le panier, on met � jour sa quantit�.
        if (quantiteProduit == null) {
            quantiteProduit = quantite;
            // sinon, le nombre de produits ajout�s � la map correspondra � la quantit� en param�tre.
        } else {
            quantiteProduit += quantite;
        }
        // si la quantit� du produit que l'on met � jour devient nulle ou n�gative, 
        // alors le produit est supprim� du panier.
        if (quantiteProduit < 1) {
            mapPanier.remove(produitAjout);
            // on met � jour le produit dans la map du panier avec sa nouvelle quantit�.
        } else {
            mapPanier.put(produitAjout, quantiteProduit);
        }
        // on met � jour le nombre de r�f�rence dans le panier.
        panier.setNombreDeReferences(panier.getMapPanier().size());
        return panier;
    }

}
