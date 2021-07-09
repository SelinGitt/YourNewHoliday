/**
 * 
 */
package service.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;

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
        //on teste qu'il renvoie bien le nom du fichier html avec la locale
        Mockito.when(fichierContactDao.trouverFichier(Mockito.anyString())).thenReturn(true);
        assertNotNull(fichierContactService.trouverFichierContact(Locale.ENGLISH));
        assertEquals("contact_en.html", fichierContactService.trouverFichierContact(Locale.ENGLISH));

        //on teste qu'il retourne l'element par default quand il est a false
        Mockito.when(fichierContactDao.trouverFichier(Mockito.anyString())).thenReturn(false);
        assertEquals("contact_fr.html", fichierContactService.trouverFichierContact(Locale.CHINESE));
    }

    /**
     * Test method for {@link service.contact.impl.FichierContactService#chargerFichierContact()}.
     */
    @Test
    void testChargerFichierContact() {
        Mockito.when(fichierContactDao.chargerFichier(Mockito.anyString()))
                .thenReturn("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //si non null
        assertNotNull(fichierContactService);
        //si egale a
        assertEquals("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>",
                fichierContactService.chargerFichierContact(Locale.FRANCE));
    }
}
