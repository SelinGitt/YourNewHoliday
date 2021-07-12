/**
 * 
 */
package presentation.produit.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import presentation.produit.dto.BeanQuantite;
import service.util.NumberUtils;

/**
 * Classe validator de {@link BeanQuantite}
 *
 * @author Lucas
 */
@Component
public class QuantiteValidator implements Validator {

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantite", "Default error");
        final var beanQuantite = (BeanQuantite) target;
        if (!NumberUtils.validate(beanQuantite.getQuantite())) {
            errors.rejectValue("quantite", "default error");
        }
    }

    @Override
    public boolean supports(final Class<?> clazz) {
        return BeanQuantite.class.isAssignableFrom(clazz);
    }

}
