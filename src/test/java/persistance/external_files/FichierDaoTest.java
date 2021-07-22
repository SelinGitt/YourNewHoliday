/**
 * 
 */
package persistance.external_files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
     * Test method for {@link persistance.external_files.impl.FichierDao#trouverFichier(java.lang.String)}.
     */
    @Test
    void testTrouverFichier() {

        //mettre le chemin complet ici pour que cela fonctionne
        assertTrue(iFichier.trouverFichier("src/test/resources/contact/test-contact.html"));

        //verifier avec un fichier non exisitant
        assertFalse(iFichier.trouverFichier("nemarcherapas.html"));

    }

    /**
     * Test method for
     * {@link persistance.external_files.impl.FichierDao#chargerFichier(java.lang.String, java.lang.String)}.
     */
    @Test
    void testChargerFichier() {
        //les tests marcheront a la condition d'avoir le fichier html dans le repertoire indiquer
        //pour le test le fichier sera directement dans le projet : 
        //aller dans propri�t� sur test-contact.html => recuperer le repertoire
        final String nomFichier = "src/test/resources/contact/test-contact.html";
        assertNotNull(iFichier.chargerFichier(nomFichier));
        assertEquals("<h1>t���st@��%</h1><h2>titre>test</h2><p>fichier html de test</p>", iFichier.chargerFichier(nomFichier));

        //verifier avec un fichier non exisitant
        assertEquals("", iFichier.chargerFichier("C:/non/existant.html"));

    }

    /**
     * Test method for
     * {@link persistance.external_files.impl.FichierDao#chargerFichier(java.lang.String, java.lang.String)}.
     */
    @Test
    void testChargerFichierUtf8() {
        //les tests marcheront a la condition d'avoir le fichier html dans le repertoire indiquer
        //pour le test le fichier sera directement dans le projet : 
        //aller dans propri�t� sur test-contact.html => recuperer le repertoire
        final String nomFichier = "src/test/resources/contact/test-contact_utf-8.html";
        assertNotNull(iFichier.chargerFichier(nomFichier));
        assertEquals("<h1>t���st@��%</h1><h2>titre>test</h2><p>fichier html de test</p>", iFichier.chargerFichier(nomFichier));

        //verifier avec un fichier non exisitant
        assertEquals("", iFichier.chargerFichier("C:/non/existant.html"));

    }
}
