/**
 * 
 */
package service.commande;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.CommandeAdresseDto;
import presentation.commande.dto.CommandeDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.util.DateFormatUtil;
import service.util.DecimalFormatUtils;

/**
 * JUnit pour tester le Mapper de commande
 *
 * @author Hanan anghari
 */
class CommandeMapperTest {

    /**
     * Test method for {@link service.commande.CommandeMapper#mapperToDto(persistance.commande.entity.CommandeDo)}.
     */
    @Test
    void testMapperToDto() {

        final CommandeDo commandeDo = new CommandeDo();

        commandeDo.setId(20);
        commandeDo.setReference("MP5001017050420");
        final Date date = DateFormatUtil.formaterStringToDate("01/01/1970");
        commandeDo.setDate(date);
        commandeDo.setPrixSansRemise(new BigDecimal(200.40).setScale(2, RoundingMode.FLOOR));
        commandeDo.setPrixTotalApresRemise(new BigDecimal(200.40).setScale(2, RoundingMode.FLOOR));
        commandeDo.setQuantiteTotale(5);
        commandeDo.setCommandeProduitDoSet(null);
        commandeDo.setNomLivraison("Thiéri");
        commandeDo.setPrenomLivraison("Henry");
        commandeDo.setAdresseLivraison("12 rue de la toison d'or, 59100 ROUBAIX");

        commandeDo.setNomFacturation("Boursier");
        commandeDo.setPrenomFacturation("Filibert");
        commandeDo.setAdresseFacturation("4/103 rue du Barreau, 59650 Villeneuve d'Ascq");

        final CommandeDto commandeDto = CommandeMapper.mapperToDto(commandeDo);

        assertNotNull(commandeDto);
        assertEquals("20", commandeDto.getId());
        assertEquals("MP5001017050420", commandeDto.getReference());
        assertEquals("01/01/1970", commandeDto.getDate());
        assertEquals("200,40", commandeDto.getPrixTotalApresRemise());
        assertEquals("5", commandeDto.getQuantiteTotale());
        assertEquals(Collections.emptyList(), commandeDto.getListCommandeProduitDto());

        final var adresseLivraison = commandeDto.getAdresseLivraison();
        assertEquals("Thiéri", adresseLivraison.getNom());
        assertEquals("Henry", adresseLivraison.getPrenom());
        assertEquals("12 rue de la toison d'or, 59100 ROUBAIX", adresseLivraison.getAdresse());

        final var adresseFacturation = commandeDto.getAdresseFacturation();
        assertEquals("Boursier", adresseFacturation.getNom());
        assertEquals("Filibert", adresseFacturation.getPrenom());
        assertEquals("4/103 rue du Barreau, 59650 Villeneuve d'Ascq", adresseFacturation.getAdresse());

        assertEquals(0, commandeDto.getListCommandeProduitDto().size());
    }

    /**
     * Test method for {@link service.commande.CommandeMapper#mapperToDto(persistance.commande.entity.CommandeDo)}.
     * 
     * @throws ParseException
     */
    @Test
    void testMapperToDtoWithDoNull() throws ParseException {
        assertNull(CommandeMapper.mapperToDto(null));
    }

    /**
     * Test method for {@link service.commande.CommandeMapper#mapperListDoToDto(java.util.List)}.
     */
    @Test
    void testMapperListDoToDto() {

        final CommandeDo commandeDo = new CommandeDo();
        commandeDo.setId(20);
        commandeDo.setReference("RP1012129039643");
        final Date date = DateFormatUtil.formaterStringToDate("12/12/1990");
        commandeDo.setDate(date);
        commandeDo.setPrixSansRemise(new BigDecimal(2785.40).setScale(2, RoundingMode.FLOOR));
        commandeDo.setPrixTotalApresRemise(new BigDecimal(2785.40).setScale(2, RoundingMode.FLOOR));
        commandeDo.setQuantiteTotale(2);
        commandeDo.setCommandeProduitDoSet(null);
        commandeDo.setNomLivraison("Vals");
        commandeDo.setPrenomLivraison("Manuel");
        commandeDo.setAdresseLivraison("18 rue de la toison d'or, 59100 ROUBAIX");
        commandeDo.setNomFacturation("Holande");
        commandeDo.setPrenomFacturation("François");
        commandeDo.setAdresseFacturation("4/203 rue du Barreau, 59650 Villeneuve d'Ascq");

        final CommandeDo commandeDo2 = new CommandeDo();
        commandeDo2.setId(23);
        commandeDo2.setReference("RP1013069039643");
        final Date date2 = DateFormatUtil.formaterStringToDate("13/06/1990");
        commandeDo2.setDate(date2);
        commandeDo2.setPrixSansRemise(new BigDecimal(2785.40).setScale(2, RoundingMode.FLOOR));
        commandeDo2.setPrixTotalApresRemise(new BigDecimal(2785.40).setScale(2, RoundingMode.FLOOR));
        commandeDo2.setQuantiteTotale(3);
        commandeDo2.setCommandeProduitDoSet(null);
        commandeDo2.setNomLivraison("Séraphin");
        commandeDo2.setPrenomLivraison("Mathias");
        commandeDo2.setAdresseLivraison("19 rue de la toison d'or, 59100 ROUBAIX");
        commandeDo2.setNomFacturation("Felicia");
        commandeDo2.setPrenomFacturation("Matilde");
        commandeDo2.setAdresseFacturation("4/303 rue du Barreau, 59650 Villeneuve d'Ascq");

        assertEquals(2, CommandeMapper.mapperListDoToDto(Arrays.asList(commandeDo, commandeDo2)).size());
    }

