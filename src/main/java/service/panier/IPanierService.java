/**
 * 
 */
package service.panier;

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

}
