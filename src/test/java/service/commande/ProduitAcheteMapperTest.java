/**
 * 
 */
package service.commande;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.ProduitAcheteDo;

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
        produitDo.setNom("Voyage en grèce");
        produitDo.setDescription("desciption10");
        produitDo.setDestination("Grèce");
        produitDo.setPrixUnitaire(new BigDecimal(200.00).setScale(2, RoundingMode.FLOOR));
        produitDo.setCheminImage("grece.jpg");

        final var produitDto = ProduitAcheteMapper.mapperToDto(produitDo);
        assertNotNull(produitDto);
        assertEquals("1", produitDto.getIdDeLOriginal());
        assertEquals("GRE1256990", produitDto.getReference());
        assertEquals("Voyage en grèce", produitDto.getNom());
        assertEquals("desciption10", produitDto.getDescription());
        assertEquals("Grèce", produitDto.getDestination());
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

}
