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
     * clé permettant de charger le chemin dans le fichier YNH-application.properties
     */
    private static final String PATH        = "mentionsLegalesRepo";

    private static final String HTML        = "html";

    private static final String CGU_RADICAL = "CGU";

    private static final String CGV_RADICAL = "CGV";

    @Autowired
    private IFichierDao         fichierContactDao;

    @Override
    public String trouverFichierCGV(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CgvNameFile = CGV_RADICAL + locale.toString() + HTML;
        final String contenuFichier = fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CgvNameFile);
        if (contenuFichier.isBlank()) {
            return fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + "CGV_fr.html");
        }
        return contenuFichier;
    }

    @Override
    public String trouverFichierCGU(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CguNameFile = CGU_RADICAL + locale.toString() + HTML;
        final String nomFichier = fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CguNameFile);
        if (nomFichier.isBlank()) {
            return fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + "CGU_fr.html");
        }
        return nomFichier;
    }

}
