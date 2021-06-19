/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.produit.dto.ProduitDto;

/**
 * Interface Métier du produit
 *
 * @author Administrateur
 */
public interface IProduitService {

    /**
     * Permet de lister les produits en vente
     *
     * @return la liste des produits en vente
     */
    List<ProduitDto> listerProduitsEnVente();

    /**
     * Permet de trouver un produit en vente
     *
     * @param  idProduit : l'id du produit à trouver
     * @return           : le produit recherché
     */
    ProduitDto trouverProduitEnVente(final Integer idProduit);

    /**
     * Permet de rechercher produits par reference
     * 
     * @param  pSearchTerm terme recherché
     * @return             liste de produits associée à la recherche
     */
    List<ProduitDto> rechercherProduits(final String pSearchTerm);

    /**
     * Permet de lister tous les produits
     *
     * @return la liste de tous les produits
     */
    List<ProduitDto> listerAllProduit();

    /**
     * Permet de lister par ordre croissant
     *
     * @return liste triée
     */
    List<ProduitDto> listerCroissant();

    /**
     * Permet de lister par ordre décroissant
     *
     * @return liste triée
     */
    List<ProduitDto> listerDecroissant();

    /**
     * Permet de filtrer la liste des produits recherchés en fonction d'un terme de recherche. <br>
     * Permet aussi de les trier en fonction de leur type, ASC ou DESC
     *
     * @param  typeFiltre <code>ASC</code> ou <code>DESC</code> pour trier
     * @param  searchTerm le terme recherché
     * @return            la liste triée et contenant les termes recherchés
     */
    List<ProduitDto> listerFiltreTri(final String typeFiltre, final String searchTerm);
}
