/**
 * 
 */
package service.panier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import presentation.panier.dto.PanierDto;
import service.panier.impl.PanierService;
import service.produit.IProduitService;

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
    @Autowired
    private IPanierService  iPanierService;
    @Autowired
    private IProduitService iProduitService;

    /**
     * Test method for
     * {@link service.panier.impl.PanierService#updatePanier(presentation.panier.dto.PanierDto, java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    void testUpdatePanier() {
        final PanierDto panierTest = new PanierDto();
        iPanierService.updatePanier(panierTest, 1, 5);
        iPanierService.updatePanier(panierTest, 4, 7);
        assertEquals(2, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un nouveau produit au panier incr�mente bien le nombre de r�f�rence.
        iPanierService.updatePanier(panierTest, 3, 7);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un produit d�j� pr�sent au panier n'incr�mente pas le nombre de r�f�rence.
        iPanierService.updatePanier(panierTest, 4, 2);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On s'assure que la quantit� du produit a bien �t� mise � jour.
        assertEquals(9, panierTest.getMapPanier().get(iProduitService.trouverProduitEnVente(4)));
        // On teste que l'ajout d'un produit qui n'est pas en vente n'incr�mente pas le nombre de r�f�rence.
        iPanierService.updatePanier(panierTest, 2, 12);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un produit qui n'est pas en base n'incr�mente pas le nombre de r�f�rence.
        iPanierService.updatePanier(panierTest, 99, 10);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que si la quantit� d'un produit devient inf�rieure � 1, il est alors supprim� du panier.
        iPanierService.updatePanier(panierTest, 4, -9);
        assertEquals(2, panierTest.getNombreDeReferences());
    }

}
