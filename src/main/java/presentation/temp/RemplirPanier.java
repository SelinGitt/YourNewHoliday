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
        produitDto1.setIdProduitOriginal("1");
        produitDto1.setVersion("2");
        produitDto1.setDestination("Maldives");
        produitDto1.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto1.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(200.30, Locale.FRANCE));
        produitDto1.setNom("Voyage au Maldives");
        produitDto1.setReference("MVR1256934");
        produitDto1.setServices("1");
        produitDto1.setHebergement("Maison dHotes");
        produitDto1.setCheminImage("maldives.jpg");
        produitDto1.setMiseEnVente("true");
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setIdProduitOriginal("3");
        produitDto3.setVersion("1");
        produitDto3.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto3.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(700.00));
        produitDto3.setDestination("espagne");
        produitDto3.setNom("Voyage au Canada");
        produitDto3.setReference("SPA1278951");
        produitDto3.setServices("2");
        produitDto3.setCheminImage("espagne.jpg");
        produitDto3.setHebergement("chambre dhôtel");
        produitDto3.setMiseEnVente("true");
        // ProduitDto5
        final var produitDto5 = new ProduitDto();
        produitDto5.setIdProduitOriginal("5");
        produitDto5.setVersion("1");
        produitDto5.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto5.setDestination("tokyo");
        produitDto5.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(999.00));
        produitDto5.setNom("Voyage avec toi");
        produitDto5.setReference("TYO1299974");
        produitDto5.setServices("3");
        produitDto5.setCheminImage("tokyo.jpg");
        produitDto5.setHebergement("Appartement");
        produitDto5.setMiseEnVente("true");

        // ajout des lignes de commande
        final var ligneCommandeProduit = new LigneCommandeProduitDto();
        ligneCommandeProduit.setQuantite(6);
        ligneCommandeProduit.setPrix(DecimalFormatUtils.decimalFormatUtil(6 * 200.30, Locale.FRANCE));
        final var ligneCommandeProduit3 = new LigneCommandeProduitDto();
        ligneCommandeProduit3.setQuantite(1);
        ligneCommandeProduit3.setPrix(DecimalFormatUtils.decimalFormatUtil(1 * 500.00, Locale.FRANCE));
        final var ligneCommandeProduit5 = new LigneCommandeProduitDto();
        ligneCommandeProduit5.setQuantite(2);
        ligneCommandeProduit5.setPrix(DecimalFormatUtils.decimalFormatUtil(2 * 999.00, Locale.FRANCE));

        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3, ligneCommandeProduit3);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto5, ligneCommandeProduit5);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        return panierDto;
    }
}
