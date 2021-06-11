/**
 * 
 */
package service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.contact.IFichierContactDao;
import service.contact.IFichierContactService;

/**
 * Classe représentant le service de fichierContact
 *
 * @author Alexandre
 */
@Service
public class FichierContactService implements IFichierContactService {

    /**
     * changer le repertoire de la constante en fonction de l'emplacement du fichier .html
     */
    private static final String NOMFICHIERHTML = "C:/test/test-contact.html";
    @Autowired
    private IFichierContactDao  fichierContactDao;

    @Override
    public String trouverFichierContact() {
        return fichierContactDao.trouverFichierContact(NOMFICHIERHTML);
    }
}
