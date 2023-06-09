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
 * Classe EditerUtilisateurValidator
 *
 * @author Valentin
 */
@Component
public class EditerUtilisateurValidator extends AbstractUtilisateurValidator {

    @Override
    public void validate(final Object target, final Errors errors) {
        // Validation des champs commun
        this.validateUser(target, errors, "usr02");

        final var defaultError = "Default Error";

        final var user = (UtilisateurDto) target;

        // Si on souhaite changer le mot de passe
        // On ne le met pas dans le commun car il peut etre empty
        // On ne check pas le confirm password car l'update utilise password
        if (!user.getPassword().isEmpty()) {
            // On reject si la confirmation de mot de passe n'est pas renseignee
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "usr02.erreur.confirmPassword_required", defaultError);
            // Check format du mot de passe
            if (!PasswordUtil.isValidPassword(user.getPassword())) {
                errors.rejectValue("password", "usr02.erreur.password_format", defaultError);
            }

            // Check si password et confirm password sont egaux
            if (!(user.getPassword().equals(user.getConfirmPassword()))) {
                errors.rejectValue("confirmPassword", "usr02.erreur.password_match", defaultError);
            }

            // Check la taille des champs password & confirm password
            this.validateLength(errors, "password", "usr02.erreur.password_length", defaultError);
            this.validateLength(errors, "confirmPassword", "usr02.erreur.confirm_password_length", defaultError);
        }
    }

}
