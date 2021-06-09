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
        final double nombre = 11115555.478243;
        final BigDecimal bigDecimal = new BigDecimal(nombre);
        assertEquals("11 115 555,48", decimalFormatUtils.decimalFormatUtil(bigDecimal));

    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(double)}.
     */
    @Test
    void testDecimalFormatUtilDouble() {
        final DecimalFormatUtils decimalFormatUtils = new DecimalFormatUtils();
        double nombre = 5555.55547;

        assertEquals("5 555,56", decimalFormatUtils.decimalFormatUtil(nombre));

        nombre = 555555.55547;
        assertEquals("555 555,56", decimalFormatUtils.decimalFormatUtil(nombre));

        nombre = 1345255.757;
        assertEquals("1 345 255,76", decimalFormatUtils.decimalFormatUtil(nombre));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(double, java.util.Locale)}.
     */
    @Test
    void testDecimalFormatUtilDoubleLocale() {
        final DecimalFormatUtils decimalFormatUtils = new DecimalFormatUtils();
        final double nombre = 11115555.478243;

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
        final double nombre = 11115555.478243;
        final BigDecimal bigDecimal = new BigDecimal(nombre);

        final Locale localeFr = Locale.FRENCH;
        final Locale localeEng = Locale.ENGLISH;

        assertEquals("11,115,555.48", decimalFormatUtils.decimalFormatUtil(bigDecimal, localeEng));
        assertEquals("11 115 555,48", decimalFormatUtils.decimalFormatUtil(bigDecimal, localeFr));
    }

}
