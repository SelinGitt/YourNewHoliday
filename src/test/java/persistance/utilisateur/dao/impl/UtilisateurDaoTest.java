package persistance.utilisateur.dao.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.utilisateur.dao.IUtilisateurDao;

/**
 * JUnit class pour {@link persistance.utilisateur.dao.impl.UtilisateurDao}
 *
 * @author Valentin
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
class UtilisateurDaoTest {

    @Autowired
    private IUtilisateurDao iUtilisateurDao;

    // Pas de test pour le moment
}
