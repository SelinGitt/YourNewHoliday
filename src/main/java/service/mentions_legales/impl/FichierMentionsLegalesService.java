/**
 * 
 */
package service.mentions_legales.impl;

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

    /**
     * nom du fichier contenant les conditions générales d'utilisation
     */
    private static final String CGU_NAME_FILE = "CGU.html";
    /**
     * nom du fichier contenant les conditions générales de ventes
     */
    private static final String CGV_NAME_FILE = "CGV.html";
    /**
     * clé permettant de charger le chemin dans le fichier YNH-application.properties
     */
    private static final String PATH          = "mentionsLegalesRepo";

    @Autowired
    private IFichierDao  fichierContactDao;

    @Override
    public String trouverFichierCGV() {
        return fichierContactDao.trouverFichierContact(GetPropertyValues.PROPERTIESMAP.get(PATH) + CGV_NAME_FILE);
    }

    @Override
    public String trouverFichierCGU() {
        return fichierContactDao.trouverFichierContact(GetPropertyValues.PROPERTIESMAP.get(PATH) + CGU_NAME_FILE);
    }
}
