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
<<<<<<< HEAD
     * Permet de maj un produit
     * 
     * @param  produitDto le produit � �diter
     * @return            le produit �dit�, null sinon
     */
    ProduitDto editerProduit(final ProduitDto produitDto);

    /**
     * Permet de trouver un produit via sa r�f�rence
     *
     * @param  reference du produit � cherhcer
     * @return           le produit trouv�, null sinon
     */
    ProduitDto trouverParReference(final String reference);
=======
     * Permet de rechercher produits par reference
     *
     * @param  pSearchTerm terme recherch�
     * @return             liste de produits associ�e � la recherche
     */
    List<ProduitDto> rechercherAllProduits(final String pSearchTerm);
>>>>>>> develop

    /**
     * Permet de cr�er un produit
     * 
     * @param  produitDto le produit � cr�er
     * @return            le produit cr��
     */
    ProduitDto creerProduit(final ProduitDto produitDto);
}
