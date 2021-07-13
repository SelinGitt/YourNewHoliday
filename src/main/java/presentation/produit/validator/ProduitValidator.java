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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", "pdt03.destination.vide", "Destination is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "miseEnVente", "pdt03.miseEnVente.vide", "Put On Sale is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "pdt03.description.vide", "Description is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prixUnitaire", "pdt03.prix.vide", "Price is required");

        //Cast pour v�rification plus fine
        final var produitDto = (ProduitDto) target;

        // Test du format de prix
        try {
            Double.valueOf(produitDto.getPrixUnitaire());
        } catch (NumberFormatException exception) {
            errors.rejectValue("prixUnitaire", "pdt03.prix.format");
        }

        final var ref = produitDto.getReference();
        // Les r�gles de valdation sont appliqu�s si le champs r�f�rence n'est pas vide
        if (!ref.isBlank()) {
            if (!ref.matches("([A-Z]){3}([1-9A-Z]){7}")) {
                errors.rejectValue("reference", "pdt03.reference.format");
            }

            if (ref.length() != 10) {
                errors.rejectValue("reference", "pdt03.reference.nbCaractere");
            }
        }
    }
}
