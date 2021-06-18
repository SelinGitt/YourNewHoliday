/**
 * 
 */
package service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.contact.IFichierContactDao;
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
    private IFichierContactDao fichierContactDao;

    @Override
    public String trouverFichierContact() {
        return fichierContactDao.trouverFichierContact(GetPropertyValues.PROPERTIESMAP.get("contactRepo"));
    }
}
