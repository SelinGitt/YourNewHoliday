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

}
