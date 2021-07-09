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

    private static final String HTML        = ".html";

    private static final String CGU_RADICAL = "CGU_";

    private static final String CGV_RADICAL = "CGV_";

    @Autowired
    private IFichierDao         fichierDao;

    @Override
    public String chargerFichierCGV(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CgvNameFile = trouverFichier(locale, CGV_RADICAL);
        return fichierDao.chargerFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CgvNameFile);
    }

    @Override
    public String chargerFichierCGU(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CguNameFile = trouverFichier(locale, CGU_RADICAL);
        return fichierDao.chargerFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CguNameFile);
    }

    @Override
    public String trouverFichier(final Locale locale, final String radical) {
        final String nomFichier = radical + locale.toString() + HTML;
        if (fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + nomFichier)) {
            return nomFichier;
        }
        return radical + "fr" + HTML;
    }

}
