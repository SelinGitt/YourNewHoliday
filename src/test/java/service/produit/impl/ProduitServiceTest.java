/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
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
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Utilisation d'une transaction pour avoir des auto rollbacks à chaque fin de tests
@Transactional(propagation = Propagation.REQUIRED)
class ProduitServiceTest {
    @Autowired
    private IProduitService iProduitService;

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerProduits()}.
     */
    @Test
    void testListerProduits() {
        assertEquals(6, iProduitService.listerProduits().size());
    }
}
