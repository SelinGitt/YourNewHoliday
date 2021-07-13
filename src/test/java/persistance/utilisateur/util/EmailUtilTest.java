/**
 * 
 */
package persistance.utilisateur.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import presentation.utilisateur.util.EmailUtil;

/**
 * JUnit class pour {@link persistance.utilisateur.util.EmailUtil}
 *
 * @author Valentin
 */
class EmailUtilTest {

    /**
     * Test OK pour {@link persistance.utilisateur.util.EmailUtil#isEmailValid(String)}
     */
    @Test
    void testIsValidEmailOK() {
        Assertions.assertTrue(EmailUtil.isEmailValid("test@test.fr"));
        Assertions.assertTrue(EmailUtil.isEmailValid("Aeztzet949@test.fr"));
        Assertions.assertTrue(EmailUtil.isEmailValid("198494@ezrzerzer.com"));
    }

    /**
     * Test KO pour {@link persistance.utilisateur.util.EmailUtil#isEmailValid(String)}
     */
    @Test
    void testIsValidEmailKO() {
        Assertions.assertFalse(EmailUtil.isEmailValid(""));
        Assertions.assertFalse(EmailUtil.isEmailValid("test"));
        Assertions.assertFalse(EmailUtil.isEmailValid("test.test"));
    }
}
