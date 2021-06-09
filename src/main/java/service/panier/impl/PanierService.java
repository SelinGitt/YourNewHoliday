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
        if (produitAjout == null) {
            return panier;
        }
        final Map<ProduitDto, Integer> mapPanier = panier.getMapPanier();
        final Integer quantiteAncienne = mapPanier.get(produitAjout);
        Integer quantiteAjout = quantite;
        if (quantiteAncienne != null) {
            quantiteAjout += quantiteAncienne;
        }
        if (quantiteAjout < 1) {
            mapPanier.remove(produitAjout);
            panier.setNombreDeReferences(panier.getMapPanier().size());
            return panier;
        }
        mapPanier.put(produitAjout, quantiteAjout);
        panier.setNombreDeReferences(panier.getMapPanier().size());
        return panier;
    }

}
