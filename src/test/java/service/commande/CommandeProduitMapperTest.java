/**
 * 
 */
package service.commande;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.CommandeDo;
import persistance.commande.entity.CommandeProduitDo;
import persistance.commande.entity.ProduitAcheteDo;
import presentation.commande.dto.CommandeProduitDto;
import presentation.commande.dto.ProduitAcheteDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.util.DateFormatUtil;
import service.util.DecimalFormatUtils;

/**
 * JUnit pour tester le mapper de CommandeProduit
 *
 * @author Hanan Anghari
 */
class CommandeProduitMapperTest {

    /**
     * Test method for
     * {@link service.commande.CommandeProduitMapper#mapperToDto(persistance.commande.entity.CommandeProduitDo)}.
     */
    @Test
    void testMapperToDto() {
        final CommandeProduitDo commandeProduitDo = initCommandeProduitDo();
        final CommandeProduitDto commandeProduitDto = CommandeProduitMapper.mapperToDto(commandeProduitDo);
        assertNotNull(commandeProduitDto);

        final ProduitAcheteDto produitAcheteDto = commandeProduitDto.getProduitAcheteDto();
        assertNotNull(produitAcheteDto);
        assertEquals("cheminImage", produitAcheteDto.getCheminDeLImage());
        assertEquals("description", produitAcheteDto.getDescription());
        assertEquals("destination", produitAcheteDto.getDestination());
        assertEquals("produit", produitAcheteDto.getNom());
        assertEquals("300,00", produitAcheteDto.getPrixUnitaire());
        assertEquals("135699", produitAcheteDto.getReference());
        assertEquals("600,00", commandeProduitDto.getPrixTotal());
    }

    /**
     * Test method for
     * {@link service.commande.CommandeProduitMapper#mapperToDto(persistance.commande.entity.CommandeProduitDo)}.
     */
    @Test
    void testMapperToDtoWithDoNull() {
        assertNull(CommandeProduitMapper.mapperToDto(null));
    }

    private ProduitAcheteDo initProduitAcheterDo() {
        final ProduitAcheteDo produitAcheteDo = new ProduitAcheteDo();
        produitAcheteDo.setCheminImage("cheminImage");
        produitAcheteDo.setDescription("description");
        produitAcheteDo.setDestination("destination");
        produitAcheteDo.setIdProduit(2);
        produitAcheteDo.setNom("produit");
        produitAcheteDo.setPrixUnitaire(new BigDecimal(300.00));
        produitAcheteDo.setReference("135699");

        return produitAcheteDo;
    }

    private CommandeDo initCommandeDo() {
        final CommandeDo commandeDo = new CommandeDo();
        final Date date = DateFormatUtil.formaterStringToDate("01/01/1970");

        commandeDo.setDate(date);
        commandeDo.setId(1);
        commandeDo.setIdUtilisateur(1);
        commandeDo.setPrixTotalApresRemise(new BigDecimal(200.40).setScale(2, RoundingMode.FLOOR));
        commandeDo.setQuantiteTotale(2);
        commandeDo.setReference("ABC5");
        return commandeDo;
    }

    private CommandeProduitDo initCommandeProduitDo() {
        final CommandeProduitDo commandeProduitDo = new CommandeProduitDo();
        final CommandeDo commandeDo = initCommandeDo();
        final ProduitAcheteDo produitAcheteDo = initProduitAcheterDo();
        commandeProduitDo.setIdCommandeProduit(9);
        commandeProduitDo.setProduitAcheteDo(produitAcheteDo);
        commandeProduitDo.setCommandeDo(commandeDo);
        commandeProduitDo.setQuantite(2);

        return commandeProduitDo;
    }

    /**
     * Test method for {@link service.commande.CommandeProduitMapper#mapperSetDoToListDto(java.util.Set)}.
     */
    @Test
    void testMapperSetDoToListDto() {
        final Set<CommandeProduitDo> commandeProduitDoSet = Set.<CommandeProduitDo>of(initCommandeProduitDo());
        final List<CommandeProduitDto> commandeProduitDtoList = CommandeProduitMapper.mapperSetDoToListDto(commandeProduitDoSet);
        assertNotNull(commandeProduitDtoList);
        assertEquals(1, commandeProduitDtoList.size());
    }

    /**
     * Test method for {@link service.commande.CommandeProduitMapper#mapperSetDoToListDto(java.util.Set)}.
     */
    @Test
    void testMapperSetDoToListDtoWithEmptySet() {
        assertEquals(0, CommandeProduitMapper.mapperSetDoToListDto(Collections.emptySet()).size());
    }

    /**
     * Test method for
     * {@link service.commande.CommandeProduitMapper#mapperMapDtoToSetDo(java.util.Map, persistance.commande.entity.CommandeDo)}.
     */
    @Test
    void testMapperMapDtoToSetDo() {
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
        produitDto1.setCheminImage("RoyaumeUni.jpg");
        produitDto1.setServices("5");
        // ProduitDto3
        final var produitDto3 = new ProduitDto();
        produitDto3.setIdProduitOriginal("3");
        produitDto3.setVersion("1");
        produitDto3.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto3.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(700.00));
        produitDto3.setNom("Voyage au Canada");
        produitDto3.setReference("AAA1256568");
        produitDto3.setCheminImage("Canada.jpg");
        produitDto3.setServices("1");
        // ProduitDto5
        final var produitDto5 = new ProduitDto();
        produitDto5.setIdProduitOriginal("5");
        produitDto5.setVersion("1");
        produitDto5.setDescription(
                "Description courte du voyage sur deux ou trois lignes maximum, un peu de texte en plus pour tester l'affichage");
        produitDto5.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(999.00));
        produitDto5.setNom("Voyage avec toi");
        produitDto5.setReference("AAA7777777");
        produitDto5.setCheminImage("virtual.jpg");
        produitDto5.setServices("6");

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

        final var commande = new CommandeDo();
        final var commandeProduitDo = CommandeProduitMapper.mapperMapDtoToSetDo(panierDto.getMapPanier(), commande);
        assertNotNull(commandeProduitDo);
        assertEquals(3, commandeProduitDo.size());
    }

}
