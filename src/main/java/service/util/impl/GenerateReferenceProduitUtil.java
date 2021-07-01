/**
 * 
 */
package service.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Classe représentant l'implémentation d'une référence pour un produit
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Component
@Qualifier("PRD")
public class GenerateReferenceProduitUtil extends AbstractGenerateReferenceUtil {

    /**
     * Constructor
     */
    public GenerateReferenceProduitUtil() {
        this.prefix = "";
    }

}
