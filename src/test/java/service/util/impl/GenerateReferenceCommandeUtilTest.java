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

import presentation.utilisateur.dto.UtilisateurDto;
import service.util.IGenerateReferenceUtil;

/**
 * Classe repr�sentant les test unitaire de la g�n�ration de r�f�rence des commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class GenerateReferenceCommandeUtilTest {

    @Autowired
    @Qualifier("CMD")
    private IGenerateReferenceUtil iGenerateReferenceUtil;

    private static final String    REGEX = "[A-Z0-9]{15}";

    /**
     * Test method for {@link service.util.impl.GenerateReferenceCommandeUtil}.
     */
    @Test
    void testGenerateRefNotNull() {
        assertNotNull(this.iGenerateReferenceUtil);
    }

    /**
     * Test method for {@link service.util.impl.AbstractGenerateReferenceUtil#generateReference()}.
     */
    @Test
    void testGenerateRef() {
        final UtilisateurDto utilisateur = new UtilisateurDto();
        utilisateur.setNom("NomDuCLient");
        utilisateur.setPrenom("PrenomDuClient");
        final String reference = this.iGenerateReferenceUtil.generateReference(utilisateur, 5);
        assertTrue(reference.matches(REGEX));
    }

}
