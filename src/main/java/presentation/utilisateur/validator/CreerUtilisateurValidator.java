/**
 * 
 */
package presentation.utilisateur.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.util.PasswordUtil;

/**
 * Classe CreerUtilisateurValidator
 *
 * @author Valentin
 */
@Component
public class CreerUtilisateurValidator extends AbstractUtilisateurValidator {

    @Override
    public void validate(final Object target, final Errors errors) {
        // Validation des champs commun
        this.validateUser(target, errors, "usr05");

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

        // Check la taille des champs password & confirm password
        this.validateLength(errors, "password", "usr05.erreur.password_length", defaultError);
        this.validateLength(errors, "confirmPassword", "usr05.erreur.confirm_password_length", defaultError);
    }
}
