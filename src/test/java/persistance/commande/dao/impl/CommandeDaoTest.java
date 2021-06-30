/**
 * 
 */
package persistance.commande.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import persistance.commande.dao.ICommandeDao;
import persistance.commande.entity.CommandeDo;

/**
 * Classe repr�sentant les tests JUnits de CommandeDao
 *
 * @author Hanan Anghari
 */
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de donn�es avec les bonnes donn�es 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
//N�cessaire car les Dao sont en Mandatory
@Transactional(propagation = Propagation.REQUIRED)
class CommandeDaoTest {

    @Autowired
    private ICommandeDao iCommandeDao;

    /**
     * Test si l'autowired injecte bien un CommandeDao dans iCommandeDao
     */
    @Test
    void testICommandeDao() {
        assertNotNull(this.iCommandeDao);
    }

    /**
     * Test method for {@link persistance.commun.dao.impl.AbstractGenericDao#findAll()}.
     */
    @Test
    void testFindAll() {
        // On r�cup�re les donn�es
        final List<CommandeDo> listCommande = this.iCommandeDao.findAll();
        // On teste la conformit�e du nombre de donn�es
        assertEquals(6, listCommande.size());
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#updateCommandeDoUserDeletion(Integer)}.
     */
    @Test
    void testUpdateCommandeDoUserDeletion() {
        //on r�cup�re le nombre de commandes de la liste de l'utilisateur d'id 2
        int nombreCommandesUtilisateur = this.iCommandeDao.findByUserId(2).size();
        assertEquals(2, nombreCommandesUtilisateur);
        //On le d�tache de ses commandes
        this.iCommandeDao.updateCommandeDoUserDeletion(2);
        //on r�cup�re � nouveau le nombre de commandes de la liste de l'utilisateur d'id 2
        nombreCommandesUtilisateur = this.iCommandeDao.findByUserId(2).size();
        assertEquals(0, nombreCommandesUtilisateur);
    }
}
