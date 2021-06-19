/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.produit.dto.ProduitDto;

/**
 * Interface M�tier du produit
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
     * @param  idProduit : l'id du produit � trouver
     * @return           : le produit recherch�
     */
    ProduitDto trouverProduitEnVente(final Integer idProduit);

    /**
     * Permet de rechercher produits par reference
     * 
     * @param  pSearchTerm terme recherch�
     * @return             liste de produits associ�e � la recherche
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
     * @return liste tri�e
     */
    List<ProduitDto> listerCroissant();

    /**
     * Permet de lister par ordre d�croissant
     *
     * @return liste tri�e
     */
    List<ProduitDto> listerDecroissant();

    /**
     * Permet de filtrer la liste des produits recherch�s en fonction d'un terme de recherche. <br>
     * Permet aussi de les trier en fonction de leur type, ASC ou DESC
     *
     * @param  typeFiltre <code>ASC</code> ou <code>DESC</code> pour trier
     * @param  searchTerm le terme recherch�
     * @return            la liste tri�e et contenant les termes recherch�s
     */
    List<ProduitDto> listerFiltreTri(final String typeFiltre, final String searchTerm);
}
