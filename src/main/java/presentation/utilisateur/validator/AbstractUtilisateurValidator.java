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
public abstract class AbstractUtilisateurValidator implements Validator {

    private static final String DEFAULT_ERROR = "Default Error";

    @Override
    public boolean supports(final Class<?> clazz) {
        return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    /**
     * Permet de valider des champs
     *
     * @param target Target a valider
     * @param errors Errors
     * @param page   Radical permetant la gestion des messages d'erreur
     */
    protected void validateUser(final Object target, final Errors errors, final String page) {

        // Check si champs empty ou blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", page + ".erreur.nom_required", DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", page + ".erreur.prenom_required", DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", page + ".erreur.adresse_required", DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", page + ".erreur.dateNaissance_required", DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", page + ".erreur.email_required", DEFAULT_ERROR);

        final var user = (UtilisateurDto) target;

        //Si email n'est pas valide
        if (!EmailUtil.isValidEmail(user.getEmail())) {
            errors.rejectValue("email", page + ".erreur.email_format", DEFAULT_ERROR);
        }

        // Check si la date est valide
        if (!user.getDateNaissance().isEmpty() && !DateFormatUtil.checkDate(user.getDateNaissance())) {
            errors.rejectValue("dateNaissance", page + ".erreur.date_format", DEFAULT_ERROR);
        }
    }

    /**
     * Permet de valider la taille des inputs
     *
     * @param target Target a valider
     * @param errors Errors
     * @param page   Radical permetant la gestion des messages d'erreur
     */
    protected void validateLength(final Object target, final Errors errors, final String page) {
        final var user = (UtilisateurDto) target;

        if (user.getNom().length() > 50) {
            errors.rejectValue("nom", page + ".erreur.nom_length", DEFAULT_ERROR);
        }

        if (user.getPrenom().length() > 50) {
            errors.rejectValue("prenom", page + ".erreur.prenom_length", DEFAULT_ERROR);
        }

        if (user.getAdresse().length() > 255) {
            errors.rejectValue("adresse", page + ".erreur.adresse_length", DEFAULT_ERROR);
        }

        if (user.getEmail().length() > 320) {
            errors.rejectValue("email", page + ".erreur.email_length", DEFAULT_ERROR);
        }
    }
}
