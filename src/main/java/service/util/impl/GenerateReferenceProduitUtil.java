/**
 * 
 */
package service.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Classe repr�sentant l'impl�mentation d'une r�f�rence pour un produit
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
