/**
 * 
 */
package presentation.produit.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.produit.dto.ProduitDto;

/**
 * Classe repr�sentant le validator pour un produitDto
 *
 * @author Administrateur
 */
public class ProduitValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return ProduitDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        //errors, le field � checker, le message d'erreur, message par d�faut
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "pdt03.nom.vide", "Fieldname is required");

    }

}
