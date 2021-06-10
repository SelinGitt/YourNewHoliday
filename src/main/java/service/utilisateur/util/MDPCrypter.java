/**
 * 
 */
package service.utilisateur.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe unitaire pour crypter un mot de passe utilisateur
 *
 * @author Meliodas-sama
 */
public class MDPCrypter {

    /**
     * Constructor
     */
    private MDPCrypter() {
        //empty now
    }

    /**
     * Permet de crypter un mot de passe avec un algorithme<br/>
     * de chiffrement de type SHA1
     *
     * @param  password le mot de passe à crypter
     * @return          le mot de passe crypté si ok, une exception sinon
     */
    public static String crypterMDPV1(final String password) {
        final var buf = new StringBuilder();
        try {
            final var md = MessageDigest.getInstance("SHA1");
            md.update(password.getBytes());
            byte[] output = md.digest();

            //ajouter de la complexité au password
            final char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

            for (int j = 0; j < output.length; j++) {
                buf.append(hexDigit[(output[j] >> 4) & 0x0f]);
            }

        } catch (final NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return buf.toString();

    }

}
