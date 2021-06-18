/**
 * 
 */
package persistance.commande.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

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
 * Classe représentant les tests JUnits de CommandeDao
 *
 * @author Hanan Anghari
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
        // On récupère les données
        final List<CommandeDo> listCommande = this.iCommandeDao.findAll();
        // On teste la conformitée du nombre de données
        assertEquals(6, listCommande.size());
    }

    /**
     * Test method for {@link persistance.commande.dao.impl.CommandeDao#findByRef(java.lang.String)}.
     * 
     * @throws java.text.ParseException
     */
    @Test
    void testFindByRef() throws java.text.ParseException {
        final CommandeDo commandeDo = this.iCommandeDao.findByRef("ABC1");
        assertNotNull(commandeDo);
        assertEquals(1, commandeDo.getId());
        assertEquals("ABC1", commandeDo.getReference());
        assertEquals(0, BigDecimal.valueOf(1200.00).compareTo(commandeDo.getPrixTotal()));
        assertEquals(2, commandeDo.getIdUtilisateur());
        Date dateTest = null;
        dateTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-02-09 14:49:11");
        assertEquals(dateTest, commandeDo.getDate());
        assertThrows(NoResultException.class, () -> {
            this.iCommandeDao.findByRef("ZZZ1");
        });

    }
}
