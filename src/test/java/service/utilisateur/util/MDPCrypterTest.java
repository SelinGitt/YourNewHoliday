/**
 * 
 */
package service.utilisateur.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Junit pour tester la m�thode de cryptage des mdp du site
 *
 * @author Meliodas-sama
 */
class MDPCrypterTest {

    /**
     * Test method for {@link service.utilisateur.util.MDPCrypter#crypterMDPV1(java.lang.String)}.
     */
    @Test
    void testCrypterMDPV1() {
        final String psw = MDPCrypter.crypterMDPV1("TestConnexionNonEncoreHashe");
        //le premier �l�ment du assertEquals repr�sente le mdp ci-dessus apr�s avoir �t� crypt�
        Assertions.assertEquals("13090376696E0E956AE6", psw);
    }

}