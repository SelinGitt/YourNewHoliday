/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import service.produit.IProduitService;

/**
 * Classe test de {@link ProduitService}
 *
 * @author Administrateur
 */
@WebAppConfiguration("WebContent")
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Pour initialiser la base de données avec les bonnes données 
@Sql("/sql/DML.sql")
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Utilisation d'une transaction pour avoir des auto rollbacks à chaque fin de tests
@Transactional(propagation = Propagation.REQUIRED)
class ProduitServiceTest {
    @Autowired
    private IProduitService iProduitService;

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerProduitsEnVente()}.
     */
    @Test
    void testListerProduitsEnVente() {
        //Test de la taille de la liste de produits en Vente
        assertEquals(4, iProduitService.listerProduitsEnVente().size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#trouverProduitEnVente(java.lang.Integer)}.
     */
    @Test
    void testTrouverProduitEnVente() {
        // On récupère un produit en vente
        assertNotNull(iProduitService.trouverProduitEnVente(3));
        // On essaie de récupérer un produit qui n'est pas en vente
        assertNull(iProduitService.trouverProduitEnVente(2));
    }
}
