/**
 * 
 */
package service.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import service.Contact.IFichierContactService;

/**
 * Classe repr�sentant le test de FichierContactService
 *
 * @author Alexandre
 */
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de donn�es avec les bonnes donn�es 
@WebAppConfiguration("WebContent")
class FichierContactServiceTest {

    @Autowired
    private IFichierContactService iFichier;

    /**
     * Test method for {@link service.Contact.impl.FichierContactService#trouverFichierContact()}.
     */
    @Test
    void testTrouverFichierContact() {

        assertNotNull(iFichier.trouverFichierContact());
        assertEquals("erzrtrdfrggre", iFichier.trouverFichierContact());
    }
}
