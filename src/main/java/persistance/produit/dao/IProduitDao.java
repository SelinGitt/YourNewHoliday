/**
 * 
 */
package persistance.produit.dao;

import java.util.List;

import persistance.commun.dao.IGenericDao;
import persistance.produit.entity.ProduitDo;
import presentation.produit.controller.TypeTri;

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
     * Permet de trier la liste en fonction de son type de recherche
     *
     * @param  typeTri le type de tri
     * @return         une liste de produitDo triée
     */
    List<ProduitDo> trierListe(final TypeTri typeTri);

    /**
     * Permet de trier la liste et de la filtrer en fonction de leurs paramètres
     *
     * @param  typeTri    le type de recherche à effectuer
     * @param  searchTerm le terme à rechercher
     * @return            la liste triée et filtrée
     */
    List<ProduitDo> trierFiltreListe(final TypeTri typeTri, final String searchTerm);

}