    /**
     * Test method for
     * {@link service.commande.CommandeMapper#mapperPanierDtoToDo(presentation.panier.dto.PanierDto, java.lang.String, java.lang.Integer)}.
     */
    @Test
    void testMapperPanierDtoToDo() {
        // ProduitDto1
        final var produitDto1 = new ProduitDto();
        produitDto1.setIdProduitOriginal("1");
        produitDto1.setVersion("1");
        produitDto1.setDescription("Description très courte du voyage sur deux ou trois lignes maximum");
        produitDto1.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(200.30, Locale.FRANCE));
        produitDto1.setNom("Voyage au Royaume Uni de Grande Bretagne et d'Irlande du nord");
        produitDto1.setReference("ROY1234567");
        produitDto1.setCheminImage("RoyaumeUni.jpg");
        produitDto1.setServices("5");
        // ProduitDto2
        final var produitDto2 = new ProduitDto();
        produitDto2.setIdProduitOriginal("3");
        produitDto2.setVersion("1");
        produitDto2.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto2.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(700.00));
        produitDto2.setNom("Voyage au Canada");
        produitDto2.setReference("CAN1256568");
        produitDto2.setCheminImage("Canada.jpg");
        produitDto2.setServices("1");
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setIdProduitOriginal("5");
        produitDto3.setVersion("1");
        produitDto3.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto3.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(999.00));
        produitDto3.setNom("Voyage avec toi");
        produitDto3.setReference("VIR7777777");
        produitDto3.setCheminImage("virtual.jpg");
        produitDto3.setServices("6");

        // ajout des lignes de commande
        final var ligneCommandeProduit = new LigneCommandeProduitDto();
        ligneCommandeProduit.setQuantite(6);
        ligneCommandeProduit.setPrix(DecimalFormatUtils.decimalFormatUtil(6 * 200.30, Locale.FRANCE));
        final var ligneCommandeProduit2 = new LigneCommandeProduitDto();
        ligneCommandeProduit2.setQuantite(1);
        ligneCommandeProduit2.setPrix(DecimalFormatUtils.decimalFormatUtil(1 * 500.00, Locale.FRANCE));
        final var ligneCommandeProduit3 = new LigneCommandeProduitDto();
        ligneCommandeProduit3.setQuantite(2);
        ligneCommandeProduit3.setPrix(DecimalFormatUtils.decimalFormatUtil(2 * 999.00, Locale.FRANCE));

        // PanierDto
        final var panierDto = new PanierDto();
        // add products to PanierDto
        panierDto.getMapPanier().put(produitDto1, ligneCommandeProduit);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto2, ligneCommandeProduit2);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());
        panierDto.getMapPanier().put(produitDto3, ligneCommandeProduit3);
        panierDto.setNombreDeReferences(1 + panierDto.getNombreDeReferences());

        // les prix dans le panier
        panierDto.setPrixTotalAffichage(DecimalFormatUtils.decimalFormatUtil(3699.8, Locale.FRANCE));
        panierDto.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(369.98, Locale.FRANCE));
        panierDto.setPrixApresRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(3329.82, Locale.FRANCE));

        final var defaultAdresse = new CommandeAdresseDto();
        defaultAdresse.setNom("Dupont");
        defaultAdresse.setPrenom("Marchant");
        defaultAdresse.setAdresse("123 nous irons au bois");

        final var adresseLivraison = new CommandeAdresseDto();
        adresseLivraison.setNom(defaultAdresse.getNom());
        adresseLivraison.setPrenom(defaultAdresse.getPrenom());
        adresseLivraison.setAdresse(defaultAdresse.getAdresse());

        final var adresseFacturation = new CommandeAdresseDto();
        adresseFacturation.setNom("Branson");
        adresseFacturation.setPrenom("Richard");
        adresseFacturation.setAdresse("127 nous irons au bois");

        final var adresses = new AdressesDto();
        adresses.setDefaultAdresse(defaultAdresse);
        adresses.setCommandeAdresseLivraison(adresseLivraison);
        adresses.setCommandeAdresseFacturation(adresseFacturation);

        final var commandeDo = CommandeMapper.mapperPanierDtoToDo(panierDto, adresses, "CM0315042128807", 1);
        assertNotNull(commandeDo);
        assertNull(commandeDo.getId());
        assertEquals("CM0315042128807", commandeDo.getReference());
        assertEquals(DateFormatUtil.formaterDateToString(new Date()), DateFormatUtil.formaterDateToString(commandeDo.getDate()));
        assertEquals(new BigDecimal(3699.8).setScale(2, RoundingMode.FLOOR), commandeDo.getPrixSansRemise());
        assertEquals(new BigDecimal(3329.82).setScale(2, RoundingMode.FLOOR), commandeDo.getPrixTotalApresRemise());
        assertEquals(3, commandeDo.getQuantiteTotale());
        assertEquals(panierDto.getNombreDeReferences(), commandeDo.getCommandeProduitDoSet().size());
        assertEquals(1, commandeDo.getIdUtilisateur());
        assertEquals("Dupont", commandeDo.getNomLivraison());
        assertEquals("Marchant", commandeDo.getPrenomLivraison());
        assertEquals("Branson", commandeDo.getNomFacturation());
        assertEquals("Richard", commandeDo.getPrenomFacturation());
        assertEquals("127 nous irons au bois", commandeDo.getAdresseFacturation());
        assertEquals("123 nous irons au bois", commandeDo.getAdresseLivraison());
    }

}
