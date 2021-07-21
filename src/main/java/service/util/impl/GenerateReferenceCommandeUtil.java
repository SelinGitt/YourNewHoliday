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

    private UtilisateurDto utilisateur;
    private Integer        nombreDeProduit;

    /**
     * Constructor
     */
    public GenerateReferenceCommandeUtil() {
        // le pr�fixe est vide pour commande car on doit g�n�rer la r�f�rence � partir du hash
        // de nom Client, pr�nom Client, nombre de produits dans le panier, date d'achat.        
        this.prefix = "";
    }

}
