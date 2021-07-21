/**
 * 
 */
package service.util;

/**
 * Interface factorisant les implémentation de la génération de référencce
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface IGenerateReferenceUtil {

    /**
     * Permet de générer les références
     * 
     * @param
     * 
     *         <pre>
     *  paramètres necessaires seulement pour la ref commande :
     *  _  param[0] : utilisateurDto
     *  _  param[1] : nombre de produits achetés (= nombre de produits dans le panier)     *
     *         </pre>
     * 
     * @return       String la référence
     */
    String generateReference(final Object... param);

    /**
     * Permet de construire un prefix pour la génération de références
     *
     * @param chaineCaracteres la chaînes de caractères à partir de laquelle on veut créer un préfix
     */
    void constructPrefix(final String chaineCaracteres);
}
