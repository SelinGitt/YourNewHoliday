/**
 * 
 */
package service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Locale;

import org.junit.jupiter.api.Test;

/**
 * Classe représentant les tests de DecimalFormatUtils
 *
 * @author Administrateur
 */
class DecimalFormatUtilsTest {

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(java.math.BigDecimal)}.
     */
    @Test
    void testDecimalFormatUtilBigDecimal() {
        final DecimalFormatUtils decimalFormatUtils = new DecimalFormatUtils();
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :    
        final Double nombre = 11_115_555.478243;
        //on verifie que ca fonctionne avec un Bigdecimal
        final BigDecimal bigDecimal = new BigDecimal(nombre);
        assertEquals("11 115 555,48", decimalFormatUtils.decimalFormatUtil(bigDecimal));

    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(double)}.
     */
    @Test
    void testDecimalFormatUtilDouble() {
        final DecimalFormatUtils decimalFormatUtils = new DecimalFormatUtils();
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :
        Double nombre = 5_555.55547;

        //on verifie qu'il y'ai 2 chiffres apres la virgule
        assertEquals("5 555,56", decimalFormatUtils.decimalFormatUtil(nombre));

        //on verifie l'espacement
        //on verifie les arrondies : cela arronndie toujour au superieur
        nombre = 555555.55547;
        assertEquals("555 555,56", decimalFormatUtils.decimalFormatUtil(nombre));

        //on verifie les espacement
        nombre = 1345255.757;
        assertEquals("1 345 255,76", decimalFormatUtils.decimalFormatUtil(nombre));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(double, java.util.Locale)}.
     */
    @Test
    void testDecimalFormatUtilDoubleLocale() {
        final DecimalFormatUtils decimalFormatUtils = new DecimalFormatUtils();
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :    
        final Double nombre = 11_115_555.478243;

        //on verifie les locales
        final Locale localeFr = Locale.FRENCH;
        final Locale localeEng = Locale.ENGLISH;

        assertEquals("11,115,555.48", decimalFormatUtils.decimalFormatUtil(nombre, localeEng));
        assertEquals("11 115 555,48", decimalFormatUtils.decimalFormatUtil(nombre, localeFr));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(java.math.BigDecimal, java.util.Locale)}.
     */
    @Test
    void testDecimalFormatUtilBigDecimalLocale() {
        final DecimalFormatUtils decimalFormatUtils = new DecimalFormatUtils();
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :    
        final Double nombre = 11_115_555.478243;
        final BigDecimal bigDecimal = new BigDecimal(nombre);

        //on verifie les locales
        final Locale localeFr = Locale.FRENCH;
        final Locale localeEng = Locale.ENGLISH;

        assertEquals("11,115,555.48", decimalFormatUtils.decimalFormatUtil(bigDecimal, localeEng));
        assertEquals("11 115 555,48", decimalFormatUtils.decimalFormatUtil(bigDecimal, localeFr));
    }

}
