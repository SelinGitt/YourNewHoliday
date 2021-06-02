/**
 * 
 */
package service.contact;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Classe représentant le test de FichierContactService
 *
 * @author Alexandre
 */
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de données avec les bonnes données 
@WebAppConfiguration("WebContent")
class FichierContactServiceTest {

    @Autowired
    private IFichierContactService iFichier;

    /**
     * Test method for {@link service.contact.impl.FichierContactService#trouverFichierContact()}.
     */
    @Test
    void testTrouverFichierContact() {
        //on verifie simplement qu'il est non nul l'essentiel des tests sont gerer 
        //dans FichierContactDaoTest
        assertNotNull(iFichier.trouverFichierContact());
    }
}
