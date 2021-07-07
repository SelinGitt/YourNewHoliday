/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.produit.controller.TypeTriAlphanumerique;
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
     * Permet de rechercher produits en vente par reference
     * 
     * @param  pSearchTerm terme recherch�
     * @return             liste de produits en vente associ�e � la recherche
     */
    List<ProduitDto> rechercherProduitsEnVente(final String pSearchTerm);

    /**
     * Permet de lister tous les produits
     *
     * @return la liste de tous les produits
     */
    List<ProduitDto> listerAllProduit();

    /**
     * Permet de faire une recherche en fonction de leur param�tres
     *
     * @param  searchTerm la recherche a effectuer
     * @param  tri        le type de tri � effectuer
     * @return            la liste de produitDto fitr�e
     */
    List<ProduitDto> findFilter(final String searchTerm, final TypeTriAlphanumerique tri);

    /**
     * Permet de rechercher produits par reference
     *
     * @param  pSearchTerm terme recherch�
     * @return             liste de produits associ�e � la recherche
     */
    List<ProduitDto> rechercherAllProduits(final String pSearchTerm);

    /**
     * Permet de cr�er un produit
     * 
     * @param  produitDto le produit � cr�er
     * @return            le produit cr��
     */
    ProduitDto creerProduit(final ProduitDto produitDto);
}
