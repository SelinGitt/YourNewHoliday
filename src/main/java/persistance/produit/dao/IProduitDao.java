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
     * Permet de r�cup�rer la liste des produits recherch�s en vente
     * 
     * @param  searchTerm terme recherch�
     * @return            liste des produits trouv�s en vente
     */
    List<ProduitDo> rechercherProduitsEnVente(final String searchTerm);

    /**
     * Permet de supprimer un produit via son id
     *
     * @param  id du produit � supprimer
     * @return    true si supp, sinon false
     */
    boolean deleteProduitById(final Integer id);

    /**
     * Permet de r�cup�rer la liste des produits recherch�s en vente ou non
     *
     * @param  searchTerm terme recherch�
     * @return            liste de tous les produits trouv�s en vente ou non
     */
    List<ProduitDo> rechercherAllProduits(final String searchTerm);
}
