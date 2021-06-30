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
     * Permet de r�cup�rer la liste des produits recherch�s
     * 
     * @param  searchTerm terme recherch�
     * @return            liste des produits trouv�s
     */
    List<ProduitDo> rechercherProduits(final String searchTerm);

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

}
