/**
 * 
 */
package service.panier;

import java.util.List;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;

/**
 * Interface Métier du panier
 *
 * @author NathanR
 */
public interface IPanierService {

    /**
     * Permet de mettre un jour un panier
     *
     * @param  panier    : le panier à mettre à jour
     * @param  idProduit : l'id du produit à ajouter au panier
     * @param  quantite  : la quantité de ce produit à ajouter
     * @return           : le panier mis à jour
     */
    PanierDto updatePanier(final PanierDto panier, final Integer idProduit, final Integer quantite);

    /**
     * Permet de retrouver un produit dans la map à partir de son ID
     *
     * @param  panier    : le panier en session
     * @param  idProduit : l'id du produit recherché
     * @return           : le produit recherché
     */
    public ProduitDto findProduitMap(final PanierDto panier, final Integer idProduit);

    /**
     * Permet de supprimer un produit du panier
     *
     * @param panier    : le panier en session
     * @param idProduit : l'id du produit à supprimer
     */
    public void deleteProduitPanier(final PanierDto panier, final Integer idProduit);

    /**
     * Permet de vider le panier
     *
     * @param panier : le panier dans la session qui doit etre vider
     */
    void viderPanier(final PanierDto panier);

    /**
     * Permet de calculer le prix total d'un panier
     *
     * @param  panier : le panier en session
     * @return        : le prix total du panier
     */
    String calculerPrixTotal(final PanierDto panier);

    /**
     * Permet d'appliquer la remise si les conditions sont réunies
     *
     * @param panier : le panier en session
     */
    void appliquerRemise(final PanierDto panier);

    /**
     * Permet de mettre à jour le prix total, la remise et le prix après remise du panier
     *
     * @param panier : le panier en session
     */
    void actualiserPrix(final PanierDto panier);

    /**
     * Permets de modifier la quantité d'un produit depuis le panier
     *
     * @param panier    du client en session
     * @param idProduit du produit à modifier
     * @param quantite  +1/-1 pour incrémenter/décrémenter la quantité
     */
    void modifierQuantite(final PanierDto panier, final Integer idProduit, final int quantite);

    /**
     * Permet d'enregistrer le panier en une commande
     *
     * @param  panier        : le panier en sesion
     * @param  idUtilisateur : l'identifiant de l'utilisateur en session
     * @return               List{@code<Integer>} : null si utilisateur KO, vide si panier OK, liste des identifiants de
     *                       produits non valide
     */
    List<Integer> validerPanier(final PanierDto panier, final Integer idUtilisateur);

}
