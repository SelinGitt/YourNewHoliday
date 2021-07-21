/**
 * 
 */
package persistance.commande.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.IProduitAcheteDao;

/**
 * Classe représentant le test unitaire pour le dao de produit achete
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de données avec les bonnes données 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
//Nécessaire car les Dao sont en Mandatory
@Transactional(propagation = Propagation.REQUIRED)
class ProduitAcheteDaoTest {

    @Autowired
    private IProduitAcheteDao produitAcheteDao;

    /**
     * Test que produitAcheteDao n'est pas null
     */
    @Test
    void testIProduitAcheteDao() {
        assertNotNull(this.produitAcheteDao);
    }

    /**
     * Test method for
     * {@link persistance.commande.dao.impl.ProduitAcheteDao#recupererProduitAcheteDo(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    void testRecupererProduitAcheteDo() {
        final var produitAcheteDo = this.produitAcheteDao.recupererProduitAcheteDo(3, 1);
        assertNotNull(produitAcheteDao);
        assertEquals(1, produitAcheteDo.getIdProduit());
        assertEquals(3, produitAcheteDo.getIdDeLOriginal());
        assertEquals(1, produitAcheteDo.getVersion());
        assertEquals("SPA1278951", produitAcheteDo.getReference());
        assertEquals("Voyage en Espagne", produitAcheteDo.getNom());
        assertEquals("description3", produitAcheteDo.getDescription());
        assertEquals("Espagne", produitAcheteDo.getDestination());
        assertEquals(0, BigDecimal.valueOf(450.00).compareTo(produitAcheteDo.getPrixUnitaire()));
        assertEquals("chambre dhôtel", produitAcheteDo.getHebergement());
        assertTrue(produitAcheteDo.getMiseEnVente());
        assertEquals("espagne.jpg", produitAcheteDo.getCheminImage());
        assertEquals(1, produitAcheteDo.getServices());
    }

    /**
     * Test method for
     * {@link persistance.commande.dao.impl.ProduitAcheteDao#recupererProduitAcheteDo(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    void testRecupererProduitAcheteDoNonEnBase() {
        assertNull(this.produitAcheteDao.recupererProduitAcheteDo(6, 1));
    }

}
