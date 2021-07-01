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
 * Classe représentant les test unitaire de la génération de référence des produits
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class GenerateReferenceProduitUtilTest {

    @Autowired
    @Qualifier("PRD")
    private IGenerateReferenceUtil iGenerateReferenceUtil;

    private static final String    REGEX_SUFIX = "[A-Z0-9]{7}";

    /**
     * Test method for {@link service.util.impl.GenerateReferenceProduitUtil}.
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
        final String destination = "Italie";
        this.iGenerateReferenceUtil.constructPrefix(destination);
        final String reference = this.iGenerateReferenceUtil.generateRef();
        assertTrue(reference.matches(destination.substring(0, 3).toUpperCase() + REGEX_SUFIX));
    }

}
