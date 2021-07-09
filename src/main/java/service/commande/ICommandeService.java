/**
 * 
 */
package service.commande;

import java.util.List;
import java.util.Map;

import presentation.commande.dto.CommandeDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;

/**
 * Interface pour les services sur les Commandes
 *
 * @author Hanan Anghari
 */
public interface ICommandeService {

    /**
     * Permet de lister les commandes d'un utilisateur
     *
     * @param  idUser l'identifiant de l'utilisateur
     * @return        List{@literal<}CommandeDto{@literal>} la liste des commandes
     */
    List<CommandeDto> listerCommandesUtilisateur(final Integer idUser);

    /**
     * Permet de trouver une commande à partir de sa référence
     *
     * @param  reference la référence de la commande qu'on cherche
     * @return           CommandeDto la commandeDto qu'on a trouvée
     */
    CommandeDto chercherCommandeParReference(final String reference);

    /**
     * Permet de vérifier si les produits de la Map sont bien en vente et à la bonne version
     *
     * @param  produitsPanier les produits du panier
     * @return                List{@code<Integer>} liste des Identifiant des produits non valide
     */
    List<Integer> verifierProduitsAvecVersion(final Map<ProduitDto, LigneCommandeProduitDto> produitsPanier);

    /**
     * Permet de générer la commande à partir d'un panier
     *
     * @param  panier le panier en session
     * @return        String la référence de la commande
     */
    String passerCommande(final PanierDto panier);
}
