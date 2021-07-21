/**
 * 
 */
package presentation.utilisateur.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.util.EmailUtil;
import presentation.utilisateur.util.PasswordUtil;
import service.util.DateFormatUtil;

/**
 * Classe EditerUtilisateurValidator
 *
 * @author Valentin
 */
@Component
public class EditerUtilisateurValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final var defaultError = "Default Error";

        // Check si champs empty ou blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "usr02.erreur.nom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "usr02.erreur.prenom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", "usr02.erreur.adresse_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "usr02.erreur.dateNaissance_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "usr02.erreur.email_required", defaultError);

        final var user = (UtilisateurDto) target;

        //Si email n'est pas valide
        if (!EmailUtil.isValidEmail(user.getEmail())) {
            errors.rejectValue("email", "usr02.erreur.email_format", defaultError);
        }

        // Check si la date est valide
        if (!user.getDateNaissance().isEmpty() && !DateFormatUtil.checkDate(user.getDateNaissance())) {
            errors.rejectValue("dateNaissance", "usr02.erreur.date_format", defaultError);
        }

        // Si on souhaite changer le mot de passe 
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
        }
    }

}
