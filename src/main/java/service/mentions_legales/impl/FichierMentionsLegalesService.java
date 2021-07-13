/**
 * 
 */
package service.mentions_legales.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger      = LoggerFactory.getLogger(FichierMentionsLegalesService.class);

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
        logger.info("methode chargerFichierCGV qui charge le fichier : {} ", CgvNameFile);
        return fichierDao.chargerFichier(GetPropertyValues.getPropertiesMap().get(PATH) + CgvNameFile);
    }

    @Override
    public String chargerFichierCGU(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CguNameFile = trouverFichier(locale, CGU_RADICAL);
        logger.info("methode chargerFichierCGU qui charge le fichier : {} ", CguNameFile);
        return fichierDao.chargerFichier(GetPropertyValues.getPropertiesMap().get(PATH) + CguNameFile);

    }

    @Override
    public String trouverFichier(final Locale locale, final String radical) {
        final String nomFichier = radical + locale.toString() + HTML;
        if (fichierDao.trouverFichier(GetPropertyValues.getPropertiesMap().get(PATH) + nomFichier)) {
            logger.info(" on a trouver le fichier : {} ", nomFichier);
            return nomFichier;
        }
        final String fichierfr = radical + "fr" + HTML;
        logger.info(" le fichier : {} n'est pas present ,on charge le fichier par default : {} ", nomFichier, fichierfr);
        return fichierfr;
    }

}
