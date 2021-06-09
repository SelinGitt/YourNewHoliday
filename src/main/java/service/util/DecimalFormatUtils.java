/**
 * 
 */
package service.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Classe unitaire pour factoriser l'affichage des décimaux
 *
 * @author Administrateur
 */
public class DecimalFormatUtils {

    /**
     * Permet de transformer des BigDecimal en string avec le bon affichage. La langue par default de la local est fr
     * 
     * @param  nombre : un nombre en BigDecimal
     * @return        : le nombre decimal en format String
     */
    public String decimalFormatUtil(final BigDecimal nombre) {

        //on defini la local qui determinera l'affichage en fonction de la langue
        final var locale = Locale.FRENCH;
        return decimalFormatUtil(nombre, locale);
    }

    /**
     * Permet de transformer des doubles en string avec le bon affichage. La langue par default de la local est fr
     * 
     * @param  nombre : un nombre
     * @return        : le nombre decimal en format String
     */
    public String decimalFormatUtil(final double nombre) {

        //on defini la local qui determinera l'affichage en fonction de la langue
        final var locale = Locale.FRENCH;
        return decimalFormatUtil(nombre, locale);
    }

    /**
     * Permet de transformer des BigDecimal en string avec le bonne affichage.
     * 
     * @param  nombre : un nombre
     * @param  locale : permet de definir le format d'affichage
     * @return        : le nombre decimal en format String
     */
    public String decimalFormatUtil(final double nombre, final Locale locale) {

        //affichage de la langue
        final var symbols = new DecimalFormatSymbols(locale);

        //garder uniquement 2 chiffres apres la virgule
        //decimalFormat ###,###.#
        final var format = new DecimalFormat("###,###.#", symbols);
        // defini le nb de chiffres apres la virgule
        format.setMinimumFractionDigits(2);

        return format.format(nombre);
    }

    /**
     * Permet de transformer des BigDecimal en string avec le bon affichage. La langue par default de la local est fr
     * 
     * @param  nombre : un nombre en BigDecimal
     * @param  locale : la locale avec la langue definis
     * @return        : le nombre decimal en format String
     */
    public String decimalFormatUtil(final BigDecimal nombre, final Locale locale) {

        //affichage de la langue
        final var symbols = new DecimalFormatSymbols(locale);

        //garder uniquement 2 chiffres apres la virgule
        //decimalFormat ###,###.#
        final var format = new DecimalFormat("###,###.#", symbols);
        // defini le nb de chiffres apres la virgule
        format.setMinimumFractionDigits(2);

        return format.format(nombre);
    }
}
