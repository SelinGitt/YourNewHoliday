/**
 * 
 */
package presentation.utilisateur.util;

import java.util.regex.Pattern;

/**
 * Classe repr�sentant PasswordUtil
 *
 * @author Valentin
 */
public class PasswordUtil {

    /**
     * Pattern de mot de passe � respecter
     */
    public static final String PATTERN = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])).{8,20}$";

    /**
     * Constructor
     */
    private PasswordUtil() {
        // Empty ctr 
    }

    /**
     * Permet de v�rifier si un mot de passe est valide
     *
     * @param  password Mot de passe a check
     * @return          True si valide, false sinon
     */
    public static boolean isValidPassword(final String password) {
        final var patternPwd = Pattern.compile(PATTERN);
        final var matcherPwd = patternPwd.matcher(password);

        return matcherPwd.matches();
    }
}
