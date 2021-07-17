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
     * @param  encodage   : encodage des fichiers exemple utf-8 ou Cp1252 pour l'ansi
     * @return            : le contenu du fichier html
     */
    String chargerFichier(final String nomFichier, final String encodage);

    /**
     * Permet de trouver un fichier
     *
     * @param  nomFichier : le nom du fichier a trouver
     * @return            : un nom de fichier
     */
    boolean trouverFichier(final String nomFichier);
}
