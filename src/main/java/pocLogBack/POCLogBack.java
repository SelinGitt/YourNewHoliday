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
     * Méthode principale
     *
     * @param args : n'admet pas d'arguments
     */
    public static void main(final String[] args) {
        //On appelle cette méthode uniquement pour générer un log. 
        //Il sera écrit en fichier si le main est exécuté, et écrit en console si appelé depuis un JUnit.
        generateLogs();
    }

    /**
     * Permet de générer un log
     * 
     * @return int 1 si la méthode est bien effectuée
     */
    public static int generateLogs() {
        final String prenom = "Jean";
        final String nom = "Dupont";

        //Démonstration de l'interpolation
        logger.debug("{} {} est un utilisateur.", prenom, nom);
        return 1;
    }
}
