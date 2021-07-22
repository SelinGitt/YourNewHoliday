/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.panier.dto.PanierDto;
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.BeanQuantite;
import presentation.produit.dto.ProduitDto;
import service.utilisateur.util.UtilisateurRoleEnum;

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
     * @return            le produit créé, null sinon
     */
    ProduitDto creerProduit(final ProduitDto produitDto);

    /**
     * Permet de trouver un produit via son ID
     *
     * @param  idProduit l'id du produit à rechercher
     * @return           le produit trouvé, null sinon
     */
    ProduitDto trouverProduitById(final Integer idProduit);

    /**
     * Permet d'ajouter un produit au panier, en testant les règles de gestions
     *
     * @param  panierDto    le panier où il faut ajouter les produits
     * @param  beanQuantite le bean contenant la quantité et l'id du produit à ajouter
     * @return              <code>true</code> si le bean est correct, de par sa quantité ou son ID<br>
     *                      <code>false</code> dans le cas contraire
     */
    PanierDto updatePanier(final PanierDto panierDto, final BeanQuantite beanQuantite);

    /**
     * Permet de lister les produits non en vente
     *
     * @return liste des produits non en vente
     */
    List<ProduitDto> listerProduitsNonEnVente();

    /**
     * Permet de filtrer la liste des produits en fonction du statut de vente
     * 
     * @param  searchTerm terme recherché
     * @param  tri        tri effectué
     * @return            liste filtrée
     */
    List<ProduitDto> filtrerEnVente(final String searchTerm, final String tri);

    /**
     * Permet de choisir la méthode utlisée pour la consultation d'un produit selon le role
     * 
     * @param  role      role de l'utilisateur
     * @param  idProduit id du produit à consulter
     * @return           produit à consulter
     */
    ProduitDto consulterProduitWithRole(final UtilisateurRoleEnum role, final Integer idProduit);
}
