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
<<<<<<< HEAD
     * Permet de maj un produit
     * 
     * @param  produitDto le produit à éditer
     * @return            le produit édité, null sinon
     */
    ProduitDto editerProduit(final ProduitDto produitDto);

    /**
     * Permet de trouver un produit via sa référence
     *
     * @param  reference du produit à cherhcer
     * @return           le produit trouvé, null sinon
     */
    ProduitDto trouverParReference(final String reference);
=======
     * Permet de rechercher produits par reference
     *
     * @param  pSearchTerm terme recherché
     * @return             liste de produits associée à la recherche
     */
    List<ProduitDto> rechercherAllProduits(final String pSearchTerm);
>>>>>>> develop

    /**
     * Permet de créer un produit
     * 
     * @param  produitDto le produit à créer
     * @return            le produit créé
     */
    ProduitDto creerProduit(final ProduitDto produitDto);
}
