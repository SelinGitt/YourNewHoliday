/**
 * 
 */
package service.mentions_legales.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.contact.IFichierContactDao;
import service.mentions_legales.IFichierMentionsLegalesService;
import service.util.GetPropertyValues;

/**
 * Classe représentant le service de fichierContact
 *
 * @author NathanR
 */
@Service
public class FichierMentionsLegalesService implements IFichierMentionsLegalesService {

    @Autowired
    private IFichierContactDao fichierContactDao;

    @Override
    public String trouverFichierCGV() {
        return fichierContactDao.trouverFichierContact(GetPropertyValues.PROPERTIESMAP.get("mentionsLegalesRepo") + "CGV.html");
    }

    @Override
    public String trouverFichierCGU() {
        return fichierContactDao.trouverFichierContact(GetPropertyValues.PROPERTIESMAP.get("mentionsLegalesRepo") + "CGU.html");
    }
}
