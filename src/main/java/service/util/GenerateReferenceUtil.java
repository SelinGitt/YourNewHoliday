/**
 * 
 */
package service.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Classe représentant GenerateReferenceUtil
 *
 * @author Valentin
 */
public class GenerateReferenceUtil {

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
     * @return                          Reference creer
     * @throws NoSuchAlgorithmException
     */
    public static String generateReference() throws NoSuchAlgorithmException {
        // create a string of all characters
        final var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        final var sb = new StringBuilder();

        // create an object of Random class
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
    }
}
