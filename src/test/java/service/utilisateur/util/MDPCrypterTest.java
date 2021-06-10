/**
 * 
 */
package service.utilisateur.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Junit pour tester la méthode de cryptage des mdp du site
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
        //le premier élément du assertEquals représente le mdp ci-dessus après avoir été crypté
        Assertions.assertEquals("13090376696E0E956AE6", psw);
    }

}