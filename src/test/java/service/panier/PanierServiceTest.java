/**
 * 
 */
package service.panier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.impl.PanierService;
import service.produit.IProduitService;
import service.util.DecimalFormatUtils;

/**
 * Classe test de {@link PanierService}
 *
 * @author NathanR
 */
class PanierServiceTest {

    @InjectMocks
    private PanierService   panierService;

    // Mock à injecter
    @Mock
    private IProduitService iProduitService;

    @BeforeEach
    private void setup() {
        // initialisation des mocks
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for
     * {@link service.panier.impl.PanierService#updatePanier(presentation.panier.dto.PanierDto, java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    void testUpdatePanier() {
        final var panierTest = new PanierDto();
        final var produitTest1 = new ProduitDto();
        produitTest1.setIdProduitOriginal("1");
        produitTest1.setMiseEnVente("1");
        produitTest1.setPrixUnitaire("100.50");
        final var produitTest2 = new ProduitDto();
        produitTest2.setIdProduitOriginal("2");
        produitTest2.setMiseEnVente("1");
        produitTest2.setPrixUnitaire("100.50");
        final var produitTest3 = new ProduitDto();
        produitTest3.setIdProduitOriginal("3");
        produitTest1.setMiseEnVente("1");
        produitTest3.setPrixUnitaire("100.50");
        Mockito.when(this.iProduitService.trouverProduitEnVente(1)).thenReturn(produitTest1);
        Mockito.when(this.iProduitService.trouverProduitEnVente(2)).thenReturn(produitTest2);
        Mockito.when(this.iProduitService.trouverProduitEnVente(3)).thenReturn(produitTest3);
        Mockito.when(this.iProduitService.trouverProduitEnVente(99)).thenReturn(null);
        panierService.updatePanier(panierTest, 1, 5);
        panierService.updatePanier(panierTest, 2, 7);
        assertEquals(2, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un nouveau produit au panier n'incrémente pas le nombre de référence
        // si la quantité est inférieure à 1.
        panierService.updatePanier(panierTest, 3, 0);
        assertEquals(2, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un nouveau produit au panier incrémente bien le nombre de référence.
        panierService.updatePanier(panierTest, 3, 7);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On verifie que le prix de la ligne a bien été calculé.
        assertEquals("703,50", panierTest.getMapPanier().get(produitTest3).getPrix());
        // On teste que l'ajout d'un produit déjà présent au panier n'incrémente pas le nombre de référence.
        panierService.updatePanier(panierTest, 2, 2);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On s'assure que la quantité du produit a bien été mise à jour.
        assertEquals(9, panierTest.getMapPanier().get(produitTest2).getQuantite());
        // On teste le calcul correct des prix
        assertEquals("904,50", panierTest.getMapPanier().get(produitTest2).getPrix());
        // On teste que l'ajout d'un produit null n'incrémente pas le nombre de référence.
        panierService.updatePanier(panierTest, 99, 12);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que si la quantité d'un produit devient inférieure à 1, il est alors supprimé du panier.
        panierService.updatePanier(panierTest, 2, -9);
        assertEquals(2, panierTest.getNombreDeReferences());
    }

    /**
     * Test method for {@link service.panier.impl.PanierService#calculerPrixTotal(presentation.panier.dto.PanierDto)}.
     */
    @Test
    void testCalculerPrixTotal() {
        final var panierTest = new PanierDto();
        final var produitTest1 = new ProduitDto();
        produitTest1.setIdProduitOriginal("1");
        final var produitTest2 = new ProduitDto();
        produitTest2.setIdProduitOriginal("2");
        final var produitTest3 = new ProduitDto();
        produitTest3.setIdProduitOriginal("3");
        final var ligne1 = new LigneCommandeProduitDto();
        final var ligne2 = new LigneCommandeProduitDto();
        final var ligne3 = new LigneCommandeProduitDto();
        ligne1.setPrix("100");
        ligne2.setPrix("20");
        ligne3.setPrix("3");
        panierTest.getMapPanier().put(produitTest1, ligne1);
        panierTest.getMapPanier().put(produitTest2, ligne2);
        panierTest.getMapPanier().put(produitTest3, ligne3);
        assertEquals("123,00", panierService.calculerPrixTotal(panierTest));
    }

    /**
     * Test method for {@link service.panier.impl.PanierService#isRemiseExpected(presentation.panier.dto.PanierDto)}.
     */
    @Test
    void testIsRemiseExpected() {
        final var panierTest = new PanierDto();
        panierTest.setPrixTotalAffichage("999.99");
        assertFalse(panierService.isRemiseExpected(panierTest));
        panierTest.setNombreDeReferences(5);
        assertFalse(panierService.isRemiseExpected(panierTest));
        panierTest.setPrixTotalAffichage("10000.00");
        assertTrue(panierService.isRemiseExpected(panierTest));
        panierTest.setNombreDeReferences(4);
        assertFalse(panierService.isRemiseExpected(panierTest));
    }

    /**
     * Test method for {@link service.panier.impl.PanierService#actualiserPrix(presentation.panier.dto.PanierDto)}.
     */
    @Test
    void testActualiserPrix() {
        final var panierTest = new PanierDto();
        final var produitTest1 = new ProduitDto();
        produitTest1.setIdProduitOriginal("1");
        final var produitTest2 = new ProduitDto();
        produitTest2.setIdProduitOriginal("2");
        final var produitTest3 = new ProduitDto();
        produitTest3.setIdProduitOriginal("3");
        final var produitTest4 = new ProduitDto();
        produitTest4.setIdProduitOriginal("4");
        final var produitTest5 = new ProduitDto();
        produitTest5.setIdProduitOriginal("5");
        final var ligne1 = new LigneCommandeProduitDto();
        final var ligne2 = new LigneCommandeProduitDto();
        final var ligne3 = new LigneCommandeProduitDto();
        final var ligne4 = new LigneCommandeProduitDto();
        final var ligne5 = new LigneCommandeProduitDto();
        ligne1.setPrix("10000");
        ligne2.setPrix("2000");
        ligne3.setPrix("300");
        ligne4.setPrix("40");
        ligne5.setPrix("5");
        panierTest.getMapPanier().put(produitTest1, ligne1);
        panierTest.getMapPanier().put(produitTest2, ligne2);
        panierTest.getMapPanier().put(produitTest3, ligne3);
        panierTest.getMapPanier().put(produitTest4, ligne4);
        panierTest.getMapPanier().put(produitTest5, ligne5);
        panierTest.setNombreDeReferences(5);
        panierService.actualiserPrix(panierTest);
        assertEquals(12345, DecimalFormatUtils.doubleFormatUtil(panierTest.getPrixTotalAffichage()));
        assertEquals("617,25", panierTest.getRemiseAffichage());
        assertEquals("11 727,75", panierTest.getPrixApresRemiseAffichage());
        ligne1.setPrix("0");
        panierService.actualiserPrix(panierTest);
        assertEquals(2345, DecimalFormatUtils.doubleFormatUtil(panierTest.getPrixTotalAffichage()));
        assertEquals("0,00", panierTest.getRemiseAffichage());
        assertEquals(2345, DecimalFormatUtils.doubleFormatUtil(panierTest.getPrixApresRemiseAffichage()));
        ligne1.setPrix("10000");
        panierTest.getMapPanier().remove(produitTest5);
        panierTest.setNombreDeReferences(4);
        panierService.actualiserPrix(panierTest);
        assertEquals(12340, DecimalFormatUtils.doubleFormatUtil(panierTest.getPrixTotalAffichage()));
        assertEquals("0,00", panierTest.getRemiseAffichage());
        assertEquals(12340, DecimalFormatUtils.doubleFormatUtil(panierTest.getPrixApresRemiseAffichage()));
    }

    /**
     * Test method for
     * {@link service.panier.impl.PanierService#findProduitMap(presentation.panier.dto.PanierDto, java.lang.Integer)}.
     */
    @Test
    void testFindProduitMap() {
        final var panierTest = new PanierDto();
        final var produitTest4 = new ProduitDto();
        produitTest4.setIdProduitOriginal("4");
        final var ligne4 = new LigneCommandeProduitDto();
        panierTest.getMapPanier().put(produitTest4, ligne4);
        // On teste que la méthode trouve bien un produit lorsqu'il est dans la map.
        assertEquals(produitTest4, panierService.findProduitMap(panierTest, 4));
        // Et qu'elle retourne null lorsque le produit n'est pas dans la map.
        assertNull(panierService.findProduitMap(panierTest, 2));
    }

    /**
     * Test method for
     * {@link service.panier.impl.PanierService#deleteProduitPanier(presentation.panier.dto.PanierDto, java.lang.Integer)}.
     */
    @Test
    void testDeleteProduitPanier() {
        final var panierTest = new PanierDto();
        final var produitTest4 = new ProduitDto();
        produitTest4.setIdProduitOriginal("4");
        final var ligne4 = new LigneCommandeProduitDto();
        panierTest.getMapPanier().put(produitTest4, ligne4);
        panierTest.setNombreDeReferences(1);
        // On teste que le nombre de référence du panier ne change pas lorsqu'on
        // essaie de supprimer un produit qui n'est pas dans la map.
        panierService.deleteProduitPanier(panierTest, 1);
        assertEquals(1, panierTest.getNombreDeReferences());
        // Et qu'il est bien décrémenté le cas échéant.
        panierService.deleteProduitPanier(panierTest, 4);
        assertEquals(0, panierTest.getNombreDeReferences());

    }

    /**
     * Test method for {@link service.panier.impl.PanierService#viderPanier(presentation.panier.dto.PanierDto)}.
     */
    @Test
    void testViderPanier() {
        final var panierTest = new PanierDto();
        final var produitTest4 = new ProduitDto();
        produitTest4.setIdProduitOriginal("4");
        final var ligne4 = new LigneCommandeProduitDto();
        panierTest.getMapPanier().put(produitTest4, ligne4);
        panierTest.setNombreDeReferences(1);
        // On teste la valeur des attribut nombreDeReferences et mapPanier avant l'appel de la méthode.
        assertNotNull(panierTest.getMapPanier());
        assertEquals(1, panierTest.getNombreDeReferences());
        panierService.viderPanier(panierTest);
        // On teste que la mapPanier est désormais vide et le nombreDeReference nul.
        assertEquals(new HashMap<ProduitDto, LigneCommandeProduitDto>(), panierTest.getMapPanier());
        assertEquals(0, panierTest.getNombreDeReferences());
    }

    /**
     * Test method for
     * {@link service.panier.impl.PanierService#modifierQuantite(presentation.panier.dto.PanierDto, java.lang.Integer, int)}.
     */
    @Test
    void testModifierQuantite() {
        final var panierTest = new PanierDto();
        final var produitTest4 = new ProduitDto();
        produitTest4.setIdProduitOriginal("4");
        produitTest4.setPrixUnitaire("105");
        final var ligne4 = new LigneCommandeProduitDto();
        panierTest.getMapPanier().put(produitTest4, ligne4);
        panierTest.setNombreDeReferences(1);
        ligne4.setQuantite(44);
        Mockito.when(this.iProduitService.trouverProduitEnVente(4)).thenReturn(produitTest4);
        // On teste l'incrémentation entre 1 et 100,
        panierService.modifierQuantite(panierTest, 4, 1);
        assertEquals(45, ligne4.getQuantite());
        // Puis la décrémentation entre 1 et 100.
        panierService.modifierQuantite(panierTest, 4, -1);
        assertEquals(44, ligne4.getQuantite());
        // On teste qu'on ne peut pas incrémenter lorsque la quantité est égale à 100.
        ligne4.setQuantite(100);
        panierService.modifierQuantite(panierTest, 4, 1);
        assertEquals(100, ligne4.getQuantite());
        // On teste qu'on ne peut pas décrémenter lorsque la quantité est égale à 1.
        ligne4.setQuantite(1);
        panierService.modifierQuantite(panierTest, 4, -1);
        assertEquals(1, ligne4.getQuantite());
        // On teste qu'on ne peut pas incrémenter ou décrémenter un nombre autre que 1.
        panierService.modifierQuantite(panierTest, 4, 50);
        assertEquals(1, ligne4.getQuantite());
    }

}
