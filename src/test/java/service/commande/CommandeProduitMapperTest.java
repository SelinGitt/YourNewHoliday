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
import java.util.Set;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.CommandeDo;
import persistance.commande.entity.CommandeProduitDo;
import persistance.commande.entity.ProduitAcheteDo;
import presentation.commande.dto.CommandeProduitDto;
import presentation.commande.dto.ProduitAcheteDto;
import service.util.DateFormatUtil;

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
        assertEquals("2", produitAcheteDto.getIdProduit());
        assertEquals("produit", produitAcheteDto.getNom());
        assertEquals("300,00", produitAcheteDto.getPrixUnitaire());
        assertEquals("135699", produitAcheteDto.getReference());
        assertEquals("600,00", commandeProduitDto.getPrixTotal());

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
        commandeDo.setPrixTotal(new BigDecimal(200.40).setScale(2, RoundingMode.FLOOR));
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

        assertEquals(0, CommandeProduitMapper.mapperSetDoToListDto(Collections.emptySet()).size());
    }

}
