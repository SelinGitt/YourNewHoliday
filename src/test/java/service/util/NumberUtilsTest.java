/**
 * 
 */
package service.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Classe test de {@link NumberUtils}
 *
 * @author Lucas
 */
class NumberUtilsTest {

    /**
     * Test method for {@link service.util.NumberUtils#validate(java.lang.String)}.
     */
    @Test
    void testValidate() {
        assertTrue(NumberUtils.validate("14"));
        assertFalse(NumberUtils.validate("sdqd"));
        //test avec nombre + string
        assertFalse(NumberUtils.validate("14sdqd"));
    }

}
