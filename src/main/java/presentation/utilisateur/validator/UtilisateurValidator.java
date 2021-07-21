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
import service.util.DateFormatUtil;

/**
 * Classe UtilisateurValidator
 *
 * @author Valentin
 */
@Component
public class UtilisateurValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        // Empty
    }

    /**
     * Permet de valider des champs
     *
     * @param target Target a valider
     * @param errors Errors
     * @param page   Radical permetant la gestion des messages d'erreur
     */
    public void validate(final Object target, final Errors errors, final String page) {
        final var defaultError = "Default Error";

        // Check si champs empty ou blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", page + ".erreur.nom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", page + ".erreur.prenom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", page + ".erreur.adresse_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", page + ".erreur.dateNaissance_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", page + ".erreur.email_required", defaultError);

        final var user = (UtilisateurDto) target;

        //Si email n'est pas valide
        if (!EmailUtil.isValidEmail(user.getEmail())) {
            errors.rejectValue("email", page + ".erreur.email_format", defaultError);
        }

        // Check si la date est valide
        if (!user.getDateNaissance().isEmpty() && !DateFormatUtil.checkDate(user.getDateNaissance())) {
            errors.rejectValue("dateNaissance", page + ".erreur.date_format", defaultError);
        }
    }
}
