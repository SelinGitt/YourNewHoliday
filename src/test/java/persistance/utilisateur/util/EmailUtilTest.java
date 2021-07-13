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
     * Test OK pour {@link persistance.utilisateur.util.EmailUtil#isValidEmail(String)}
     */
    @Test
    void testIsValidEmailOK() {
        Assertions.assertTrue(EmailUtil.isValidEmail("test@test.fr"));
        Assertions.assertTrue(EmailUtil.isValidEmail("Aeztzet949@test.fr"));
        Assertions.assertTrue(EmailUtil.isValidEmail("198494@ezrzerzer.com"));
    }

    /**
     * Test KO pour {@link persistance.utilisateur.util.EmailUtil#isValidEmail(String)}
     */
    @Test
    void testIsValidEmailKO() {
        Assertions.assertFalse(EmailUtil.isValidEmail(""));
        Assertions.assertFalse(EmailUtil.isValidEmail("test"));
        Assertions.assertFalse(EmailUtil.isValidEmail("test.test"));
    }
}
