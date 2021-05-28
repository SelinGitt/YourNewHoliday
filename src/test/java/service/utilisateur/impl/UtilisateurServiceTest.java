package service.utilisateur.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import service.utilisateur.IUtilisateurService;

/**
 * JUnit test classe pour {@link service.utilisateur.impl.UtilisateurService}
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
class UtilisateurServiceTest {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Test pour {@link service.utilisateur.IUtilisateurService#findAllUtilisateurs()}
     */
    @Test
    void testFindAll() {
        Assertions.assertEquals(7, this.iUtilisateurService.findAllUtilisateurs().size());
    }
}
