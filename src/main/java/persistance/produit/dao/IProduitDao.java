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
     * Permet de récupérer un produit en vente avec la version à jour
     *
     * @param  idProduit : l'id du produit à récupérer
     * @param  version   : le numéro de version du produit
     * @return           : le produit récupéré, s'il n'est pas en base ou en vente ou à jour, retourne null
     */
    ProduitDo findProduitEnVenteAvecVersion(final Integer idProduit, final Integer version);

    /**
     * Permet de récupérer la liste des produits recherchés en vente
     * 
     * @param  searchTerm terme recherché
     * @return            liste des produits trouvés en vente
     */
    List<ProduitDo> rechercherProduitsEnVente(final String searchTerm);

    /**
     * Permet de trouver un produit via sa référence
     *
     * @param  reference la référence du produit à trouver
     * @return           le produit trouvé, null sinon
     */
    ProduitDo findByReference(final String reference);

    /**
     * Permet de récupérer la liste des produits recherchés en vente ou non
     *
     * @param  searchTerm terme recherché
     * @return            liste de tous les produits trouvés en vente ou non
     */
    List<ProduitDo> rechercherAllProduits(final String searchTerm);
}
