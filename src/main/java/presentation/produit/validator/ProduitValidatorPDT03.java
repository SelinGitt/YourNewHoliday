/**
 * 
 */
package presentation.produit.validator;

import org.springframework.validation.Errors;

/**
 * Classe repr�sentant le validator du produitDto pour l'�cran PDT03 : Cr�ation produit
 *
 * @author Administrateur
 */
public class ProduitValidatorPDT03 extends AbstractProduitValidator {

    @Override
    public void validate(final Object target, final Errors errors) {

        this.validateProduit(target, errors, "pdt03");
    }
}
