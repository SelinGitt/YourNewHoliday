/**
 * 
 */
package presentation.utilisateur.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Validateur pour l'UtilisateurDto
 *
 * @author Damien
 */
public class USR_07Validator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "usr07.erreur.email_vide", "Default Error");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "usr07.erreur.password_vide", "Default Error");
        final UtilisateurDto utilisateurDto = (UtilisateurDto) target;
        if (!utilisateurDto.getEmail().matches(null)) {
            errors.rejectValue("email", "usr07.erreur.email_format", new Object[] {utilisateurDto.getEmail()}, "Default Error");
        }
    }
}
