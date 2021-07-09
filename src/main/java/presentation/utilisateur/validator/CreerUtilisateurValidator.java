/**
 * 
 */
package presentation.utilisateur.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.utilisateur.dto.UtilisateurDto;
import service.util.DateFormatUtil;

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
        final var defaultError = "Default Error";

        // Check si champs empty ou blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "usr05.erreur.nom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "usr05.erreur.prenom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", "usr05.erreur.adresse_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "usr05.erreur.dateNaissance_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "usr05.erreur.email_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "usr05.erreur.password_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "usr05.erreur.confirmPassword_required", defaultError);

        final var user = (UtilisateurDto) target;

        //Vérification du format de l'adresse email
        final var email = user.getEmail();
        final var pattern = Pattern.compile("^\\S{1,318}@\\S{1,318}+$");
        final var matcher = pattern.matcher(email);

        //Si email n'est pas blank et n'est pas au bon format
        if (!email.isBlank() && !matcher.matches()) {
            errors.rejectValue("email", "usr05.erreur.email_format", new Object[] {email}, defaultError);
        }

        // TODO : Check format mdp

        // Check si password et confirm password sont egaux
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("confirmPassword", "usr05.erreur.password_match");
        }

        // Check si la date est valide
        if (!DateFormatUtil.checkDate(user.getDateNaissance())) {
            errors.rejectValue("dateNaissance", "usr05.erreur.date_format");
        }

        // S'il y a des erreurs
        if (errors.hasErrors()) {
            errors.reject("usr05.erreur.creation", defaultError);
        }
    }
}
