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
     * Permet de charger le fichier Contact
     *
     * @param  locale :la local determinant le nom du fichier html a charger
     * @return        le contenu du fichier html
     */
    String chargerFichierContact(final Locale locale);

    /**
     * Permet de trouver un fichier html
     * 
     * @param  locale : la local determinant le nom du fichier html a trouver
     * @return        : le nom du fichier si existant et sinon le nom fr du fichier
     */
    String trouverFichierContact(final Locale locale);
}
