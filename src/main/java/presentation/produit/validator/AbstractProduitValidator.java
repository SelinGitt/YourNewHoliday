/**
 * 
 */
package presentation.produit.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.produit.dto.ProduitDto;
import service.util.DecimalFormatUtils;

/**
 * Classe Abstraite repr�sentant le Produitvalidator
 *
 * @author Administrateur
 */
public abstract class AbstractProduitValidator implements Validator {

    /**
     * Le nombre de caract�re autoris� pour la r�f�rence
     */
    protected static final int LONGUEUR_REFERENCE = 10;

    @Override
    public boolean supports(final Class<?> clazz) {
        return ProduitDto.class.isAssignableFrom(clazz);
    }

    /**
     * Permet de valider les champs du formulaire selon le nom de la page
     *
     * @param target l'objet � valider
     * @param errors les errors li�es au binding
     * @param page   le nom de la page
     */
    protected void validateProduit(final Object target, final Errors errors, final String page) {

        //errors, le field � checker, le message d'erreur, message par d�faut
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", page + ".nom.vide", "Fieldname is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", page + ".destination.vide", "Destination is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "miseEnVente", page + ".miseEnVente.vide", "Put On Sale is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", page + ".description.vide", "Description is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prixUnitaire", page + ".prix.vide", "Price is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reference", page + ".reference.vide", "Reference is required");

        //Cast pour v�rification plus fine
        final var produitDto = (ProduitDto) target;

        // Test du format de prix

        try {
            // Conversion du prix au bon format
            if (DecimalFormatUtils.doubleFormatUtil(produitDto.getPrixUnitaire()) < 0) {
                errors.rejectValue("prixUnitaire", page + ".prix.negatif");
            }
        } catch (final NumberFormatException exception) {
            errors.rejectValue("prixUnitaire", page + ".prix.format");
        }

        final var ref = produitDto.getReference();
        // Les r�gles de valdation sont appliqu�s si le champs r�f�rence n'est pas vide
        if (!ref.isBlank()) {
            if (!ref.matches("([1-9A-Z]){10}")) {
                errors.rejectValue("reference", page + ".reference.format");
            }

            if (ref.length() != LONGUEUR_REFERENCE) {
                errors.rejectValue("reference", page + ".reference.nbCaractere");
            }
        }
    }
}
