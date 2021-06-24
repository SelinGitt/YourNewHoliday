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
     * Permet de lister les produits par ordre croissant
     *
     * @return liste tri�e
     */
    List<ProduitDo> listerCroissant();

    /**
     * Permet de lister les produits par ordre d�croissant
     *
     * @return liste tri�e
     */
    List<ProduitDo> listerDecroissant();

    /**
     * Permet de filtrer la liste des produits recherch�s en fonction d'un terme de recherche et le tri selon le prix
     * unitaire par ordre croissant.
     *
     * @param  searchTerm le terme recherch�
     * @return            la liste tri�e et contenant les termes recherch�s
     */
    List<ProduitDo> listerFiltreTriCroissant(final String searchTerm);

    /**
     * Permet de filtrer la liste des produits recherch�s en fonction d'un terme de recherche et le tri selon le prix
     * unitaire par ordre d�croissant.
     *
     * @param  searchTerm le terme recherch�
     * @return            la liste tri�e et contenant les termes recherch�s
     */
    List<ProduitDo> listerFiltreTriDecroissant(final String searchTerm);

    /**
     * Permet de trier la liste en fonction de son type de recherche
     *
     * @param  typeTri le type de tri
     * @return         une liste de produitDo tri�e
     */
    List<ProduitDo> trierListe(final TypeTri typeTri);

    /**
     * Permet de trier la liste et de la filtrer en fonction de leurs param�tres
     *
     * @param  typeTri    le type de recherche � effectuer
     * @param  searchTerm le terme � rechercher
     * @return
     */
    List<ProduitDo> trierFiltreListe(final TypeTri typeTri, final String searchTerm);

}
