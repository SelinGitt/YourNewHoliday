/**
 * 
 */
package service.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.contact.IFichierContactDao;
import service.contact.impl.FichierContactService;

/**
 * Classe représentant le test de FichierContactService
 *
 * @author Alexandre
 */

class FichierContactServiceTest {

    @InjectMocks
    private IFichierContactService iFichier = new FichierContactService();

    // Mock to be injected
    @Mock
    private IFichierContactDao     fichierContactDao;

    @BeforeEach
    private void setup() {
        // initialisation des mocks
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for {@link service.contact.impl.FichierContactService#trouverFichierContact()}.
     */
    @Test
    void testTrouverFichierContact() {
        Mockito.when(iFichier.trouverFichierContact())
                .thenReturn("<h1>test@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //on verifie simplement qu'il est non nul l'essentiel des tests sont gerer 
        //dans FichierContactDaoTest
        assertEquals("<h1>test@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>", iFichier.trouverFichierContact());
        assertNotNull(iFichier);
    }
}
