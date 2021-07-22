/**
 * 
 */
package persistance.produit.dao;

import java.util.List;

import persistance.commun.dao.IGenericDao;
import persistance.produit.entity.ProduitDo;
import presentation.produit.controller.TypeTriAlphanumerique;

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
     * Permet de trier la liste en fonction de son type de recherche
     *
     * @param  typeTri le type de tri
     * @return         une liste de produitDo triée
     */
    List<ProduitDo> trierListe(final TypeTriAlphanumerique typeTri);

    /**
     * Permet de trier la liste et de la filtrer en fonction de leurs paramètres
     *
     * @param  typeTri    le type de recherche à effectuer
     * @param  searchTerm le terme à rechercher
     * @return            la liste triée et filtrée
     */
    List<ProduitDo> trierFiltreListe(final TypeTriAlphanumerique typeTri, final String searchTerm);

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

    /**
     * Permet de lister les produits non vente
     *
     * @return liste de produits non en vente
     */
    List<ProduitDo> findAllProduitsNonEnVente();
}
