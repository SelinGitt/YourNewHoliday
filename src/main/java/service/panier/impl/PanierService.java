/**
 * 
 */
package service.panier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import presentation.panier.dto.PanierDto;
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
    public PanierDto updatePanier(final PanierDto panier, final Integer idProduit, final Integer quantit�) {
        panier.getMapPanier().put(iProduitService.trouverProduitEnVente(idProduit), quantit�);
        return panier;
    }

}
