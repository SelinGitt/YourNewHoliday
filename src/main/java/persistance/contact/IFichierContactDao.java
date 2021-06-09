/**
 * 
 */
package persistance.contact;

/**
 * Classe repr�sentant l'interface de fichierContactDao
 *
 * @author Alexandre
 */
public interface IFichierContactDao {

    /**
     * Permet de charger un fichier html
     *
     * @param  nomFichier : le nom du fichier
     * @return            : le contenu du fichier html
     */
    String trouverFichierContact(final String nomFichier);

}
