/**
 * 
 */
package service.util;

/**
 * Classe utils pour la quantité de produits
 *
 * @author Lucas
 */
public class NumberUtils {
    private NumberUtils() {
        //empty cstr
    }

    /**
     * Permet de tester si la quantité de produits est valide.
     *
     * @param  numberToValidate la chaine de caracteres à tester
     * @return                  <code>true</code> si la quantité est un nombre<br>
     *                          <code>false</code> dans le cas contraire
     */
    public static boolean validate(final String numberToValidate) {
        return numberToValidate.matches("\\d+");
    }

}
