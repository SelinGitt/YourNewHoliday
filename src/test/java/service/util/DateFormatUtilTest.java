package service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

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

}
