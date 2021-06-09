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
     * Permet de rechercher produits par reference
     * 
     * @param  pSearchTerm terme recherché
     * @return             liste de produits associée à la recherche
     */
    List<ProduitDto> rechercherProduits(final String pSearchTerm);
}
