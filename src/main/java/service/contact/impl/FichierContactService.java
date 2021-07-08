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

    @Autowired
    private IFichierDao fichierDao;

    @Override
    public String trouverFichierContact(final Locale locale) {
        final String contactHtml = "contact_" + locale.toString() + ".html";
        final String nomFichier = fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get("contactRepo") + contactHtml);

        //retourne la local fr si le fichier html en si il n'est pas disponible
        if (nomFichier.isBlank()) {
            return fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get("contactRepo") + "contact_fr.html");
        }
        return nomFichier;
    }
}
