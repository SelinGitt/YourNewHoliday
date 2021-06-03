/**
 * 
 */
package presentation.controller.temp;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;

/**
 * Class represents RemplirPanier : static methods provider
 *
 * @author Steve
 */
public class RemplirPanier {
    // avoid to instaciate this class
    private RemplirPanier() {

    }

    /**
     * Allows to get product's sample dataset in PanierDto
     *
     * @return PanierDto with few products.
     */
    public static PanierDto echantillon() {
        // PanierDto
        final var panierDto = new PanierDto();
        // ProduitDto1
        final var produitDto1 = new ProduitDto();
        produitDto1.setDescription("Description courte");
        produitDto1.setPrixUnitaire("200");
        produitDto1.setNom("Voyage");
        produitDto1.setReference("0236544ddf");
        produitDto1.setCheminImage(null);
        // ProduitDto2
        final var produitDto2 = new ProduitDto();
        produitDto2.setDescription("Description très courte");
        produitDto2.setPrixUnitaire("123");
        produitDto2.setNom("Voyage moins loin");
        produitDto2.setReference("0298544ddf");
        produitDto2.setCheminImage(null);
        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, 6);
        panierDto.getMapPanier().put(produitDto2, 2);
        
        return panierDto;
    }
}
