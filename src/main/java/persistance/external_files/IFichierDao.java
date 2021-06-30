/**
 * 
 */
package persistance.external_files;

/**
 * Classe représentant l'interface de fichierContactDao
 *
 * @author Alexandre
 */
public interface IFichierDao {

    /**
     * Permet de charger un fichier html
     *
     * @param  nomFichier : le nom du fichier
     * @return            : le contenu du fichier html
     */
    String trouverFichierContact(final String nomFichier);

}
