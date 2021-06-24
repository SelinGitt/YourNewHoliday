package service.util;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        calendar.set(2021, 5, 3);
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
        assertEquals(5, calendar.get(Calendar.MONTH));
        assertEquals(2021, calendar.get(Calendar.YEAR));
    }

    /**
     * Test method for {@link service.util.DateFormatUtil#formaterStringToDate()}.
     */
    @Test
    void testFormaterStringToDateError() {
        //creer une nouvelle date si le format n'est pas le bon
        assertTrue(DateFormatUtil.formaterStringToDate("").equals(new Date()));

        //verifie le NullPointerException (asserthrow)
        
        
        
    }
}
