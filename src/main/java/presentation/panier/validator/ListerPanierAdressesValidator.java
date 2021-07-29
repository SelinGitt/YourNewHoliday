/**
 * 
 */
package presentation.panier.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.commande.dto.CommandeAdresseDto;

/**
 * Validator pour le formulaire de saisie des adresses de PAN_08
 *
 * @author NathanR
 */
@Component
public class ListerPanierAdressesValidator implements Validator {

    /**
     * Constante default error indiquant le style que l'on souhaite appliquer aux erreurs.
     */
    private static final String DEFAULT_ERROR = "Default error";

    @Override
    public boolean supports(final Class<?> clazz) {
        return CommandeAdresseDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commandeAdresseLivraison.nom", "pan08.erreur.livraisonNom_vide", DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commandeAdresseLivraison.prenom", "pan08.erreur.livraisonPrenom_vide",
                DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commandeAdresseLivraison.adresse", "pan08.erreur.livraisonAdresse_vide",
                DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commandeAdresseFacturation.nom", "pan08.erreur.facturationNom_vide",
                DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commandeAdresseFacturation.prenom", "pan08.erreur.facturationPrenom_vide",
                DEFAULT_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commandeAdresseFacturation.adresse", "pan08.erreur.facturationAdresse_vide",
                DEFAULT_ERROR);
    }

}
