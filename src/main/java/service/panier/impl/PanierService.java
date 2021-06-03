/**
 * 
 */
package service.panier.impl;

import org.springframework.beans.factory.annotation.Autowired;

import presentation.panier.dto.PanierDto;
import service.panier.IPanierService;
import service.produit.IProduitService;

/**
 * Classe représentant l'interface métier {@link IPanierService}
 *
 * @author NathanR
 */
public class PanierService implements IPanierService {

    @Autowired
    private IProduitService iProduitService;

    @Override
    public PanierDto updatePanier(final PanierDto panier, final Integer idProduit, final Integer quantité) {
        panier.getMapPanier().put(iProduitService.trouverProduitEnVente(idProduit), quantité);
        return panier;
    }

}
