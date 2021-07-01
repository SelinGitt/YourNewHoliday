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
     * Permet de récupérer la liste des produits en vente
     *
     * @return la liste des produits en vente
     */
    List<ProduitDo> findAllProduitsEnVente();

    /**
     * Permet de récupérer un produit en vente
     *
     * @param  idProduit : l'id du produit à récupérer
     * @return           : le produit récupéré, s'il n'est pas en base ou en vente, retourne null
     */
    ProduitDo findProduitEnVente(final Integer idProduit);

    /**
     * Permet de récupérer la liste des produits recherchés
     * 
     * @param  searchTerm terme recherché
     * @return            liste des produits trouvés
     */
    List<ProduitDo> rechercherProduits(final String searchTerm);

    /**
     * Permet de récupérer la liste des produits recherchés
     *
     * @param  searchTerm terme recherché
     * @return            liste des produits trouvés
     */
    List<ProduitDo> rechercherAllProduits(String searchTerm);
}
