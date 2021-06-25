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
import presentation.commande.dto.ProduitAcheteDto;

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
        final ProduitAcheteDo produitDo = new ProduitAcheteDo();
        produitDo.setIdProduit(10);
        produitDo.setReference("125699");
        produitDo.setNom("Voyage en grèce");
        produitDo.setDescription("desciption10");
        produitDo.setDestination("Grèce");
        produitDo.setPrixUnitaire(new BigDecimal(200.00).setScale(2, RoundingMode.FLOOR));
        produitDo.setCheminImage("C:/temp/img/grece.jpg");

        final ProduitAcheteDto produitDto = ProduitAcheteMapper.mapperToDto(produitDo);
        assertNotNull(produitDto);
        assertEquals("10", produitDto.getIdProduit());
        assertEquals("125699", produitDto.getReference());
        assertEquals("Voyage en grèce", produitDto.getNom());
        assertEquals("desciption10", produitDto.getDescription());
        assertEquals("Grèce", produitDto.getDestination());
        assertEquals("200,00", produitDto.getPrixUnitaire());
        assertEquals("C:/temp/img/grece.jpg", produitDto.getCheminDeLImage());

        assertNull(ProduitAcheteMapper.mapperToDto(null));

    }

}
