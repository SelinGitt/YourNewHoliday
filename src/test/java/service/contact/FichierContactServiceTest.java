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

import persistance.external_files.impl.FichierDao;
import service.contact.impl.FichierContactService;

/**
 * Classe représentant le test de FichierContactService
 *
 * @author Alexandre
 */
class FichierContactServiceTest {

    @InjectMocks
    private FichierContactService fichierContactService;

    // Mock to be injected

    @Mock
    private FichierDao            fichierContactDao;

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

        Mockito.when(fichierContactDao.trouverFichier(Mockito.anyString()))
                .thenReturn("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //si non null
        assertNotNull(fichierContactService);
        //si egale a
        assertEquals("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>",
                fichierContactService.trouverFichierContact());

    }
}
