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

    private static final HashMap<String, Integer> MAP_LENGTH = new HashMap<>();

    /**
     * Constructor
     */
    protected AbstractUtilisateurValidator() {
        super();
        initMap(MAP_LENGTH);
    }

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
        final var defaultError = "Default Error";

        // Check si champs empty ou blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", page + ".erreur.nom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", page + ".erreur.prenom_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", page + ".erreur.adresse_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", page + ".erreur.dateNaissance_required", defaultError);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", page + ".erreur.email_required", defaultError);

        this.validateLength(errors, "nom", page + ".erreur.nom_length", defaultError);
        this.validateLength(errors, "prenom", page + ".erreur.prenom_length", defaultError);
        this.validateLength(errors, "adresse", page + ".erreur.adresse_length", defaultError);
        this.validateLength(errors, "dateNaissance", page + ".erreur.dateNaissance_length", defaultError);
        this.validateLength(errors, "email", page + ".erreur.email_length", defaultError);

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

    protected void validateLength(final Errors errors, final String field, final String errorCode, final String defaultCode) {
        final var length = MAP_LENGTH.get(field);

        if (length != null) {
            final String value = (String) errors.getFieldValue(field);
            if ((value != null) && (value.length() > length)) {
                errors.rejectValue(field, errorCode, defaultCode);
            }
        }
    }

    /**
     * Permet d'initialiser une map pour check la taille des champs
     *
     * @param map Map ou l'on stock des donnees
     */
    private static void initMap(final HashMap<String, Integer> map) {
        map.put("nom", 50);
        map.put("prenom", 50);
        map.put("adresse", 255);
        map.put("email", 320);
        map.put("dateNaissance", 10);
        map.put("password", 255);
        map.put("confirmPassword", 255);
    }
}
