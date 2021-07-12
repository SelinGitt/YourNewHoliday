/**
 * 
 */
package service.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Classe unitaire pour factoriser l'affichage des d�cimaux
 *
 * @author Alexandre
 */
public class DecimalFormatUtils {

    /**
     * Constructor
     */
    private DecimalFormatUtils() {
        //
    }

    /**
     * Permet de transformer des BigDecimal en string avec le bon affichage. La langue par default de la local est fr
     * 
     * @param  nombre : un nombre en BigDecimal
     * @return        : le nombre decimal en format String
     */
    public static String decimalFormatUtil(final BigDecimal nombre) {

        //on defini la local qui determinera l'affichage en fonction de la langue
        return decimalFormatUtil(nombre, Locale.FRENCH);
    }

    /**
     * Permet de transformer des doubles en string avec le bon affichage. La langue par default de la local est fr
     * 
     * @param  nombre : un nombre
     * @return        : le nombre decimal en format String
     */
    public static String decimalFormatUtil(final Double nombre) {

        //on defini la local qui determinera l'affichage en fonction de la langue
        return decimalFormatUtil(nombre, Locale.FRENCH);
    }

    /**
     * Permet de transformer des doubles en string avec le bonne affichage.
     * 
     * @param  nombre : un nombre
     * @param  locale : permet de definir le format d'affichage
     * @return        : le nombre decimal en format String
     */
    public static String decimalFormatUtil(final Double nombre, final Locale locale) {

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
    public static String decimalFormatUtil(final BigDecimal nombre, final Locale locale) {

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
     * Permet de savoir si le prix contient une virgurle
     * 
     * @param  prixAVerifier le String � v�rifier
     * @return               true si le prix contient une virgule <br>
     *                       false sinon
     */
    public static boolean isPrixAVirgule(final String prixAVerifier) {
        return prixAVerifier.matches("\\d+(?:[,]\\d{2}$)");
    }

    /**
     * Permet de transformer un nombre contenu dans un string ayant �t� format� <br>
     * par la m�thode formatUtil(Big)Decimal en Double exploitable
     *
     * @param  nombreString : le nombre � transformer
     * @return              : le nombre transform� en Double
     */
    public static Double doubleFormatUtil(final String nombreString) {
        return Double.valueOf(nombreString.replace(",", ".").replace("\u00A0", "").replace("\u202F", ""));
    }
}
