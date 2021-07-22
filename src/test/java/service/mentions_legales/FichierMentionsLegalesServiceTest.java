/**
 * 
 */
package service.mentions_legales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.external_files.IFichierDao;
import service.mentions_legales.impl.FichierMentionsLegalesService;

/**
 * Classe représentant le test de FichierMentionsLegalesService
 *
 * @author NathanR
 */
class FichierMentionsLegalesServiceTest {

    @InjectMocks
    private FichierMentionsLegalesService fichierMentionsLegalesService;

    // Mock to be injected
    @Mock
    private IFichierDao                   iFichierContactDao;

    @BeforeEach
    private void setup() {
        // initialisation des mocks
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for
     * {@link service.mentions_legales.impl.FichierMentionsLegalesService#chargerFichierCGV(java.util.Locale)}.
     */
    @Test
    void testChargerFichierCGV() {
        Mockito.when(iFichierContactDao.chargerFichier(Mockito.anyString()))
                .thenReturn("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //si non null
        assertNotNull(fichierMentionsLegalesService);
        //si egale a
        assertEquals("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>",
                fichierMentionsLegalesService.chargerFichierCGV(Locale.FRANCE));
    }

    /**
     * Test method for
     * {@link service.mentions_legales.impl.FichierMentionsLegalesService#chargerFichierCGU(java.util.Locale)}.
     */
    @Test
    void testChargerFichierCGU() {
        Mockito.when(iFichierContactDao.chargerFichier(Mockito.anyString()))
                .thenReturn("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>");
        //si non null
        assertNotNull(fichierMentionsLegalesService);
        //si egale a
        assertEquals("<h1>téûàst@€£%&%</h1><h2>titre test</h2><p>vrais fichier html de test</p>",
                fichierMentionsLegalesService.chargerFichierCGU(Locale.FRANCE));
    }

    /**
     * Test method for
     * {@link service.mentions_legales.impl.FichierMentionsLegalesService#trouverFichier(java.util.Locale, java.lang.String)}.
     */
    @Test
    void testTrouverFichierCGV() {
        //on teste qu'il renvoie bien le nom du fichier html avec la locale
        Mockito.when(iFichierContactDao.trouverFichier(Mockito.anyString())).thenReturn(true);
        assertEquals("CGV_en.html", fichierMentionsLegalesService.trouverFichier(Locale.ENGLISH, "CGV_"));

        //on teste qu'il retourne l'element par default quand il est a false
        Mockito.when(iFichierContactDao.trouverFichier(Mockito.anyString())).thenReturn(false);
        assertEquals("CGV_fr.html", fichierMentionsLegalesService.trouverFichier(Locale.CHINESE, "CGV_"));
    }

    /**
     * Test method for
     * {@link service.mentions_legales.impl.FichierMentionsLegalesService#trouverFichier(java.util.Locale, java.lang.String)}.
     */
    @Test
    void testTrouverFichierCGU() {
        //on teste qu'il renvoie bien le nom du fichier html avec la locale
        Mockito.when(iFichierContactDao.trouverFichier(Mockito.anyString())).thenReturn(true);
        assertEquals("CGU_en.html", fichierMentionsLegalesService.trouverFichier(Locale.ENGLISH, "CGU_"));

        //on teste qu'il retourne l'element par default quand il est a false
        Mockito.when(iFichierContactDao.trouverFichier(Mockito.anyString())).thenReturn(false);
        assertEquals("CGU_fr.html", fichierMentionsLegalesService.trouverFichier(Locale.CHINESE, "CGU_"));
        assertEquals("test_fr.html", fichierMentionsLegalesService.trouverFichier(Locale.CHINESE, "test_"));
    }
}
