/**
 * 
 */
package service.util;

/**
 * Interface factorisant les impl�mentation de la g�n�ration de r�f�rencce
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface IGenerateReferenceUtil {

    /**
     * Permet de g�n�rer les r�f�rences
     * 
     * @param
     * 
     *         <pre>
     *  param�tres necessaires seulement pour la ref commande :
     *  _  param[0] : utilisateurDto
     *  _  param[1] : nombre de produits achet�s (= nombre de produits dans le panier)     *
     *         </pre>
     * 
     * @return       String la r�f�rence
     */
    String generateReference(final Object... param);

    /**
     * Permet de construire un prefix pour la g�n�ration de r�f�rences
     *
     * @param chaineCaracteres la cha�nes de caract�res � partir de laquelle on veut cr�er un pr�fix
     */
    void constructPrefix(final String chaineCaracteres);
}
