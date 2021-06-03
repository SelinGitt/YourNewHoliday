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
	private static final Logger logger    = LoggerFactory.getLogger(DateFormatUtil.class);
	private static final Format formatter = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Constructeur
	 */
	private DateFormatUtil() {
		// empty
	}

	/**
	 * Méthode permettant de formater une date dans la forme dd/MM/yyyy
	 * 
	 * @param  date la date que l'on formate
	 * @return      un string de la date formatée
	 */
	public static String formaterDateToString(final Date date) {
		try {
			return formatter.format(date);
		} catch (final IllegalArgumentException exception) {
			logger.warn(exception.getMessage());
		}
		return "";
	}

	/**
	 * Permet de mapper un string de la forme dd//MM/yy en date
	 * 
	 * @param  date le string à passer en date
	 * @return      la date en objet date
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
