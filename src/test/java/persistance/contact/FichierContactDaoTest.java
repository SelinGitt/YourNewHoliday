/**
 * 
 */
package persistance.contact;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Classe repr�sentant les test de fichierContactDao
 *
 * @author Alexandre
 */

//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de donn�es avec les bonnes donn�es 
@WebAppConfiguration("WebContent")
class FichierContactDaoTest {

    @Autowired
    private IFichierContactDao iFichier;

    /**
     * Test method for {@link persistance.contact.impl.FichierContactDao#trouverFichierContact(java.lang.String)}.
     */
    @Test
    void testTrouverFichierContact() {

        //les test marcheron a la condition d'avoir le html dans le repertoire indiquer
        //pour le test le fichier sera directement dans le projet
        final String nomFichier = "G:/Git/ynh/src/test/resources/contact/test-contact.html";
        assertNotNull(iFichier.trouverFichierContact(nomFichier));
        assertEquals("test", iFichier.trouverFichierContact(nomFichier));

        //verifier avec un fichier non exsitant
        final String nomFichierFaux = "C:/non/existant.html";
        assertThrows(AssertionError.class, () -> {
            assertNull(iFichier.trouverFichierContact(nomFichierFaux));
        });
    }
}
