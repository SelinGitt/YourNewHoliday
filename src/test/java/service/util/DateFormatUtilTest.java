package service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * JUnit pour la classe DateFormatUtil
 * 
 * @author Pierre
 */
class DateFormatUtilTest {

    /**
     * Test method for {@link service.util.DateFormatUtil#formaterDateToString()}.
     */
    @Test
    void testFormaterDateToString() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JUNE, 3);
        final Date date = calendar.getTime();
        final String dateFormate = DateFormatUtil.formaterDateToString(date);
        assertNotNull(date);
        assertNotNull(dateFormate);
        assertEquals("03/06/2021", dateFormate);

    }

    /**
     * Test method for {@link service.util.DateFormatUtil#formaterDateToString()}.
     */
    @Test
    void testFormaterDateToStringError() {
        //on verifie que si  il y'a IllegalArgumentException il renvoie une string vide
        assertEquals("", DateFormatUtil.formaterDateToString(null));
    }

    /**
     * Test method for {@link service.util.DateFormatUtil#formaterStringToDate()}.
     */
    @Test
    void testFormaterStringToDate() {
        final String date = "03/06/2021";
        final Date dateClasse = DateFormatUtil.formaterStringToDate(date);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateClasse);
        assertNotNull(dateClasse);
        assertEquals(3, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.JUNE, calendar.get(Calendar.MONTH));
        assertEquals(2021, calendar.get(Calendar.YEAR));
    }

    /**
     * Test method for {@link service.util.DateFormatUtil#formaterStringToDate()}.
     */
    @Test
    void testFormaterStringToDateError() {
        //creer une nouvelle date si le format n'est pas le bon
        final Date dateClasse = DateFormatUtil.formaterStringToDate("PHFF");

        //on verifie qu'une nouvelle date a bien etait creer
        assertNotNull(dateClasse);

        //verifier le null
        assertThrows(NullPointerException.class, () -> {
            DateFormatUtil.formaterStringToDate(null);
        });
    }

    /**
     * Test pour {@link service.util.DateFormatUtil#checkDate(String)}.
     */
    @Test
    void testCheckPattern() {
        assertTrue(DateFormatUtil.checkDate("25/06/1995"));
        assertTrue(DateFormatUtil.checkDate("08/07/2021"));
        assertTrue(DateFormatUtil.checkDate("25/12/2221"));

        assertFalse(DateFormatUtil.checkDate("31/02/2000"));
        assertFalse(DateFormatUtil.checkDate("29/02/2001"));
        assertFalse(DateFormatUtil.checkDate("84/39/1995"));

        assertFalse(DateFormatUtil.checkDate("2012/02/05"));
        assertFalse(DateFormatUtil.checkDate("09-07-2021"));
    }
}
