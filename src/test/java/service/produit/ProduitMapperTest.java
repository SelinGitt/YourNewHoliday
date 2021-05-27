/**
 * 
 */
package service.produit;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import persistance.produit.entity.ProduitDo;
import presentation.produit.dto.ProduitDto;

/**
 * Classe test de {@link service.produit.ProduitMapper}
 *
 * @author Administrateur
 */
class ProduitMapperTest {

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToDo(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testMapToDo() {
        final var produitDto = initProduitDto();
        final var produitDo = initEqualsProduitDo();
    }

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToDto(persistance.produit.entity.ProduitDo)}.
     */
    @Test
    void testMapToDto() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToListDto(java.util.List)}.
     */
    @Test
    void testMapToListDto() {
        fail("Not yet implemented");
    }

    private ProduitDto initProduitDto() {
        final var produitDto = new ProduitDto();
        produitDto.setCheminImage("D:\test");
        produitDto.setDescription("Description de test");
        produitDto.setDestination("Destination de test");
        produitDto.setHebergement("Hebergement de test");
        produitDto.setIdProduitOriginal("111");
        produitDto.setMiseEnVente("true");
        produitDto.setNom("nom de test");
        produitDto.setPrixUnitaire("144.44");
        produitDto.setReference("REFTEST");
        produitDto.setServices("40");
        produitDto.setVersion("4");
        return produitDto;
    }

    private ProduitDo initEqualsProduitDo() {
        final var produitDo = new ProduitDo();
        produitDo.setCheminImage("D:\test");
        produitDo.setDescription("Description de test");
        produitDo.setDestination("Destination de test");
        produitDo.setHebergement("Hebergement de test");
        produitDo.setIdProduitOriginal(111);
        produitDo.setMiseEnVente(true);
        produitDo.setNom("nom de test");
        produitDo.setPrixUnitaire(144.44);
        produitDo.setReference("REFTEST");
        produitDo.setServices(40);
        produitDo.setVersion(4);
        return produitDo;
    }
}
