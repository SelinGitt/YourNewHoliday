/**
 * 
 */
package service.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Classe représentant les tests unitaires pour la génération de référence
 *
 * @author Administrateur
 */
class GenerateReferenceUtilTest {

    private static final String REGEX_SUFIX = "[A-Z0-9]{7}";

    /**
     * Test method for
     * {@link service.util.GenerateReferenceUtil#generateReference(java.lang.String, service.util.GenerateReferenceUtil.TypeReference)}.
     */
    @Test
    void testGenerateReferenceCommande() {
        final String reference = GenerateReferenceUtil.generateReference("", GenerateReferenceUtil.TypeReference.COMMANDE);
        final String regexCommande = GenerateReferenceUtil.TypeReference.COMMANDE.getPrefix() + REGEX_SUFIX;
        assertTrue(reference.matches(regexCommande));
    }

    /**
     * Test method for
     * {@link service.util.GenerateReferenceUtil#generateReference(java.lang.String, service.util.GenerateReferenceUtil.TypeReference)}.
     */
    @Test
    void testGenerateReferenceProduit() {
        final String reference = GenerateReferenceUtil.generateReference("Italie", GenerateReferenceUtil.TypeReference.PRODUIT);
        final String regexProduit = "ITA" + REGEX_SUFIX;
        assertTrue(reference.matches(regexProduit));
    }

    /**
     * Test method for
     * {@link service.util.GenerateReferenceUtil#generateReference(java.lang.String, service.util.GenerateReferenceUtil.TypeReference)}.
     */
    @Test
    void testGenerateReferenceUtilisateur() {
        final String reference = GenerateReferenceUtil.generateReference("", GenerateReferenceUtil.TypeReference.UTILISATEUR);
        final String regexUtilisateur = GenerateReferenceUtil.TypeReference.UTILISATEUR.getPrefix() + REGEX_SUFIX;
        assertTrue(reference.matches(regexUtilisateur));
    }

}
