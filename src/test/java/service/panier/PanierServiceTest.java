/**
 * 
 */
package service.panier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.impl.PanierService;
import service.produit.IProduitService;

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
        final var produitTest2 = new ProduitDto();
        produitTest2.setIdProduitOriginal("2");
        produitTest2.setMiseEnVente("1");
        final var produitTest3 = new ProduitDto();
        produitTest3.setIdProduitOriginal("3");
        produitTest1.setMiseEnVente("1");
        Mockito.when(this.iProduitService.trouverProduitEnVente(1)).thenReturn(produitTest1);
        Mockito.when(this.iProduitService.trouverProduitEnVente(2)).thenReturn(produitTest2);
        Mockito.when(this.iProduitService.trouverProduitEnVente(3)).thenReturn(produitTest3);
        Mockito.when(this.iProduitService.trouverProduitEnVente(99)).thenReturn(null);
        panierService.updatePanier(panierTest, 1, 5);
        panierService.updatePanier(panierTest, 2, 7);
        assertEquals(2, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un nouveau produit au panier incrémente bien le nombre de référence.
        panierService.updatePanier(panierTest, 3, 7);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un produit déjà présent au panier n'incrémente pas le nombre de référence.
        panierService.updatePanier(panierTest, 2, 2);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On s'assure que la quantité du produit a bien été mise à jour.
        assertEquals(9, panierTest.getMapPanier().get(produitTest2));
        // On teste que l'ajout d'un produit null n'incrémente pas le nombre de référence.
        panierService.updatePanier(panierTest, 99, 12);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que si la quantité d'un produit devient inférieure à 1, il est alors supprimé du panier.
        panierService.updatePanier(panierTest, 2, -9);
        assertEquals(2, panierTest.getNombreDeReferences());
    }

}
