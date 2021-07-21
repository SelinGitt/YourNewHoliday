/**
 * 
 */
package service.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Classe repr�sentant l'impl�mentation d'une r�f�rence pour une commande
 *
 * @author Administrateur
 */
@Component
@Qualifier("CMD")
public class GenerateReferenceCommandeUtil extends AbstractGenerateReferenceUtil {

    /**
     * Constructor
     */
    public GenerateReferenceCommandeUtil() {
        // le pr�fixe est vide pour commande car on doit g�n�rer la r�f�rence � partir du hash
        // de : nom Client, pr�nom Client, nombre de produits dans le panier et date d'achat.        
        this.prefix = "";
    }

    @Override
    public String generateReference(final Object... param) {
        final var utilisateur = (UtilisateurDto) param[0];
        final var nombreDeProduit = param[1].toString();
        final var date = param[2].toString();
        // FIXME : debug
        System.out.println("Nom : " + utilisateur.getNom() + " Pr�nom : " + utilisateur.getPrenom() + " nombre de produits : "
                + nombreDeProduit + " Date : " + date);

        // TODO : Hashage 
        final var reference = "REFERENCETEST15";
        logger.info("R�f�rence {} g�n�r�e par {}", reference, this.getClass().getSimpleName());
        return reference;
    }

}
