/**
 * 
 */
package persistance.external_files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
class FichierDaoTest {

    @Autowired
    private IFichierDao iFichier;

    /**
     * Test method for {@link persistance.external_files.impl.FichierDao#trouverFichierContact(java.lang.String)}.
     */
    @Test
    void testTrouverFichierContact() {

        //les tests marcheront a la condition d'avoir le fichier html dans le repertoire indiquer
        //pour le test le fichier sera directement dans le projet : 
        //aller dans propri�t� sur test-contact.html => recuperer le repertoire
        final String nomFichier = "src/test/resources/contact/test-contact.html";
        assertNotNull(iFichier.trouverFichier(nomFichier));
        assertEquals("<h1>t���st@��%</h1><h2>titre>test</h2><p>fichier html de test</p>", iFichier.trouverFichier(nomFichier));

        //verifier avec un fichier non exisitant
        final String nomFichierFaux = "C:/non/existant.html";
        assertThrows(AssertionError.class, () -> {
            assertNull(iFichier.trouverFichier(nomFichierFaux));
        });
    }
}
