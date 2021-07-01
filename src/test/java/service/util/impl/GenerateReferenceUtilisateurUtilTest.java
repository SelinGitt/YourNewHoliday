/**
 * 
 */
package service.util.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import service.util.IGenerateReferenceUtil;

/**
 * Classe repr�sentant les test unitaire de la g�n�ration de r�f�rence des utilisateurs
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class GenerateReferenceUtilisateurUtilTest {
    
    @Autowired
    @Qualifier("USR")
    private IGenerateReferenceUtil iGenerateReferenceUtil;

    private static final String    REGEX_USR = "USR[A-Z0-9]{7}";

    /**
     * Test method for {@link service.util.impl.GenerateReferenceCommandeUtil}.
     */
    @Test
    void testGenerateRefNotNull() {
        assertNotNull(this.iGenerateReferenceUtil);
    }

    /**
     * Test method for {@link service.util.impl.AbstractGenerateReferenceUtil#generateRef()}.
     */
    @Test
    void testGenerateRef() {
        final String reference = this.iGenerateReferenceUtil.generateRef();
        assertTrue(reference.matches(REGEX_USR));
    }

}
