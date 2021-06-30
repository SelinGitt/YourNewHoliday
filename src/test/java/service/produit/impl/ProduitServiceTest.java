/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;
import presentation.produit.dto.ProduitDto;
import service.produit.ProduitMapper;

/**
 * Classe test de {@link ProduitService}
 *
 * @author Administrateur
 */
class ProduitServiceTest {

    @InjectMocks
    private ProduitService produitServiceMock;
    @Mock
    private IProduitDao    iProduitDaoMock;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerAllProduit()}.
     */
    @Test
    void testListerAllProduit() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(125d);
        // List.of permet de retourner une liste
        Mockito.when(this.iProduitDaoMock.findAll()).thenReturn(List.of(produitDo, produitDo2));
        assertEquals(2, this.produitServiceMock.listerAllProduit().size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerProduitsEnVente()}.
     */
    @Test
    void testListerProduitsEnVente() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(125d);
        // List.of permet de retourner une liste
        Mockito.when(this.iProduitDaoMock.findAllProduitsEnVente()).thenReturn(List.of(produitDo, produitDo2));
        assertEquals(2, this.produitServiceMock.listerProduitsEnVente().size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#trouverProduitEnVente(java.lang.Integer)}.
     */
    @Test
    void testTrouverProduitEnVente() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        Mockito.when(this.iProduitDaoMock.findProduitEnVente(1)).thenReturn(produitDo);
        Mockito.when(this.iProduitDaoMock.findProduitEnVente(2)).thenReturn(null);
        // On récupère un produit en vente
        assertNotNull(produitServiceMock.trouverProduitEnVente(1));
        // On essaie de récupérer un produit qui n'est pas en vente
        assertNull(produitServiceMock.trouverProduitEnVente(2));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#trouverParReference(String)}.
     */
    @Test
    void testTrouverParReference() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        Mockito.when(this.iProduitDaoMock.findByReference("ITA1289967")).thenReturn(produitDo);
        Mockito.when(this.iProduitDaoMock.findByReference("REFERENCE_FAUSSE")).thenReturn(null);
        // On récupére un produit avec une référence inexistante
        assertNotNull(produitServiceMock.trouverParReference("ITA1289967"));
        // On récupére un produit avec une référence existante
        assertNull(produitServiceMock.trouverParReference("REFERENCE_FAUSSE"));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#editerProduit(java.lang.Integer)}.
     */
    @Test
    void testEditerProduit() {
        final ProduitDto produitDto = new ProduitDto();
        produitDto.setIdProduitOriginal("99");
        produitDto.setNom("Test Edition");
        produitDto.setReference("TEST00000");
        produitDto.setPrixUnitaire("10.00");
        produitDto.setServices("1");
        produitDto.setMiseEnVente("true");
        produitDto.setHebergement("Hotel Test");
        produitDto.setDestination("Testmanie");
        produitDto.setDescription("Test moi");
        produitDto.setCheminImage("C:/temp/img/test.png");
        produitDto.setVersion("1");
        Mockito.when(this.iProduitDaoMock.update(Mockito.any(ProduitDo.class))).thenReturn(ProduitMapper.mapToDo(produitDto));
        assertNotNull(this.produitServiceMock.editerProduit(produitDto));
    }
}
