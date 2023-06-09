/**
 * 
 */
package service.panier;

import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.RetourValiderPanierDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;

/**
 * Interface M�tier du panier
 *
 * @author NathanR
 */
public interface IPanierService {

    /**
     * Permet de mettre un jour un panier
     *
     * @param  panier    : le panier � mettre � jour
     * @param  idProduit : l'id du produit � ajouter au panier
     * @param  quantite  : la quantit� de ce produit � ajouter
     * @return           : le panier mis � jour
     */
    PanierDto updatePanier(final PanierDto panier, final Integer idProduit, final Integer quantite);

    /**
     * Permet de retrouver un produit dans la map � partir de son ID
     *
     * @param  panier    : le panier en session
     * @param  idProduit : l'id du produit recherch�
     * @return           : le produit recherch�
     */
    public ProduitDto findProduitMap(final PanierDto panier, final Integer idProduit);

    /**
     * Permet de supprimer un produit du panier
     *
     * @param panier    : le panier en session
     * @param idProduit : l'id du produit � supprimer
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
     * Permet de v�rifier si les conditions d'application de la remise sont r�unies
     *
     * @param  panier : le panier en session
     * @return        : true si la remise est applicable, sinon false
     */
    boolean isRemiseExpected(final PanierDto panier);

    /**
     * Permet de mettre � jour le prix total, la remise et le prix apr�s remise du panier
     *
     * @param panier : le panier en session
     */
    void actualiserPrix(final PanierDto panier);

    /**
     * Permets de modifier la quantit� d'un produit depuis le panier
     *
     * @param  panier    du client en session
     * @param  idProduit du produit � modifier
     * @param  quantite  +1/-1 pour incr�menter/d�cr�menter la quantit�
     * @return           true si le produit �tait modifiable, false sinon.
     */
    boolean modifierQuantite(final PanierDto panier, final Integer idProduit, final int quantite);

    /**
     * Permet d'enregistrer le panier en une commande
     *
     * @param  panier        : le panier en sesion
     * @param  adresses      : objet contenant les adresses entr�es par l'utilisateur
     * @param  idUtilisateur : l'identifiant de l'utilisateur en session
     * @return               CommandePanierListProduitErreur : null si utilisateur KO, avec reference si panier OK, sinon
     *                       liste des identifiants de produits non valide non vide
     */
    RetourValiderPanierDto validerPanier(final PanierDto panier, final AdressesDto adresses, final Integer idUtilisateur);

}
