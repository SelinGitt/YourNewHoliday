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
import persistance.external_files.impl.FichierDao;
import service.contact.IFichierContactService;
import service.util.GetPropertyValues;

/**
 * Classe représentant le service de fichierContact
 *
 * @author Alexandre
 */
@Service
public class FichierContactService implements IFichierContactService {

    private static final Logger logger = LoggerFactory.getLogger(FichierDao.class);
    
    private static final String PATH            = "contactRepo";

    private static final String HTML            = ".html";

    private static final String CONTACT_RADICAL = "contact_";

    @Autowired
    private IFichierDao         fichierDao;

    @Override
    public String chargerFichierContact(final Locale locale) {
        final String nomFichier = trouverFichierContact(locale);
        logger.error("On cherche le fichier : ", nomFichier);
        return fichierDao.chargerFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + nomFichier);
    }

    @Override
    public String trouverFichierContact(final Locale locale) {
        final String nomFichier = CONTACT_RADICAL + locale.toString() + HTML;
        logger.error("On cherche le fichier : ", nomFichier);
        if (fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + nomFichier)) {
            return nomFichier;
        }
        return CONTACT_RADICAL + "fr" + HTML;
    }
}
