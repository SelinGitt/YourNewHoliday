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
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Pour initialiser la base de données avec les bonnes données 
@Sql("/sql/DML.sql")
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Utilisation d'une transaction pour avoir des auto rollbacks à chaque fin de tests
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
        // On teste que l'ajout d'un nouveau produit au panier incrémente bien le nombre de référence.
        iPanierService.updatePanier(panierTest, 3, 7);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un produit déjà présent au panier n'incrémente pas le nombre de référence.
        iPanierService.updatePanier(panierTest, 4, 2);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On s'assure que la quantité du produit a bien été mise à jour.
        assertEquals(9, panierTest.getMapPanier().get(iProduitService.trouverProduitEnVente(4)));
        // On teste que l'ajout d'un produit qui n'est pas en vente n'incrémente pas le nombre de référence.
        iPanierService.updatePanier(panierTest, 2, 12);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que l'ajout d'un produit qui n'est pas en base n'incrémente pas le nombre de référence.
        iPanierService.updatePanier(panierTest, 99, 10);
        assertEquals(3, panierTest.getNombreDeReferences());
        // On teste que si la quantité d'un produit devient inférieure à 1, il est alors supprimé du panier.
        iPanierService.updatePanier(panierTest, 4, -9);
        assertEquals(2, panierTest.getNombreDeReferences());
    }

}
