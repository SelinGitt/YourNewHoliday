package service.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe unitaire pour formater une date
 * 
 * @author Pierre
 */
public class DateFormatUtil {

	/**
	 * Méthode permttant de formater une date dans la forme dd/MM/yyyy
	 * 
	 * @param  date la date que l'on formater
	 * @return      un strig de la date formater
	 */
	public static String formaterDate(final Date date) {
		final Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		final String dateFormat = formatter.format(date);
		return dateFormat;
	}
}
