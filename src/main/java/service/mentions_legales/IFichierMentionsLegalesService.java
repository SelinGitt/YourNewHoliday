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
    String chargerFichierCGV(final Locale locale);

    /**
     * Permet de trouver un fichier html
     * 
     * @param  locale : la locale pour connaitre la langue
     * @return        : le contenu du fichier html
     */
    String chargerFichierCGU(final Locale locale);

    /**
     * Permet de savoir si on trouve un fichier ou non
     *
     * @param  locale  : la locale pour connaitre la langue
     * @param  radical : radical pour trouver pour CGU et CGV
     * @return         : le fichier trouver
     */
    String trouverFichier(Locale locale, final String radical);
}
