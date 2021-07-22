/**
 * 
 */
package service.commande.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.CommandeAdresseDto;
import presentation.commande.dto.CommandeDto;
import presentation.commande.dto.CommandeProduitDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.commande.ICommandeService;
import service.util.DecimalFormatUtils;

/**
 * JUnit pour tester le service de la commande
 *
 * @author Hanan Anghari
 */
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de données avec les bonnes données 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
class CommandeServiceTest {

    @Autowired
    private ICommandeService commandeService;

    /**
     * Test method for {@link service.commande.impl.CommandeService}
     */
    @Test
    void testAutowired() {
        assertNotNull(commandeService);
    }

    /**
     * Test method for {@link service.commande.impl.CommandeService#listerCommandesUtilisateur(java.lang.Integer)}.
     */
    @Test
    void testListerCommandesUtilisateur() {

        assertEquals(2, commandeService.listerCommandesUtilisateur(2).size());
    }

    /**
     * Test method for {@link service.commande.impl.CommandeService#chercherCommandeParReference(java.lang.String)}.
     */
    @Test
    void testTrouverCommandeParReference() {
        final CommandeDto commandeDto = commandeService.chercherCommandeParReference("ABC1");
        assertNotNull(commandeDto);
        assertEquals("1", commandeDto.getId());
        assertEquals("ABC1", commandeDto.getReference());
        assertEquals("09/02/2021", commandeDto.getDate());
        final String nombre = DecimalFormatUtils.decimalFormatUtil(1200.00);
        assertEquals(nombre, commandeDto.getPrixTotal());
        final List<CommandeProduitDto> listCommandeProduitDto = commandeDto.getListCommandeProduitDto();
        assertNotNull(listCommandeProduitDto);
        assertEquals(2, listCommandeProduitDto.size());
    }

    /**
     * Test method for {@link service.commande.impl.CommandeService#verifierProduitsAvecVersion(java.util.Map)}.
     */
    @Test
    void testVerifierProduitsAvecVersion() {
        // PanierDto
        final var panierDto = new PanierDto();
        // ProduitDto1
        final var produitDto1 = new ProduitDto();
        produitDto1.setIdProduitOriginal("1");
        produitDto1.setVersion("1");
        produitDto1.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto1.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(200.30, Locale.FRANCE));
        produitDto1.setNom("Voyage au Royaume Uni de Grande Bretagne et d'Irlande du nord");
        produitDto1.setReference("ABC1234567");
        produitDto1.setCheminImage(null);
        // ProduitDto2
        final var produitDto2 = new ProduitDto();
        produitDto2.setIdProduitOriginal("2");
        produitDto2.setVersion("1");
        produitDto2.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto2.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(500.00));
        produitDto2.setNom("Voyage aux Etats Unis d'Amérique");
        produitDto2.setReference("CCC1865521");
        produitDto2.setCheminImage(null);
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setIdProduitOriginal("3");
        produitDto3.setVersion("1");
        produitDto3.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto3.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(700.00));
        produitDto3.setNom("Voyage au Canada");
        produitDto3.setReference("AAA1256568");
        produitDto3.setCheminImage(null);

        final var produitDto7 = new ProduitDto();
        produitDto7.setIdProduitOriginal("7");
        produitDto7.setVersion("0");
        produitDto7.setDescription("La méditérannée, le colysée, les pâtes !");
        produitDto7.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(300.00));
        produitDto7.setNom("Voyage en Italie");
        produitDto7.setReference("ITA1289967");
        produitDto7.setCheminImage(null);

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
        final var ligneCommandeProduit7 = new LigneCommandeProduitDto();
        ligneCommandeProduit7.setQuantite(3);
        ligneCommandeProduit7.setPrix(DecimalFormatUtils.decimalFormatUtil(3 * 300.00, Locale.FRANCE));

        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto2, ligneCommandeProduit2);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3, ligneCommandeProduit3);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto7, ligneCommandeProduit7);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        assertEquals(3, this.commandeService.verifierProduitsAvecVersion(panierDto.getMapPanier()).size());
    }

    /**
     * Test method for
     * {@link service.commande.impl.CommandeService#validerPanier(presentation.panier.dto.PanierDto, presentation.commande.dto.AdressesDto, java.lang.Integer)}.
     */
    @Test
    void testValiderPanier() {
        // PanierDto
        final var panierDto = new PanierDto();
        // ProduitDto1
        final var produitDto1 = new ProduitDto();
        produitDto1.setIdProduitOriginal("1");
        produitDto1.setVersion("2");
        produitDto1.setDescription("description1");
        produitDto1.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(900.00, Locale.FRANCE));
        produitDto1.setNom("Voyage aux Maldives");
        produitDto1.setReference("MVR1256934");
        produitDto1.setCheminImage("maldives.jpg");
        produitDto1.setDestination("Maldives");
        produitDto1.setMiseEnVente("true");
        produitDto1.setServices("1");
        produitDto1.setHebergement("Maison dHotes");

        // ajout des lignes de commande
        final var ligneCommandeProduit = new LigneCommandeProduitDto();
        ligneCommandeProduit.setQuantite(6);
        ligneCommandeProduit.setPrix(DecimalFormatUtils.decimalFormatUtil(6 * 900.00, Locale.FRANCE));

        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());

        panierDto.setRemiseAffichage("0");
        panierDto.setPrixTotalAffichage(DecimalFormatUtils.decimalFormatUtil(5400.00, Locale.FRANCE));
        panierDto.setPrixApresRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(5400.00, Locale.FRANCE));

        final var defautAdresse = new CommandeAdresseDto();
        defautAdresse.setAdresse("22Bis rue du chemin vert, 59650 Villeneuve d'Ascq");
        defautAdresse.setNom("Dalton");
        defautAdresse.setPrenom("Timothé");

        final var livraison = new CommandeAdresseDto();
        livraison.setAdresse(defautAdresse.getAdresse());
        livraison.setNom(defautAdresse.getNom());
        livraison.setPrenom(defautAdresse.getPrenom());

        final var facturation = new CommandeAdresseDto();
        facturation.setAdresse(defautAdresse.getAdresse());
        facturation.setNom(defautAdresse.getNom());
        facturation.setPrenom(defautAdresse.getPrenom());

        final var adresses = new AdressesDto();
        adresses.setDefaultAdresse(defautAdresse);
        adresses.setCommandeAdresseLivraison(livraison);
        adresses.setCommandeAdresseFacturation(facturation);

        final UtilisateurDto utilisateur = new UtilisateurDto();
        utilisateur.setNom("Dupont");
        utilisateur.setPrenom("Jean");
        utilisateur.setId(1);

        final var commandeDtoReference = this.commandeService.validerPanier(panierDto, adresses, utilisateur);
        assertNotNull(commandeDtoReference);
        assertTrue(commandeDtoReference.matches("[A-Z0-9]{15}"));
    }

}
