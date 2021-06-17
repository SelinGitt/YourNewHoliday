/**
 * 
 */
package presentation.utilisateur.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Validator pour le formulaire du controller ConnecterController, valide l'UtilisateurDto
 *
 * @author Damien D.
 */
@Component
public class ConnecterValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        //Vérification du remplissage des champs
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "usr07.erreur.email_vide", "Default Error");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "usr07.erreur.password_vide", "Default Error");
        final var utilisateurDto = (UtilisateurDto) target;
        //Vérification du format de l'adresse email
        if (!utilisateurDto.getEmail().isBlank() && !utilisateurDto.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            errors.rejectValue("email", "usr07.erreur.email_format", new Object[] {utilisateurDto.getEmail()}, "Default Error");
        }
    }
}
