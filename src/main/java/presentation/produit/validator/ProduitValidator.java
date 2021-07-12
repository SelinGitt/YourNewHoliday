/**
 * 
 */
package presentation.produit.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.produit.dto.ProduitDto;

/**
 * Classe représentant le validator pour un produitDto
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

        //errors, le field à checker, le message d'erreur, message par défaut
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "pdt03.nom.vide", "Fieldname is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", "pdt03.destination.vide", "Destination is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "miseEnVente", "pdt03.miseEnVente.vide", "Put On Sale is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "pdt03.description.vide", "Description is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prixUnitaire", "pdt03.prix.vide", "Price is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reference", "pdt03.reference.vide", "Reference is required");

        //Cast pour vérification plus fine
        final var produitDto = (ProduitDto) target;

        if (!produitDto.getReference().matches("([A-Z]){3}([1-9]){7}")) {
            errors.rejectValue("reference", "pdt03.reference.format");
        }

        if (produitDto.getReference().length() != 10) {
            errors.rejectValue("reference", "pdt03.reference.nbCaractere");
        }

    }

}
