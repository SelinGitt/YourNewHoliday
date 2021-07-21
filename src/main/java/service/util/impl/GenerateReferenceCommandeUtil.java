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

}
