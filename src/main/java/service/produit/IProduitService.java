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
     * Permet de lister les produits
     *
     * @return une liste de produits
     */
    List<ProduitDto> listerProduits();
}
