/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
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
     * Test method for {@link service.produit.impl.ProduitService#creerProduit(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testCreerProduit() {
        final var produitDo = new ProduitDo();
        produitDo.setNom("Voyage en Tanzanie");
        produitDo.setReference("0125556789");
        produitDo.setHebergement("BouiBoui and Co.");
        produitDo.setDestination("Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Super voyage à la découverte de zanzibar");

        final var produitDoCree = new ProduitDo();
        produitDo.setIdProduitOriginal(5);
        produitDo.setNom("Voyage en Tanzanie");
        produitDo.setReference("0125556789");
        produitDo.setHebergement("BouiBoui and Co.");
        produitDo.setDestination("Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Super voyage à la découverte de zanzibar");

        Mockito.when(this.iProduitDaoMock.create(produitDo)).thenReturn(produitDoCree);
        final ProduitDo nouveauProduit = iProduitDaoMock.create(produitDo);
        assertNotNull(nouveauProduit);
        assertEquals(produitDoCree, nouveauProduit);
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
     * Test method for {@link service.produit.impl.ProduitService#rechercherAllProduits(java.lang.Integer)}.
     */
    @Test
    void testRechercherAllProduits() {
        final var produitDo = new ProduitDo();
        produitDo.setIdProduitOriginal(99);
        produitDo.setNom("Test en Tanzanie");
        produitDo.setReference("TEST556789");
        produitDo.setHebergement("Test BouiBoui and Co.");
        produitDo.setDestination("Test Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Test super voyage à la découverte de zanzibar");
        produitDo.setCheminImage("C:/YNH/img");
        produitDo.setVersion(1);
        produitDo.setServices(1);
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("TEST")).thenReturn(List.of(produitDo));
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("ZZZ")).thenReturn(Collections.emptyList());
        // On récupère un produit en vente
        assertEquals(1, produitServiceMock.rechercherAllProduits("TEST").size());
        // On essaie de récupérer un produit qui n'existe pas
        assertEquals(0, produitServiceMock.rechercherAllProduits("ZZZ").size());
    }

    /**
     * Test method for {@link persistance.produit.dao.impl.ProduitDao#deleteProduitById(Integer)}.
     */
    @Test
    void testDeleteProduitById() {
        Mockito.when(this.iProduitDaoMock.deleteProduitById(1)).thenReturn(true);
        Mockito.when(this.iProduitDaoMock.deleteProduitById(99)).thenReturn(false);
        assertTrue(iProduitDaoMock.deleteProduitById(1));
        assertFalse(iProduitDaoMock.deleteProduitById(99));
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
        // On récupére un produit avec une référence existante
        assertNotNull(produitServiceMock.trouverParReference("ITA1289967"));
        // On récupére un produit avec une référence inexistante
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
        Mockito.when(this.iProduitDaoMock.findById(99)).thenReturn(ProduitMapper.mapToDo(produitDto));
        Mockito.when(this.iProduitDaoMock.update(Mockito.any(ProduitDo.class)))
                .thenReturn(ProduitMapper.mapToDo(produitDto));
        assertNotNull(this.produitServiceMock.editerProduit(produitDto));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#trouverProduitById(Integer)}.
     */
    @Test
    void testTrouverProduitByid() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setIdProduitOriginal(50);
        Mockito.when(this.iProduitDaoMock.findById(50)).thenReturn(produitDo);
        Mockito.when(this.iProduitDaoMock.findById(404)).thenReturn(null);
        // On récupére un produit avec un ID existant
        assertNotNull(produitServiceMock.trouverProduitById(50));
        // On récupére un produit avec un ID inexistant
        assertNull(produitServiceMock.trouverProduitById(404));
    }
}
