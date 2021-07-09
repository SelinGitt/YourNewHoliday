/**
 * 
 */
package presentation.produit.validator;

import presentation.produit.dto.BeanQuantite;

/**
 * Classe utils pour la quantit� de produits
 *
 * @author Lucas
 */
public class QuantiteUtils {
    private QuantiteUtils() {
        //empty cstr
    }

    /**
     * Permet de tester si la quantit� de produits est valide.
     *
     * @param  beanQuantite le beanQuantite � tester
     * @return              <code>true</code> si la quantit� est un nombre<br>
     *                      <code>false</code> dans le cas contraire
     */
    public static boolean quantiteValid(final BeanQuantite beanQuantite) {
        return beanQuantite.getQuantite().matches("\\d+");
    }

}
