package service.utilisateur.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
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

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#findByEmail()}
     */
    @Test
    void testFindByEmail() {
        //Test avec un email présent en base de données
        Assertions.assertEquals("ClientCLIENT123", iUtilisateurService.findByEmail("baratheon.robert@hotmail.com").getReference());
        //Test avec un email absent en base de données
        Assertions.assertNull(iUtilisateurService.findByEmail("emailNonExistant@hotmail.com"));
    }

    @Test
    void authentify() {
        final UtilisateurConnecteDto utilisateurConnecteDto1 = iUtilisateurService.authentify("baratheon.robert@hotmail.com",
                "TestConnexionNonEncoreHashe");
        Assertions.assertNotNull(utilisateurConnecteDto1);
        final UtilisateurConnecteDto utilisateurConnecteDto2 = iUtilisateurService.authentify("emailAbsent@hotmail.com",
                "TestConnexionNonEncoreHashe");
        Assertions.assertNull(utilisateurConnecteDto2);
        final UtilisateurConnecteDto utilisateurConnecteDto3 = iUtilisateurService.authentify("baratheon.robert@hotmail.com",
                "Mauvais Mot de passe");
        Assertions.assertNull(utilisateurConnecteDto3);

    }
}
