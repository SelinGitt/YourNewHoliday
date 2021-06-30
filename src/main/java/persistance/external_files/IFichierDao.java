/**
 * 
 */
package persistance.external_files;

/**
 * Classe représentant l'interface de fichierDao
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
    String trouverFichier(final String nomFichier);

}
