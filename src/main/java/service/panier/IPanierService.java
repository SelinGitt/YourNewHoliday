/**
 * 
 */
package service.panier;

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

}
