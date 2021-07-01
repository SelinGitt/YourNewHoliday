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
    String generateRef();

    /**
     * Permet de construire un prefix pour la g�n�ration de r�f�rences
     *
     * @param chaineCaracteres
     */
    void constructPrefix(final String chaineCaracteres);
}
