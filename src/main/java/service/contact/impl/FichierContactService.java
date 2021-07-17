/**
 * 
 */
package service.contact.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.external_files.IFichierDao;
import service.contact.IFichierContactService;
import service.util.GetPropertyValues;

/**
 * Classe représentant le service de fichierContact
 *
 * @author Alexandre
 */
@Service
public class FichierContactService implements IFichierContactService {

    private static final Logger logger          = LoggerFactory.getLogger(FichierContactService.class);

    private static final String PATH            = "contactRepo";

    private static final String ENCODAGE        = "contactEncodage";

    private static final String HTML            = ".html";

    private static final String CONTACT_RADICAL = "contact_";

    @Autowired
    private IFichierDao         fichierDao;

    @Override
    public String chargerFichierContact(final Locale locale) {
        final String nomFichier = trouverFichierContact(locale);
        final String encodage = "" + GetPropertyValues.getPropertiesMap().get(ENCODAGE);
        logger.info("methode chargerFichierContact qui charge le fichier : {} encoder en {}", nomFichier, encodage);
        return fichierDao.chargerFichier(GetPropertyValues.getPropertiesMap().get(PATH) + nomFichier, encodage);
    }

    @Override
    public String trouverFichierContact(final Locale locale) {
        final String nomFichier = CONTACT_RADICAL + locale.toString() + HTML;
        if (fichierDao.trouverFichier(GetPropertyValues.getPropertiesMap().get(PATH) + nomFichier)) {
            logger.info(" on a trouver le fichier : {} ", nomFichier);
            return nomFichier;
        }
        final String fichierfr = CONTACT_RADICAL + "fr" + HTML;
        logger.info(" le fichier : {} n'est pas present ,on charge le fichier par default : {} ", nomFichier, fichierfr);
        return fichierfr;
    }
}
