/**
 * 
 */
package persistance.utilisateur.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import presentation.utilisateur.util.PasswordUtil;

/**
 * JUnit class pour {@link persistance.utilisateur.util.PasswordUtil}
 *
 * @author Valentin
 */
class PasswordUtilTest {

    /**
     * Test OK pour {@link persistance.utilisateur.util.PasswordUtil#isValidPassword(String)}
     */
    @Test
    void testIsValidEmailOK() {
        Assertions.assertTrue(PasswordUtil.isValidPassword("123Testee"));
        Assertions.assertTrue(PasswordUtil.isValidPassword("Aeztze8484"));
        Assertions.assertTrue(PasswordUtil.isValidPassword("etez46484TEZTZET"));
    }

    /**
     * Test KO pour {@link persistance.utilisateur.util.EmailUtil#isEmailValid(String)}
     */
    @Test
    void testIsValidEmailKO() {
        Assertions.assertFalse(PasswordUtil.isValidPassword(""));
        Assertions.assertFalse(PasswordUtil.isValidPassword("test"));
        Assertions.assertFalse(PasswordUtil.isValidPassword("test8"));
        Assertions.assertFalse(PasswordUtil.isValidPassword("AZtest8zetgzetezrfzerzerezrzerzer"));
    }
}
