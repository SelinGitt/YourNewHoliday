package service.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe unitaire pour formater une date
 * 
 * @author Pierre
 */
public class DateFormatUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateFormatUtil.class);

	/**
	 * Constructeur
	 */
	private DateFormatUtil() {
		// empty
	}

	/**
	 * Méthode permttant de formater une date dans la forme dd/MM/yyyy
	 * 
	 * @param  date la date que l'on formater
	 * @return      un strig de la date formater
	 */
	public static String formaterDateToString(final Date date) {
		final Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		final String dateFormat = formatter.format(date);
		return dateFormat;
	}

	/**
	 * Permet de mapper un string de la forne dd//MM/yy en date
	 * 
	 * @param  date le string a passer en date
	 * @return      le date en objet date
	 */
	public static Date formaterStringToDate(final String date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (final ParseException exception) {
			logger.warn(exception.getMessage());
		}
		return new Date();
	}
}
