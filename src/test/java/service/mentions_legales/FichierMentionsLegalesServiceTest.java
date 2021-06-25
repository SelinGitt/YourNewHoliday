/**
 * 
 */
package service.mentions_legales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.contact.IFichierContactDao;
import service.mentions_legales.impl.FichierMentionsLegalesService;

/**
 * Classe repr�sentant le test de FichierMentionsLegalesService
 *
 * @author NathanR
 */
class FichierMentionsLegalesServiceTest {

    @InjectMocks
    private FichierMentionsLegalesService fichierMentionsLegalesService;

    // Mock to be injected
    @Mock
    private IFichierContactDao            iFichierContactDao;

    @BeforeEach
    private void setup() {
        // initialisation des mocks
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for {@link service.mentions_legales.impl.FichierMentionsLegalesService#trouverFichierCGV()}.
     */
    @Test
    void testTrouverFichierCGV() {
        Mockito.when(iFichierContactDao.trouverFichierContact(Mockito.anyString()))
                .thenReturn("<h1>t���st@��%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //si non null
        assertNotNull(fichierMentionsLegalesService);
        //si egale a
        assertEquals("<h1>t���st@��%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>",
                fichierMentionsLegalesService.trouverFichierCGV());
    }

    /**
     * Test method for {@link service.mentions_legales.impl.FichierMentionsLegalesService#trouverFichierCGU()}.
     */
    @Test
    void testTrouverFichierCGU() {
        Mockito.when(iFichierContactDao.trouverFichierContact(Mockito.anyString()))
                .thenReturn("<h1>t���st@��%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //si non null
        assertNotNull(fichierMentionsLegalesService);
        //si egale a
        assertEquals("<h1>t���st@��%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>",
                fichierMentionsLegalesService.trouverFichierCGU());
    }

}
