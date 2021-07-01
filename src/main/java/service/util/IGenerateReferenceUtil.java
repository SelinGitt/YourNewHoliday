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
     * @return String la référence
     */
    String generateRef();

    /**
     * Permet de construire un prefix pour la génération de références
     *
     * @param chaineCaracteres
     */
    void constructPrefix(final String chaineCaracteres);
}
