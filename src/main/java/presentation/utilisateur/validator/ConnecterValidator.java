/**
 * 
 */
package presentation.utilisateur.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        final var email = utilisateurDto.getEmail();

        final Pattern pattern = Pattern.compile("^\\S+@\\S+$");
        final Matcher matcher = pattern.matcher(email);

        if (!email.isBlank() && !matcher.matches()) {
            errors.rejectValue("email", "usr07.erreur.email_format", new Object[] {email}, "Default Error");
        }
    }
}
