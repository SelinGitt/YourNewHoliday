/**
 * 
 */
package service.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe repr�sentant GenerateReferenceUtil
 *
 * @author Valentin
 */
public class GenerateReferenceUtil {

    private static final Logger logger = LoggerFactory.getLogger(GenerateReferenceUtil.class);

    /**
     * Classe repr�sentant les possibilit� pour la g�n�ration d'une r�f�rence
     *
     * @author Administrateur
     */
    public static enum TypeReference {
        /**
         * dans le cas d'une commande
         */
        COMMANDE("CMD"),

        /**
         * dans le cas d'un produit
         */
        PRODUIT(""),

        /**
         * dans le cas d'un utilisateur
         */
        UTILISATEUR("USR");

        private String prefix;

        private TypeReference(final String prefix) {
            this.prefix = prefix;
        }

        /**
         * Permet de retourner le prefix correspondant au type de l'enum
         *
         * @return String le pr�fix de l'enum.
         */
        public String getPrefix() {
            return this.prefix;
        }
    }

    private static final int DEBUT_PREFIX       = 0;

    private static final int LONGUEUR_PREFIX    = 3;

    private static final int FIN_PREFIX         = DEBUT_PREFIX + LONGUEUR_PREFIX;

    private static final int LONGUEUR_REFERENCE = 10;

    private static final int LONGUEUR_SUFIX     = LONGUEUR_REFERENCE - LONGUEUR_PREFIX;

    /**
     * Constructor
     */
    private GenerateReferenceUtil() {
        // Empty ctr
    }

    /**
     * Permet de g�n�rer une r�f�rence � partir d'un pr�fixe,
     *
     * @param  prefix le pr�fix que l'on doit mettre devant
     * @param  type   le type de la r�f�rence
     * @return        String la cha�ne de caract�res g�n�rer
     */
    public static String generateReference(final String prefix, final TypeReference type) {
        String reference = null;
        if (type == TypeReference.PRODUIT) {
            reference = prefix.substring(DEBUT_PREFIX, FIN_PREFIX).toUpperCase();
        } else {
            reference = type.getPrefix();
        }
        reference += generateSufix();
        logger.info("R�f�rence g�n�rer : {}.", reference);
        return reference;
    }

    /**
     * Permet de g�n�rer les 7 derniers caract�res<br>
     * Alphanum�rique d'une r�f�rence
     *
     * @return Reference creer
     */
    private static String generateSufix() {
        // create a string of all characters
        final var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // create random string builder
        final var sb = new StringBuilder();

        try {
            final var random = SecureRandom.getInstanceStrong();

            for (var i = 0; i < LONGUEUR_SUFIX; i++) {

                // generate random index number
                final var index = random.nextInt(alphabet.length());

                // get character specified by index
                // from the string
                final var randomChar = alphabet.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }

            return sb.toString();
        } catch (final NoSuchAlgorithmException exception) {
            logger.warn(exception.getMessage(), exception);
            return "";
        }
    }
}
