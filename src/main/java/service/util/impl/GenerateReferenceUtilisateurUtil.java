/**
 * 
 */
package service.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Classe représentant l'implémentation d'une référence pour un utilisateur
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Component
@Qualifier("USR")
public class GenerateReferenceUtilisateurUtil extends AbstractGenerateReferenceUtil {

    /**
     * Constructor
     */
    public GenerateReferenceUtilisateurUtil() {
        this.prefix = "USR";
    }
}
