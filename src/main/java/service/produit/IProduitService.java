/**
 * 
 */
package service.produit;

import java.util.List;

import presentation.panier.dto.PanierDto;
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.BeanQuantite;
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
     * @return            le produit cr��, null sinon
     */
    ProduitDto creerProduit(final ProduitDto produitDto);

    /**
     * Permet de trouver un produit via son ID
     *
     * @param  idProduit l'id du produit � rechercher
     * @return           le produit trouv�, null sinon
     */
    ProduitDto trouverProduitById(final Integer idProduit);

    /**
     * Permet d'ajouter un produit au panier, en testant les r�gles de gestions
     *
     * @param  panierDto    le panier o� il faut ajouter les produits
     * @param  beanQuantite le bean contenant la quantit� et l'id du produit � ajouter
     * @return              <code>true</code> si le bean est correct, de par sa quantit� ou son ID<br>
     *                      <code>false</code> dans le cas contraire
     */
    PanierDto updatePanier(final PanierDto panierDto, final BeanQuantite beanQuantite);

    /**
     * Permet de filtrer la liste des produits en fonction du statut de vente
     * 
     * @param  tri string tri
     * @return     liste filtr�e
     */
    List<ProduitDto> filtrerEnVente(final String tri);
}
