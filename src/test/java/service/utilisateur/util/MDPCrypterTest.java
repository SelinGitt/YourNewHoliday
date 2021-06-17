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
        Assertions.assertEquals("46E43F808CF3CAB2C8AC6321D7FF743F43A13A412C38FAFFDDD8252D711113E2", psw);
    }

}