/**
 * 
 */
package presentation.temp;

import java.util.Locale;

import presentation.panier.dto.LigneCommandeProduitDto;
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
        produitDto1.setIdProduitOriginal("11");
        produitDto1.setDescription("Description tr�s courte du voyage sur deux ou trois lignes maximum");
        produitDto1.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(200.30, Locale.FRANCE));
        produitDto1.setNom("Voyage au Royaume Uni de Grande Bretagne et d'Irlande du nord");
        produitDto1.setReference("ABC1234567");
        produitDto1.setCheminImage(null);
        // ProduitDto2
        final var produitDto2 = new ProduitDto();
        produitDto2.setIdProduitOriginal("12");
        produitDto2.setDescription("Description tr�s courte du voyage sur deux ou trois lignes maximum");
        produitDto2.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(9000.00));
        produitDto2.setNom("Voyage aux Etats Unis d'Am�rique");
        produitDto2.setReference("CCC1865521");
        produitDto2.setCheminImage(null);
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setIdProduitOriginal("13");
        produitDto3.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto3.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(12000.00));
        produitDto3.setNom("Voyage au Canada");
        produitDto3.setReference("AAA1256568");
        produitDto3.setCheminImage(null);
        // Produit avec �quivalence en base 
        final var produitDto4 = new ProduitDto();
        produitDto4.setIdProduitOriginal("4");
        produitDto4.setDescription("La m�dit�rann�e, le colys�e, les p�tes !");
        produitDto4.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(300.00));
        produitDto4.setNom("Voyage en Italie");
        produitDto4.setReference("ITA1289967");
        produitDto4.setCheminImage(null);

        // ajout des lignes de commande
        final var ligneCommandeProduit = new LigneCommandeProduitDto();
        ligneCommandeProduit.setQuantite(6);
        ligneCommandeProduit.setPrix(DecimalFormatUtils.decimalFormatUtil(6 * 200.30, Locale.FRANCE));
        final var ligneCommandeProduit2 = new LigneCommandeProduitDto();
        ligneCommandeProduit2.setQuantite(8);
        ligneCommandeProduit2.setPrix(DecimalFormatUtils.decimalFormatUtil(8 * 9000.00, Locale.FRANCE));
        final var ligneCommandeProduit3 = new LigneCommandeProduitDto();
        ligneCommandeProduit3.setQuantite(12);
        ligneCommandeProduit3.setPrix(DecimalFormatUtils.decimalFormatUtil(12 * 12000.00, Locale.FRANCE));
        final var ligneCommandeProduit4 = new LigneCommandeProduitDto();
        ligneCommandeProduit4.setQuantite(3);
        ligneCommandeProduit4.setPrix(DecimalFormatUtils.decimalFormatUtil(4 * 300.00, Locale.FRANCE));

        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto4, ligneCommandeProduit4);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto2, ligneCommandeProduit2);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3, ligneCommandeProduit3);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());

        return panierDto;
    }
}
