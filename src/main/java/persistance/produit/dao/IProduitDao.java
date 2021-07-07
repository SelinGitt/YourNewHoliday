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
     * Permet de trier la liste en fonction de son type de recherche
     *
     * @param  typeTri le type de tri
     * @return         une liste de produitDo tri�e
     */
    List<ProduitDo> trierListe(final TypeTriAlphanumerique typeTri);

    /**
     * Permet de trier la liste et de la filtrer en fonction de leurs param�tres
     *
     * @param  typeTri    le type de recherche � effectuer
     * @param  searchTerm le terme � rechercher
     * @return            la liste tri�e et filtr�e
     */
    List<ProduitDo> trierFiltreListe(final TypeTriAlphanumerique typeTri, final String searchTerm);

    /**
     * Permet de r�cup�rer la liste des produits recherch�s en vente
     * 
     * @param  searchTerm terme recherch�
     * @return            liste des produits trouv�s en vente
     */
    List<ProduitDo> rechercherProduitsEnVente(final String searchTerm);

    /**
     * Permet de r�cup�rer la liste des produits recherch�s en vente ou non
     *
     * @param  searchTerm terme recherch�
     * @return            liste de tous les produits trouv�s en vente ou non
     */
    List<ProduitDo> rechercherAllProduits(final String searchTerm);
}
