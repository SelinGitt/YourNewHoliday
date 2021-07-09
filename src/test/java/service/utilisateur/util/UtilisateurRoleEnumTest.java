/**
 * 
 */
package service.utilisateur.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * JUnit test pour {@link service.utilisateur.util.UtilisateurRoleEnum}
 *
 * @author Valentin
 */
class UtilisateurRoleEnumTest {

    /**
     * Test pour {@link UtilisateurRoleEnum#getRole(String)}
     */
    @Test
    void test() {
        Assertions.assertEquals(UtilisateurRoleEnum.VISITEUR, UtilisateurRoleEnum.getRole("Visiteur"));
        Assertions.assertEquals(UtilisateurRoleEnum.CLIENT, UtilisateurRoleEnum.getRole("Client"));
        Assertions.assertEquals(UtilisateurRoleEnum.ADMINISTRATEUR, UtilisateurRoleEnum.getRole("Administrateur"));
        Assertions.assertNull(UtilisateurRoleEnum.getRole("ROLE"));
    }

}
