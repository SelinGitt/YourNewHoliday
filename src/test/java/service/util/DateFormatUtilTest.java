package service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateFormatUtilTest {

	/**
	 * Test method for {@link service.util.DateFormatUtil#formaterDate()}.
	 */
	@Test
	void testFormaterDate() {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2021, 5, 3);
		final Date date = calendar.getTime();
		final String dateFormate = DateFormatUtil.formaterDate(date);
		assertNotNull(date);
		assertNotNull(dateFormate);
		assertEquals("03/06/2021", dateFormate);

	}

}
