/**
 * 
 */
package persistance.produit.dao;

import java.util.List;

import persistance.commun.dao.IGenericDao;
import persistance.produit.entity.ProduitDo;

/**
 * Interface pour le CRUD des produits
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface IProduitDao extends IGenericDao<ProduitDo> {

    /**
     * Permet de r�cup�rer la liste des produits en vente
     *
     * @return la liste des produits en vente
     */
    List<ProduitDo> findAllProduitsEnVente();

    /**
     * Permet de r�cup�rer un produit en vente
     *
     * @param  idProduit : l'id du produit � r�cup�rer
     * @return           : le produit r�cup�r�
     */
    ProduitDo findProduitEnVente(final Integer idProduit);
}
