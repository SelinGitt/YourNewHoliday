package service.util;

import java.text.DateFormat;
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
    private static final Logger logger  = LoggerFactory.getLogger(DateFormatUtil.class);
    private static final String PATTERN = "dd/MM/yyyy";

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
     * @return      un string de la date formatée ou un string vide si date KO
     */
    public static String formaterDateToString(final Date date) {
        try {
            final Format formatter = new SimpleDateFormat(PATTERN);
            return formatter.format(date);
        } catch (final IllegalArgumentException exception) {
            logger.error("IllegalArgumentException exception", exception);

        }
        return "";
    }

    /**
     * Permet de mapper un string de la forme dd//MM/yyyy en date
     * 
     * @param  date le string à passer en date
     * @return      la date en objet date
     */
    public static Date formaterStringToDate(final String date) {
        try {
            return new SimpleDateFormat(PATTERN).parse(date);
        } catch (final ParseException exception) {
            logger.error("ParseException exception", exception);
        }
        return new Date();
    }

    /**
     * Permet de verifier si la date est conforme
     *
     * @param  date Date a verifier
     * @return      True si la date est conforme, false sinon
     */
    public static boolean checkDate(final String date) {
        var valide = false;

        try {
            final DateFormat dateFormat = new SimpleDateFormat(PATTERN);
            dateFormat.setLenient(false);
            final var dateToCompare = dateFormat.parse(date);
            final var aujourdhui = new Date();
            // on retourne false si la date est après celui d'aujourd'hui
            // de ce fait si elle est avant la date d'aujourd'hui on passe
            // la variable valide à true
            if (aujourdhui.compareTo(dateToCompare) >= 0) {
                valide = true;
            }
        } catch (final ParseException e) {
            logger.warn(e.getMessage());
        }

        return valide;
    }
}
