/**
 * 
 */
package service.mentions_legales;

import java.util.Locale;

/**
 * Classe représentant l'interface fichierContactService
 *
 * @author NathanR
 */
public interface IFichierMentionsLegalesService {

    /**
     * Permet de trouver un fichier html
     * 
     * @param  locale : la locale pour connaitre la langue
     * @return        : le contenu du fichier html
     */
    String trouverFichierCGV(final Locale locale);

    /**
     * Permet de trouver un fichier html
     * 
     * @param  locale : la locale pour connaitre la langue
     * @return        : le contenu du fichier html
     */
    String trouverFichierCGU(final Locale locale);
}
