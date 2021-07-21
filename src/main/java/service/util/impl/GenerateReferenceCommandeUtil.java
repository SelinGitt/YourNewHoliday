/**
 * 
 */
package service.util.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Classe représentant l'implémentation d'une référence pour une commande
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
        // le préfixe est vide pour commande car on doit générer la référence à partir du hash
        // de : nom Client, prénom Client, nombre de produits dans le panier et date d'achat.        
        this.prefix = "";
    }

    @Override
    public String generateReference(final Object... param) {
        final var utilisateur = (UtilisateurDto) param[0];
        final var nombreDeProduit = param[1].toString();
        final var date = param[2].toString();
        // FIXME : debug
        System.out.println("Nom : " + utilisateur.getNom() + " Prénom : " + utilisateur.getPrenom() + " nombre de produits : "
                + nombreDeProduit + " Date : " + date);

        // TODO : Hashage 
        final var reference = "REFERENCETEST15";
        logger.info("Référence {} générée par {}", reference, this.getClass().getSimpleName());
        return reference;
    }

}
