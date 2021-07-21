/**
 * 
 */
package presentation.utilisateur.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.util.PasswordUtil;

/**
 * Classe CreerUtilisateurValidator
 *
 * @author Valentin
 */
@Component
public class CreerUtilisateurValidator implements Validator {

    @Autowired
    UtilisateurValidator utilisateurValidator;

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        // Validation des champs commun
        this.utilisateurValidator.validate(target, errors, "usr05");

        final var defaultError = "Default Error";

        // Check si champs empty ou blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "usr05.erreur.password_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "usr05.erreur.confirmPassword_required", defaultError);

        final var user = (UtilisateurDto) target;

        // Check format du mot de passe
        if (!PasswordUtil.isValidPassword(user.getPassword())) {
            errors.rejectValue("password", "usr05.erreur.password_format", defaultError);
        }

        // Check si password et confirm password sont egaux
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("confirmPassword", "usr05.erreur.password_match", defaultError);
        }
    }
}
