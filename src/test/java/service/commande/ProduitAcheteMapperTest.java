/**
 * 
 */
package service.commande;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.ProduitAcheteDo;
import presentation.produit.dto.ProduitDto;

/**
 * JUnit pour tester le Mapper de ProduitAchete
 *
 * @author Hanan anghari
 */
class ProduitAcheteMapperTest {

    /**
     * Test method for
     * {@link service.commande.ProduitAcheteMapper#mapperToDto(persistance.commande.entity.ProduitAcheteDo)}.
     */
    @Test
    void testMapperToDto() {
        final var produitDo = new ProduitAcheteDo();
        produitDo.setIdProduit(10);
        produitDo.setIdDeLOriginal(1);
        produitDo.setReference("GRE1256990");
        produitDo.setNom("Voyage en gr�ce");
        produitDo.setDescription("desciption10");
        produitDo.setDestination("Gr�ce");
        produitDo.setPrixUnitaire(new BigDecimal(200.00).setScale(2, RoundingMode.FLOOR));
        produitDo.setCheminImage("grece.jpg");

        final var produitDto = ProduitAcheteMapper.mapperToDto(produitDo);
        assertNotNull(produitDto);
        assertEquals("1", produitDto.getIdDeLOriginal());
        assertEquals("GRE1256990", produitDto.getReference());
        assertEquals("Voyage en gr�ce", produitDto.getNom());
        assertEquals("desciption10", produitDto.getDescription());
        assertEquals("Gr�ce", produitDto.getDestination());
        assertEquals("200,00", produitDto.getPrixUnitaire());
        assertEquals("grece.jpg", produitDto.getCheminDeLImage());
    }

    /**
     * Test method for
     * {@link service.commande.ProduitAcheteMapper#mapperToDto(persistance.commande.entity.ProduitAcheteDo)}.
     */
    @Test
    void testMapperToDtoWithDoNull() {
        assertNull(ProduitAcheteMapper.mapperToDto(null));
    }

    /**
     * Test method for {@link service.commande.ProduitAcheteMapper#mapperToDo(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testMapperToDo() {
        final var produitDto = new ProduitDto();
        final Boolean[] boolArrayToTest = {false, false, false, false, false, false, true, false, true};

        produitDto.setIdProduitOriginal("10");
        produitDto.setVersion("2");
        produitDto.setReference("GRE1234567");
        produitDto.setNom("Voyage en Gr�ce");
        produitDto.setDescription("Description voyage 10");
        produitDto.setDestination("Gr�ce");
        produitDto.setPrixUnitaire("200,00");
        produitDto.setHebergement("Chambre d'h�tel");
        produitDto.setMiseEnVente("true");
        produitDto.setCheminImage("grece.jpg");
        produitDto.setServices(boolArrayToTest);

        final var produitDo = ProduitAcheteMapper.mapperToDo(produitDto);
        assertNull(produitDo.getIdProduit());
        assertEquals(10, produitDo.getIdDeLOriginal());
        assertEquals(2, produitDo.getVersion());
        assertEquals("GRE1234567", produitDo.getReference());
        assertEquals("Voyage en Gr�ce", produitDo.getNom());
        assertEquals("Description voyage 10", produitDo.getDescription());
        assertEquals("Gr�ce", produitDo.getDestination());
        assertEquals(new BigDecimal(200.00).setScale(2, RoundingMode.FLOOR), produitDo.getPrixUnitaire());
        assertEquals("Chambre d'h�tel", produitDo.getHebergement());
        assertTrue(produitDo.getMiseEnVente());
        assertEquals("grece.jpg", produitDo.getCheminImage());
        assertEquals(5, produitDo.getServices());
    }

    /**
     * Test method for {@link service.commande.ProduitAcheteMapper#mapperToDo(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testMapperToDoWithNullDto() {
        assertNull(ProduitAcheteMapper.mapperToDo(null));
    }

}
