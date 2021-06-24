/**
 * 
 */
package service.mentionsLegales;

/**
 * Classe repr�sentant l'interface fichierContactService
 *
 * @author NathanR
 */
public interface IFichierMentionsLegalesService {

    /**
     * Permet de trouver un fichier html
     *
     * @return : le contenu du fichier html
     */
    String trouverFichierCGV();

    /**
     * Permet de trouver un fichier html
     *
     * @return : le contenu du fichier html
     */
    String trouverFichierCGU();
}
