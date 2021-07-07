/**
 * 
 */
package service.mentions_legales.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.external_files.IFichierDao;
import service.mentions_legales.IFichierMentionsLegalesService;
import service.util.GetPropertyValues;

/**
 * Classe représentant le service de fichierContact
 *
 * @author NathanR
 */
@Service
public class FichierMentionsLegalesService implements IFichierMentionsLegalesService {

    /**
     * nom du fichier contenant les conditions générales d'utilisation
     */
    private static String       CGU_NAME_FILE = "CGU_fr.html";
    /**
     * nom du fichier contenant les conditions générales de ventes
     */
    private static String       CGV_NAME_FILE = "CGV_fr.html";
    /**
     * clé permettant de charger le chemin dans le fichier YNH-application.properties
     */
    private static final String PATH          = "mentionsLegalesRepo";

    @Autowired
    private IFichierDao         fichierContactDao;

    @Override
    public String trouverFichierCGV(final Locale locale) {
        final String nomFichier = fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CGV_NAME_FILE);
        CGV_NAME_FILE = "CGU_fr.html";
        if (locale.toString().equals("en") && !nomFichier.isBlank()) {
            CGV_NAME_FILE = "CGV_en.html";

        }

        return nomFichier;
    }

    @Override
    public String trouverFichierCGU(final Locale locale) {

        final String nomFichier = fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CGU_NAME_FILE);
        CGU_NAME_FILE = "CGU_fr.html";

        if (locale.toString().equals("en") && !nomFichier.isBlank()) {
            CGU_NAME_FILE = "CGU_en.html";

        }

        return nomFichier;
    }
}
