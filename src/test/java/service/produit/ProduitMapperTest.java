/**
 * 
 */
package service.produit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

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
        final var produitDoCompare = ProduitMapper.mapToDo(produitDto);
        assertEquals("D:\test", produitDoCompare.getCheminImage());
        assertEquals("Description de test", produitDoCompare.getDescription());
        assertEquals("Destination de test", produitDoCompare.getDestination());
        assertEquals("Hebergement de test", produitDoCompare.getHebergement());
        assertEquals(111, produitDoCompare.getIdProduitOriginal());
        assertEquals("nom de test", produitDoCompare.getNom());
        assertTrue(produitDoCompare.getMiseEnVente());
        assertEquals(144.44, produitDoCompare.getPrixUnitaire());
        assertEquals("REFTEST", produitDoCompare.getReference());
        assertEquals(40, produitDoCompare.getServices());
        assertEquals(4, produitDoCompare.getVersion());

        final var produitDtoSansId = initProduitDtoSansId();
        final var produitDoCompareSansId = ProduitMapper.mapToDo(produitDtoSansId);
        assertEquals("D:\test", produitDoCompareSansId.getCheminImage());
        assertEquals("Description de test", produitDoCompareSansId.getDescription());
        assertEquals("Destination de test", produitDoCompareSansId.getDestination());
        assertEquals("Hebergement de test", produitDoCompareSansId.getHebergement());
        assertNull(produitDoCompareSansId.getIdProduitOriginal());
        assertEquals("nom de test", produitDoCompareSansId.getNom());
        assertTrue(produitDoCompareSansId.getMiseEnVente());
        assertEquals(144.44, produitDoCompareSansId.getPrixUnitaire());
        assertEquals("REFTEST", produitDoCompareSansId.getReference());
        assertEquals(40, produitDoCompareSansId.getServices());
        assertEquals(4, produitDoCompareSansId.getVersion());
    }

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToDo(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testWithDtoNull() {
        assertNull(ProduitMapper.mapToDo(null));
    }

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToDto(persistance.produit.entity.ProduitDo)}.
     */
    @Test
    void testMapToDto() {
        final var produitDo = initProduitDo();
        final var produitDtoCompare = ProduitMapper.mapToDto(produitDo);
        assertEquals("D:\test", produitDtoCompare.getCheminImage());
        assertEquals("Description de test", produitDtoCompare.getDescription());
        assertEquals("Destination de test", produitDtoCompare.getDestination());
        assertEquals("Hebergement de test", produitDtoCompare.getHebergement());
        assertEquals("111", produitDtoCompare.getIdProduitOriginal());
        assertEquals("nom de test", produitDtoCompare.getNom());
        assertEquals("true", produitDtoCompare.getMiseEnVente());
        assertEquals("144,44", produitDtoCompare.getPrixUnitaire());
        assertEquals("REFTEST", produitDtoCompare.getReference());
        assertEquals("40", produitDtoCompare.getServices());
        assertEquals("4", produitDtoCompare.getVersion());
    }

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToDto(persistance.produit.entity.ProduitDo)}.
     */
    @Test
    void testMapToDtoWithNull() {
        assertNull(ProduitMapper.mapToDto(null));
    }

    /**
     * Test method for {@link service.produit.ProduitMapper#mapToListDto(java.util.List)}.
     */
    @Test
    void testMapToListDto() {
        final var produitDo1 = initProduitDo();
        final var produitDo2 = initProduitDo();
        assertEquals(2, ProduitMapper.mapToListDto(Arrays.asList(produitDo1, produitDo2)).size());
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

    private ProduitDto initProduitDtoSansId() {
        final var produitDto = new ProduitDto();
        produitDto.setCheminImage("D:\test");
        produitDto.setDescription("Description de test");
        produitDto.setDestination("Destination de test");
        produitDto.setHebergement("Hebergement de test");
        produitDto.setIdProduitOriginal(null);
        produitDto.setMiseEnVente("true");
        produitDto.setNom("nom de test");
        produitDto.setPrixUnitaire("144.44");
        produitDto.setReference("REFTEST");
        produitDto.setServices("40");
        produitDto.setVersion("4");
        return produitDto;
    }

    private ProduitDo initProduitDo() {
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
