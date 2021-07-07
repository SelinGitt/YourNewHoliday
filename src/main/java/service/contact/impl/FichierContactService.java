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

    private String determinerNom(final Locale locale) {

        if (locale.toString().equals("en")) {
            return "contact_en.html";
        }
        return "contact_fr.html";

    }

    @Override
    public String trouverFichierContact(final Locale locale) {

        final String nomFichier = fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get("contactRepo") + determinerNom(locale));

        //retourne la local fr si le fichier html en n'est pas disponible
        if (nomFichier.isBlank()) {
            return fichierDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get("contactRepo") + determinerNom(Locale.FRANCE));
        }
        return nomFichier;
    }
}
