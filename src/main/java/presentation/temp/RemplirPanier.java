/**
 * 
 */
package presentation.temp;

import java.util.Locale;

import presentation.panier.dto.LigneCommandeProduit;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.util.DecimalFormatUtils;

/**
 * Class represents RemplirPanier : static methods provider
 *
 * @author Steve
 */
public class RemplirPanier {

    //TODO TEMP: a supprimer par la suite 

    // avoid to instanciate this class
    private RemplirPanier() {
        // empty
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
        produitDto1.setIdProduitOriginal("un");
        produitDto1.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto1.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(200.30, Locale.FRANCE));
        produitDto1.setNom("Voyage au Royaume Uni de Grande Bretagne et d'Irlande du nord");
        produitDto1.setReference("ABC1234567");
        produitDto1.setCheminImage(null);
        // ProduitDto2
        final var produitDto2 = new ProduitDto();
        produitDto2.setIdProduitOriginal("deux");
        produitDto2.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto2.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(9000.00));
        produitDto2.setNom("Voyage aux Etats Unis d'Amérique");
        produitDto2.setReference("CCC1865521");
        produitDto2.setCheminImage(null);
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setIdProduitOriginal("trois");
        produitDto3.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto3.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(12000.00));
        produitDto3.setNom("Voyage au Canada");
        produitDto3.setReference("AAA1256568");
        produitDto3.setCheminImage(null);

        // ajout des lignes de commande
        final LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit();
        ligneCommandeProduit.setQuantite(6);
        final LigneCommandeProduit ligneCommandeProduit2 = new LigneCommandeProduit();
        ligneCommandeProduit.setQuantite(2);
        final LigneCommandeProduit ligneCommandeProduit3 = new LigneCommandeProduit();
        ligneCommandeProduit.setQuantite(128);

        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto2, ligneCommandeProduit2);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3, ligneCommandeProduit3);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());

        return panierDto;
    }
}
