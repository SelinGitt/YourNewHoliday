package persistance.utilisateur.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.UtilisateurDo;

/**
 * JUnit class pour {@link persistance.utilisateur.dao.impl.UtilisateurDao}
 *
 * @author Valentin
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
class UtilisateurDaoTest {

    @Autowired
    private IUtilisateurDao iUtilisateurDao;

    /**
     * Test method for {@link persistance.commun.dao.impl.AbstractGenericDao#findAll()}.
     */
    @Test
    void testFindAll() {
        // On récupère les données
        final List<UtilisateurDo> listUtilisateur = this.iUtilisateurDao.findAll();
        // On teste la conformitée du nombre de données
        assertEquals(7, listUtilisateur.size());
    }

    /**
     * Test method for {@link persistance.utilisateur.dao.impl.UtilisateurDao#findByEmail()}.
     */
    @Test
    void testFindByEmail() {
        //On essaie avec une adresse email présente en base de données
        final UtilisateurDo utilisateurDo = iUtilisateurDao.findByEmail("baratheon.robert@hotmail.com");
        assertNotNull(utilisateurDo);
        assertEquals("ClientCLIENT123", utilisateurDo.getReference());
        //On essaie avec une adresse email absente en base de données
        assertNull(iUtilisateurDao.findByEmail("emailNonExistant@hotmail.com"));
    }
}
