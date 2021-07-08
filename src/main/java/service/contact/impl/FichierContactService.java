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

    private static final String HTML    = ".html";

    private static final String CONTACT_RADICAL = "contact_";

    @Autowired
    private IFichierDao         fichierDao;

    
    public String chargerFichierContact() {
        
        //
        return null;
    }
    
    @Override
    public String trouverFichierContact(final Locale locale) {
        final String contactHtml = CONTACT_RADICAL + locale.toString() + HTML;
        final String contenuFichier = fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get("contactRepo") + contactHtml);

        //retourne la local fr si le fichier html "en", si il n'est pas disponible
        if (contenuFichier.isBlank()) {
            return fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get("contactRepo") + "contact_fr.html");
        }
        return contenuFichier;
    }
}
