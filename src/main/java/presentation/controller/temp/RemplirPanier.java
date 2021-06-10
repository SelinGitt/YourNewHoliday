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
        produitDto1.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto1.setPrixUnitaire("200");
        produitDto1.setNom("Voyage au royaume uni de Grange Bretagne et d'Irlande du nord");
        produitDto1.setReference("0236544ddf");
        produitDto1.setCheminImage(null);
        // ProduitDto2
        final var produitDto2 = new ProduitDto();
        produitDto2.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto2.setPrixUnitaire("123");
        produitDto2.setNom("Voyage aux états unis d'Amérique");
        produitDto2.setReference("0298544ddf");
        produitDto2.setCheminImage(null);
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setDescription("Description courte du voyage sur deux ou trois lignes maximum, un peu d etexte ne plus pour tester l'affichage");
        produitDto3.setPrixUnitaire("12300");
        produitDto3.setNom("Voyage au Canada");
        produitDto3.setReference("0298544ddf");
        produitDto3.setCheminImage(null);
        
        
        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, 6);
        panierDto.setNombreDeReferences(1+ panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto2, 2);
        panierDto.setNombreDeReferences(1+ panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3,128);
        panierDto.setNombreDeReferences(1+ panierDto.getNombreDeReferences());

        return panierDto;
    }
}
