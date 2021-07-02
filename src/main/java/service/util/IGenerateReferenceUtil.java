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
     * @return String la r�f�rence
     */
    String generateReference();

    /**
     * Permet de construire un prefix pour la g�n�ration de r�f�rences
     *
     * @param chaineCaracteres la cha�nes de caract�res � partir de laquelle on veut cr�er un pr�fix
     */
    void constructPrefix(final String chaineCaracteres);
}
