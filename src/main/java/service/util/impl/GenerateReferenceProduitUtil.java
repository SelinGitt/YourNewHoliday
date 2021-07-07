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
        // le pr�fixe est vide pour produit car on doit le g�n�rer � partir de la destination
        // on utilisera la m�thode constructPrefix avec comme valeur la destination avant
        // d'appeler la m�thode generateReference()
        this.prefix = "";
    }

}
