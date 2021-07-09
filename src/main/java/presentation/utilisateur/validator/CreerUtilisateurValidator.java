/**
 * 
 */
package presentation.utilisateur.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Classe CreerUtilisateurValidator
 *
 * @author Valentin
 */
@Component
public class CreerUtilisateurValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final var user = (UtilisateurDto) target;

        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("password", "ggfzgze");
        }

    }
}
