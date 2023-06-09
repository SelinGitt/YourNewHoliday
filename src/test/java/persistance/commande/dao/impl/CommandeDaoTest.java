/**
 * 
 */
package persistance.commande.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
import persistance.commande.entity.CommandeProduitDo;
import service.util.DateFormatUtil;

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
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#findByRef(java.lang.String)}.
     */
    @Test
    void testFindByRef() {
        final var commandeDo = this.iCommandeDao.findByRef("ABC5");
        assertNotNull(commandeDo);
        assertEquals(5, commandeDo.getId());
        assertEquals("ABC5", commandeDo.getReference());
        assertEquals("Maimai", commandeDo.getNomFacturation());
        assertEquals("Maiko", commandeDo.getPrenomFacturation());
        assertEquals("124, rue du petit chemin, 59000, Lille", commandeDo.getAdresseFacturation());
        assertEquals("LeForestier", commandeDo.getNomLivraison());
        assertEquals("Maxime", commandeDo.getPrenomLivraison());
        assertEquals("221, rue de l�glise 59790, Ronchin", commandeDo.getAdresseLivraison());
        assertEquals(0, BigDecimal.valueOf(900.00).compareTo(commandeDo.getPrixSansRemise()));
        assertEquals(0, BigDecimal.valueOf(900.00).compareTo(commandeDo.getPrixTotalApresRemise()));
        assertEquals(5, commandeDo.getIdUtilisateur());
        assertEquals("17/03/2021", DateFormatUtil.formaterDateToString(commandeDo.getDate()));
        final Set<CommandeProduitDo> commandeProduitSet = commandeDo.getCommandeProduitDoSet();
        assertNotNull(commandeProduitSet);
        assertEquals(1, commandeProduitSet.size());
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#findByRef(java.lang.String)}.
     */
    @Test
    void testFindByRefWhithWrongRef() {
        assertNull(this.iCommandeDao.findByRef("ZZZ1"));
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#isCommandeExist(java.lang.String)}.
     */
    @Test
    void testIsCommandeExist() {
        assertTrue(this.iCommandeDao.isCommandeExist("ABC1"));
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#isCommandeExist(java.lang.String)}.
     */
    @Test
    void testIsCommandeExistWhithWrongRef() {
        assertFalse(this.iCommandeDao.isCommandeExist("ZZZ1"));
    }

    /*
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
