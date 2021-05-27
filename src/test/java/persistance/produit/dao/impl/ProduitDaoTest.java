/**
 * 
 */
package persistance.produit.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;

/**
 * Classe représentant les tests unitaires pour produitDao
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
class ProduitDaoTest {

    @Autowired
    private IProduitDao iProduitDao;

    /**
     * Test method for {@link persistance.commun.dao.impl.GenericDao#findAll()}.
     */
    @Test
    void testFindAll() {
        // On récupère les données
        final List<ProduitDo> listProduit = this.iProduitDao.findAll();
        // On teste la conformitée du nombre de données
        assertEquals(6, listProduit.size());
    }

}
