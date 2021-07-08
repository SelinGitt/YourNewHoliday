/**
 * 
 */
package service.mentions_legales.impl;

import java.util.Locale;

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
     * clé permettant de charger le chemin dans le fichier YNH-application.properties
     */
    private static final String PATH = "mentionsLegalesRepo";

    @Autowired
    private IFichierDao         fichierContactDao;

    @Override
    public String trouverFichierCGV(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CgvNameFile = "CGV_" + locale.toString() + ".html";
        final String nomFichier = fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CgvNameFile);
        if (nomFichier.isBlank()) {
            return fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + "CGV_fr.html");
        }
        return nomFichier;
    }

    @Override
    public String trouverFichierCGU(final Locale locale) {
        //je retourne le nom du fichier + la local 
        final String CguNameFile = "CGU_" + locale.toString() + ".html";
        final String nomFichier = fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + CguNameFile);
        if (nomFichier.isBlank()) {
            return fichierContactDao.trouverFichier(GetPropertyValues.PROPERTIESMAP.get(PATH) + "CGU_fr.html");
        }
        return nomFichier;
    }

}
