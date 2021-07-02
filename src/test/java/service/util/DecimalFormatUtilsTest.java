/**
 * 
 */
package service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Locale;

import org.junit.jupiter.api.Test;

/**
 * Classe représentant les tests de DecimalFormatUtils
 *
 * @author Alexandre
 */
class DecimalFormatUtilsTest {

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(java.math.BigDecimal)}.
     */
    @Test
    void testDecimalFormatUtilBigDecimal() {
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :    
        final Double nombre = 11_115_555.478_243;
        //on verifie que ca fonctionne avec un Bigdecimal
        final BigDecimal bigDecimal = new BigDecimal(nombre);
        assertEquals("11 115 555,48", DecimalFormatUtils.decimalFormatUtil(bigDecimal));

    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(Double)}.
     */
    @Test
    void testDecimalFormatUtilDouble() {
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :
        Double nombre = 5_555.555_47;

        //on verifie qu'il y'ai 2 chiffres apres la virgule
        assertEquals("5 555,56", DecimalFormatUtils.decimalFormatUtil(nombre));

        //on verifie l'espacement
        //on verifie les arrondies : cela arronndie toujour au superieur
        nombre = 555555.555_47;
        assertEquals("555 555,56", DecimalFormatUtils.decimalFormatUtil(nombre));

        //on verifie les espacement
        nombre = 1345255.757;
        assertEquals("1 345 255,76", DecimalFormatUtils.decimalFormatUtil(nombre));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(Double, java.util.Locale)}.
     */
    @Test
    void testDecimalFormatUtilDoubleLocale() {
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :    
        final Double nombre = 11_115_555.478_243;

        //on verifie les locales
        assertEquals("11,115,555.48", DecimalFormatUtils.decimalFormatUtil(nombre, Locale.ENGLISH));
        assertEquals("11 115 555,48", DecimalFormatUtils.decimalFormatUtil(nombre, Locale.FRANCE));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#decimalFormatUtil(java.math.BigDecimal, java.util.Locale)}.
     */
    @Test
    void testDecimalFormatUtilBigDecimalLocale() {
        //Depuis JAVA 7 possibilité d'utiliser des underscores dans les entiers littéraux :    
        final Double nombre = 11_115_555.478_243;
        final BigDecimal bigDecimal = new BigDecimal(nombre);

        //on verifie les locales
        assertEquals("11,115,555.48", DecimalFormatUtils.decimalFormatUtil(bigDecimal, Locale.ENGLISH));
        assertEquals("11 115 555,48", DecimalFormatUtils.decimalFormatUtil(bigDecimal, Locale.FRENCH));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#isPrixAVirgule(String)}.
     */
    @Test
    void testIsPrixAVirgurle() {
        final String prixVirgule = "125,25";
        final String prixPoint = "125.11";
        final String prixPointVirgule = "1564.5484,54";
        final String prixVirgulePoint = "1564,54.54";
        final String prixDoubleVirgule = "1225,145,25";
        final String prixDecimalTooLong = "123,124578";

        assertTrue(DecimalFormatUtils.isPrixAVirgule(prixVirgule));
        assertFalse(DecimalFormatUtils.isPrixAVirgule(prixPoint));
        assertFalse(DecimalFormatUtils.isPrixAVirgule(prixPointVirgule));
        assertFalse(DecimalFormatUtils.isPrixAVirgule(prixVirgulePoint));
        assertFalse(DecimalFormatUtils.isPrixAVirgule(prixDoubleVirgule));
        assertFalse(DecimalFormatUtils.isPrixAVirgule(prixDecimalTooLong));
    }

    /**
     * Test method for {@link service.util.DecimalFormatUtils#doubleFormatUtil(java.lang.String)}.
     */
    @Test
    void testDoubleFormatUtil() {
        final String nombreString = "123\u00A0456\u00A0789,00";
        assertEquals(123456789.00, DecimalFormatUtils.doubleFormatUtil(nombreString));
    }
}
