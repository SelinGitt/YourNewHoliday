/**
 * 
 */
package presentation.utilisateur.validator;

import java.util.HashMap;

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

        this.validateLength(errors, "nom", page + ".erreur.nom_length", DEFAULT_ERROR);
        this.validateLength(errors, "prenom", page + ".erreur.prenom_length", DEFAULT_ERROR);
        this.validateLength(errors, "adresse", page + ".erreur.adresse_length", DEFAULT_ERROR);
        this.validateLength(errors, "dateNaissance", page + ".erreur.dateNaissance_length", DEFAULT_ERROR);
        this.validateLength(errors, "email", page + ".erreur.email_length", DEFAULT_ERROR);

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

    protected void validateLength(final Errors errors, final String field, final String errorCode, final String defaultCode) {
        final var mapLength = new HashMap<String, Integer>();
        this.initMap(mapLength);

        if (mapLength.containsKey(field)) {
            final String value = (String) errors.getFieldValue(field);
            if (value.length() > mapLength.get(field)) {
                errors.rejectValue(field, errorCode, defaultCode);
            }
        }
    }

    /**
     * Permet d'initialiser une map pour check la taille des champs
     *
     * @param map Map ou l'on stock des donnees
     */
    private void initMap(final HashMap<String, Integer> map) {
        map.put("nom", 50);
        map.put("prenom", 50);
        map.put("adresse", 255);
        map.put("email", 320);
        map.put("dateNaissance", 10);
        map.put("password", 255);
        map.put("confirmPassword", 255);
    }
}
