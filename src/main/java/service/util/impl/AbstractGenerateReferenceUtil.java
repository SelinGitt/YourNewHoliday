/**
 * 
 */
package service.util.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.util.IGenerateReferenceUtil;

/**
 * Classe abstraite représentant la factorisation des fonctionnalités utilisées pour générer des références
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public abstract class AbstractGenerateReferenceUtil implements IGenerateReferenceUtil {

    private static final Logger logger             = LoggerFactory.getLogger(AbstractGenerateReferenceUtil.class);

    protected static final int  DEBUT_PREFIX       = 0;

    protected static final int  LONGUEUR_PREFIX    = 3;

    protected static final int  FIN_PREFIX         = DEBUT_PREFIX + LONGUEUR_PREFIX;

    protected static final int  LONGUEUR_REFERENCE = 10;

    protected static final int  LONGUEUR_SUFIX     = LONGUEUR_REFERENCE - LONGUEUR_PREFIX;

    protected String            prefix;

    @Override
    public String generateRef() {
        final String reference = this.prefix + this.generateSufix();
        logger.info("Référence générer : {}.", reference);
        return reference;
    }

    @Override
    public void constructPrefix(final String chaineCaracteres) {
        this.prefix = chaineCaracteres.substring(DEBUT_PREFIX, FIN_PREFIX).toUpperCase();
    }

    /**
     * Permet de générer les 7 derniers caractères<br>
     * Alphanumérique d'une référence
     *
     * @return Reference creer
     */
    private String generateSufix() {
        // create a string of all characters
        final var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // create random string builder
        final var sb = new StringBuilder();

        try {
            final var random = SecureRandom.getInstanceStrong();

            for (var i = 0; i < LONGUEUR_SUFIX; i++) {

                // generate random index number
                final var index = random.nextInt(alphabet.length());

                // get character specified by index
                // from the string
                final var randomChar = alphabet.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }

            return sb.toString();
        } catch (final NoSuchAlgorithmException exception) {
            logger.warn(exception.getMessage(), exception);
            return "";
        }
    }

}
