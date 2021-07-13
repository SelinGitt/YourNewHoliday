/**
 * 
 */
package presentation.utilisateur.util;

import java.util.regex.Pattern;

/**
 * Classe repr�sentant EmailUtil
 *
 * @author Valentin
 */
public class EmailUtil {

    /**
     * Permet de v�rifier si un email est valide
     *
     * @param  email Email a check
     * @return       True si valide, false sinon
     */
    public static boolean isEmailValid(final String email) {
        //V�rification du format de l'adresse email
        final var pattern = Pattern.compile("^\\S{1,318}@\\S{1,318}+$");
        final var matcher = pattern.matcher(email);

        //Si email n'est pas blank et au bon format
        return !email.isBlank() && matcher.matches();
    }
}
