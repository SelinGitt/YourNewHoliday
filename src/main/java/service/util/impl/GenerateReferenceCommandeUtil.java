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

    private UtilisateurDto utilisateur;
    private Integer        nombreDeProduit;

    /**
     * Constructor
     */
    public GenerateReferenceCommandeUtil() {
        // le préfixe est vide pour commande car on doit générer la référence à partir du hash
        // de nom Client, prénom Client, nombre de produits dans le panier, date d'achat.        
        this.prefix = "";
    }

    @Override
    public String generateReference(final Object... param) {
        this.utilisateur = (UtilisateurDto) param[0];
        this.nombreDeProduit = (Integer) param[1];
        // FIXME : debug
        System.out.println("Utilisateur : " + utilisateur + " nombre de produits : " + nombreDeProduit);

        final String reference = "REFERENCETEST58";
        logger.info("Référence {} générée par {}", reference, this.getClass().getSimpleName());
        return reference;
    }

}
