/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.produit.controller.TypeTriAlphanumerique;
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
     * Permet de rechercher produits en vente par reference
     * 
     * @param  pSearchTerm terme recherché
     * @return             liste de produits en vente associée à la recherche
     */
    List<ProduitDto> rechercherProduitsEnVente(final String pSearchTerm);

    /**
     * Permet de lister tous les produits
     *
     * @return la liste de tous les produits
     */
    List<ProduitDto> listerAllProduit();

    /**
     * Permet de faire une recherche en fonction de leur paramètres
     *
     * @param  searchTerm la recherche a effectuer
     * @param  tri        le type de tri à effectuer
     * @return            la liste de produitDto fitrée
     */
    List<ProduitDto> findFilter(final String searchTerm, final TypeTriAlphanumerique tri);

    /**
     * Permet de rechercher produits par reference
     *
     * @param  pSearchTerm terme recherché
     * @return             liste de produits associée à la recherche
     */
    List<ProduitDto> rechercherAllProduits(final String pSearchTerm);

    /**
     * Permet de créer un produit
     * 
     * @param  produitDto le produit à créer
     * @return            le produit créé
     */
    ProduitDto creerProduit(final ProduitDto produitDto);
}
