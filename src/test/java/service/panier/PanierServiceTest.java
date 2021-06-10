/**
 * 
 */
package service.panier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.impl.PanierService;
import service.produit.impl.ProduitService;

/**
 * Classe test de {@link PanierService}
 *
 * @author NathanR
 */
@WebAppConfiguration("WebContent")
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Pour initialiser la base de donn�es avec les bonnes donn�es 
@Sql("/sql/DML.sql")
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Utilisation d'une transaction pour avoir des auto rollbacks � chaque fin de tests
@Transactional(propagation = Propagation.REQUIRED)
class PanierServiceTest {

    @InjectMocks
    private PanierService  panierService;

    // Mock � injecter
    @Mock
    private ProduitService produitService;

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
        Mockito.when(this.produitService.trouverProduitEnVente(1)).thenReturn(produitTest1);
        Mockito.when(this.produitService.trouverProduitEnVente(2)).thenReturn(produitTest2);
        Mockito.when(this.produitService.trouverProduitEnVente(3)).thenReturn(produitTest3);
        Mockito.when(this.produitService.trouverProduitEnVente(99)).thenReturn(null);
        panierService.updatePanier(panierTest, 1, 5);
        panierService.updatePanier(panierTest, 2, 7);
        assertEquals(2, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un nouveau produit au panier incr�mente bien le nombre de r�f�rence.
        panierService.updatePanier(panierTest, 3, 7);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un produit d�j� pr�sent au panier n'incr�mente pas le nombre de r�f�rence.
        panierService.updatePanier(panierTest, 2, 2);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On s'assure que la quantit� du produit a bien �t� mise � jour.
        assertEquals(9, panierTest.getMapPanier().get(produitTest2));
        // On teste que l'ajout d'un produit null n'incr�mente pas le nombre de r�f�rence.
        panierService.updatePanier(panierTest, 99, 12);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que si la quantit� d'un produit devient inf�rieure � 1, il est alors supprim� du panier.
        panierService.updatePanier(panierTest, 2, -9);
        assertEquals(2, panierTest.getNombreDeReferences());
    }

}
