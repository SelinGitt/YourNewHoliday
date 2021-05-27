/**
 * 
 */
package pocLogBack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Classe de Test pour voir si les logs sont affichés en console et non en fichier texte
 *
 * @author Administrateur
 */
class POCLogBackTest {

    @Test
    void testGenerateLogs() {
        assertEquals(1, POCLogBack.generateLogs());
    }
}
