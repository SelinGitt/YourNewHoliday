/**
 * 
 */
package pocLogBack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe temporaire / POC pour logback
 *
 * @author Administrateur
 */
public class POCLogBack {

    static final Logger logger = LoggerFactory.getLogger(POCLogBack.class);

    /**
     * M�thode principale
     *
     * @param args : n'admet pas d'arguments
     */
    public static void main(final String[] args) {
        //On appelle cette m�thode uniquement pour g�n�rer un log. 
        //Il sera �crit en fichier si le main est ex�cut�, et �crit en console si appel� depuis un JUnit.
        generateLogs();
    }

    /**
     * Permet de g�n�rer un log
     * 
     * @return int 1 si la m�thode est bien effectu�e
     */
    public static int generateLogs() {
        final String prenom = "Jean";
        final String nom = "Dupont";

        //D�monstration de l'interpolation
        logger.debug("{} {} est un utilisateur.", prenom, nom);
        return 1;
    }
}
