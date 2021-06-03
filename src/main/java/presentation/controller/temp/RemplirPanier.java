/**
 * 
 */
package presentation.controller.temp;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;

/**
 * Class represents RemplirPanier
 *
 * @author Steve
 *
 */
public class RemplirPanier {
    
    
    public static PanierDto echantillon() {
        final PanierDto panierDto = new PanierDto();
        final ProduitDto produitDto1 = new ProduitDto();
        produitDto1.setDescription("Description courte");
        produitDto1.setPrixUnitaire("200");
        produitDto1.setNom("Voyage");
        produitDto1.setReference("0236544ddf");
        produitDto1.setCheminImage(null);
        
        final ProduitDto produitDto2 = new ProduitDto();
        produitDto2.setDescription("Description très courte");
        produitDto2.setPrixUnitaire("123");
        produitDto2.setNom("Voyage moins loin");
        produitDto2.setReference("0298544ddf");
        produitDto2.setCheminImage(null);
        
        panierDto.getMapPanier().put(produitDto1, 6);
        panierDto.getMapPanier().put(produitDto2, 2);
        
        
        // FIXME
        return panierDto;
    }
    

}
