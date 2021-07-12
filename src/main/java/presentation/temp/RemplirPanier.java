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
        // ProduitDto2
        //        final var produitDto2 = new ProduitDto();
        //        produitDto2.setIdProduitOriginal("2");
        //        produitDto2.setVersion("1");
        //        produitDto2.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        //        produitDto2.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(500.00));
        //        produitDto2.setNom("Voyage aux Etats Unis d'Amérique");
        //        produitDto2.setReference("CCC1865521");
        //        produitDto2.setCheminImage(null);
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
        // ProduitDto4
        //        final var produitDto4 = new ProduitDto();
        //        produitDto4.setIdProduitOriginal("4");
        //        produitDto4.setVersion("2");
        //        produitDto4.setDescription(
        //                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        //        produitDto4.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(1.90));
        //        produitDto4.setNom("Voyage au coin de la rue");
        //        produitDto4.setReference("ZZZ9696969");
        //        produitDto4.setCheminImage(null);
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
        // ProduitDto6
        //        final var produitDto6 = new ProduitDto();
        //        produitDto6.setIdProduitOriginal("6");
        //        produitDto6.setVersion("1");
        //        produitDto6.setDescription(
        //                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        //        produitDto6.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(1500.00));
        //        produitDto6.setNom("Voyage voyage et jamais ne reviens");
        //        produitDto6.setReference("AAA6666666");
        //        produitDto6.setCheminImage(null);

        // Produit avec équivalence en base 
        //        final var produitDto7 = new ProduitDto();
        //        produitDto7.setIdProduitOriginal("7");
        //        produitDto7.setVersion("0");
        //        produitDto7.setDescription("La méditérannée, le colysée, les pâtes !");
        //        produitDto7.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(300.00));
        //        produitDto7.setNom("Voyage en Italie");
        //        produitDto7.setReference("ITA1289967");
        //        produitDto7.setCheminImage(null);

        // ajout des lignes de commande
        final var ligneCommandeProduit = new LigneCommandeProduitDto();
        ligneCommandeProduit.setQuantite(6);
        ligneCommandeProduit.setPrix(DecimalFormatUtils.decimalFormatUtil(6 * 200.30, Locale.FRANCE));
        final var ligneCommandeProduit2 = new LigneCommandeProduitDto();
        ligneCommandeProduit2.setQuantite(8);
        ligneCommandeProduit2.setPrix(DecimalFormatUtils.decimalFormatUtil(8 * 700.00, Locale.FRANCE));
        final var ligneCommandeProduit3 = new LigneCommandeProduitDto();
        ligneCommandeProduit3.setQuantite(1);
        ligneCommandeProduit3.setPrix(DecimalFormatUtils.decimalFormatUtil(1 * 500.00, Locale.FRANCE));
        final var ligneCommandeProduit4 = new LigneCommandeProduitDto();
        ligneCommandeProduit4.setQuantite(3);
        ligneCommandeProduit4.setPrix(DecimalFormatUtils.decimalFormatUtil(3 * 1.90, Locale.FRANCE));
        final var ligneCommandeProduit5 = new LigneCommandeProduitDto();
        ligneCommandeProduit5.setQuantite(2);
        ligneCommandeProduit5.setPrix(DecimalFormatUtils.decimalFormatUtil(2 * 999.00, Locale.FRANCE));
        final var ligneCommandeProduit6 = new LigneCommandeProduitDto();
        ligneCommandeProduit6.setQuantite(3);
        ligneCommandeProduit6.setPrix(DecimalFormatUtils.decimalFormatUtil(3 * 1500.00, Locale.FRANCE));
        final var ligneCommandeProduit7 = new LigneCommandeProduitDto();
        ligneCommandeProduit7.setQuantite(3);
        ligneCommandeProduit7.setPrix(DecimalFormatUtils.decimalFormatUtil(3 * 300.00, Locale.FRANCE));

        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        //        panierDto.getMapPanier().put(produitDto2, ligneCommandeProduit2);
        //        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3, ligneCommandeProduit3);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        //        panierDto.getMapPanier().put(produitDto4, ligneCommandeProduit4);
        //        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto5, ligneCommandeProduit5);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        //        panierDto.getMapPanier().put(produitDto6, ligneCommandeProduit6);
        //        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        //        panierDto.getMapPanier().put(produitDto7, ligneCommandeProduit7);
        //        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        return panierDto;
    }
}
