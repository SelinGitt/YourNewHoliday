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
}
