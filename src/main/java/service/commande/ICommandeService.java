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
     * Permet de trouver une commande � partir de sa r�f�rence
     *
     * @param  reference la r�f�rence de la commande qu'on cherche
     * @return           CommandeDto la commandeDto qu'on a trouv�e
     */
    CommandeDto chercherCommandeParReference(final String reference);

    /**
     * Permet de v�rifier si les produits de la Map sont bien en vente et � la bonne version
     *
     * @param  produitsPanier les produits du panier
     * @return                List{@code<Integer>} liste des Identifiant des produits non valide
     */
    List<Integer> verifierProduitsAvecVersion(final Map<ProduitDto, LigneCommandeProduitDto> produitsPanier);

    /**
     * Permet de g�n�rer la commande � partir d'un panier
     *
     * @param  panier le panier en session
     * @return        String la r�f�rence de la commande
     */
    String passerCommande(final PanierDto panier);
}
