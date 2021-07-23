/**
 * 
 */
package presentation.produit.validator;

import org.springframework.validation.Errors;

/**
 * Classe représentant le validator du produitDto pour l'écran PDT03 : Création produit
 *
 * @author Administrateur
 */
public class ProduitValidatorPDT03 extends AbstractProduitValidator {

    @Override
    public void validate(final Object target, final Errors errors) {

        this.validateProduit(target, errors, "pdt03");
    }
}
