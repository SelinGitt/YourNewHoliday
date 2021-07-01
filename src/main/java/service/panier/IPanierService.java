/**
 * 
 */
package service.panier;

import presentation.panier.dto.PanierDto;

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
}
