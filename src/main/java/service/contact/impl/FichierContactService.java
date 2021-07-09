/**
 * 
 */
package service.contact.impl;

import java.util.Locale;

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

    private static final String PATH            = "contactRepo";

    private static final String HTML            = ".html";

    private static final String CONTACT_RADICAL = "contact_";

    @Autowired
    private IFichierDao         fichierDao;

    @Override
    public String chargerFichierContact(final Locale locale) {
        final String nomFichier = trouverFichierContact(locale);
        return fichierDao.chargerFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + nomFichier);
    }

    @Override
    public String trouverFichierContact(final Locale locale) {
        final String nomFichier = CONTACT_RADICAL + locale.toString() + HTML;
        if (fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + nomFichier)) {
            return nomFichier;
        }
        return CONTACT_RADICAL + "fr" + HTML;
    }
}
