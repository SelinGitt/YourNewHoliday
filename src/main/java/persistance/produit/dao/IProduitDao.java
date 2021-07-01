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
     * @return           : le produit r�cup�r�, s'il n'est pas en base ou en vente, retourne null
     */
    ProduitDo findProduitEnVente(final Integer idProduit);

    /**
     * Permet de r�cup�rer la liste des produits recherch�s
     * 
     * @param  searchTerm terme recherch�
     * @return            liste des produits trouv�s
     */
    List<ProduitDo> rechercherProduits(final String searchTerm);

    /**
     * Permet de r�cup�rer la liste des produits recherch�s
     *
     * @param  searchTerm terme recherch�
     * @return            liste des produits trouv�s
     */
    List<ProduitDo> rechercherAllProduits(String searchTerm);
}
