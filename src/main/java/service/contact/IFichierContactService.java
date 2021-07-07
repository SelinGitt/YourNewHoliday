/**
 * 
 */
package service.contact;

import java.util.Locale;

/**
 * Classe représentant l'interface fichierContactService
 *
 * @author Alexandre
 */
public interface IFichierContactService {

    /**
     * Permet de trouver un fichier html
     * 
     * @param  locale : la local determinant le nom du fichier html a charger
     * @return        : le contenu du fichier html
     */
    String trouverFichierContact(final Locale locale);
}
