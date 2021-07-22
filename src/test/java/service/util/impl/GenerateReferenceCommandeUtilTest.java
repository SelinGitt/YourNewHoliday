/**
 * 
 */
package service.util.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

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
    void testGenerateRefOk() {
        final UtilisateurDto utilisateur = new UtilisateurDto();
        utilisateur.setNom("nomDuCLient");
        utilisateur.setPrenom("prenomDuClient");
        final Date date = new Date();
        final String reference = this.iGenerateReferenceUtil.generateReference(utilisateur, 5, date);
        assertTrue(reference.matches(REGEX));

    }

    void testGenerateRefKo() {
        final UtilisateurDto utilisateur = new UtilisateurDto();
        utilisateur.setNom("nomDuCLient");
        utilisateur.setPrenom("prenomDuClient");
        final Date date = new Date();
        // V�rification du controle des donn�es
        String referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(utilisateur, -2, date);
        assertNull(referenceImpossibleACree);
        referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(utilisateur, 6, null);
        assertNull(referenceImpossibleACree);
        referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(null, 6, date);
        assertNull(referenceImpossibleACree);
        utilisateur.setNom(null);
        referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(utilisateur, 6, date);
        assertNull(referenceImpossibleACree);
        utilisateur.setNom("nomDuCLient");
        utilisateur.setPrenom(null);
        referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(utilisateur, 6, date);
        assertNull(referenceImpossibleACree);
        utilisateur.setNom("");
        referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(utilisateur, 6, date);
        assertNull(referenceImpossibleACree);
        utilisateur.setNom("nomDuCLient");
        utilisateur.setPrenom("");
        referenceImpossibleACree = this.iGenerateReferenceUtil.generateReference(utilisateur, 6, date);
        assertNull(referenceImpossibleACree);
    }

}
