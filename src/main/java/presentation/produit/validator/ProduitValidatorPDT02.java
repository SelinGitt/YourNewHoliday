/**
 * 
 */
package presentation.produit.validator;

import org.springframework.validation.Errors;

/**
 * Classe repr�sentant le validator pour un produitDto
 *
 * @author Administrateur
 */
public class ProduitValidatorPDT02 extends AbstractProduitValidator {

    @Override
    public void validate(final Object target, final Errors errors) {

        this.validateProduit(target, errors, "pdt02");
    }
}
