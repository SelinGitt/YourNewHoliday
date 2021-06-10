/**
 * 
 */
package service.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe représentant GenerateReferenceUtil
 *
 * @author Valentin
 */
public class GenerateReferenceUtil {

    private static final Logger logger = LoggerFactory.getLogger(GenerateReferenceUtil.class);

    /**
     * Constructor
     */
    private GenerateReferenceUtil() {
        // Empty ctr
    }

    /**
     * Permet de generer une reference <br>
     * Ceci est temporaire
     *
     * @return Reference creer
     */
    public static String generateReference() {
        // create a string of all characters
        final var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        final var sb = new StringBuilder();

        try {
            final var random = SecureRandom.getInstanceStrong();

            for (var i = 0; i < 7; i++) {

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
