/**
 * 
 */
package presentation.panier.dto;

import java.util.HashMap;
import java.util.Map;

import presentation.produit.dto.ProduitDto;

/**
 * Classe représentant un panier pour la vue
 *
 * @author NathanB
 */
public class PanierDto {

    private Map<ProduitDto, String> mapPanier;
    private String                  nombreProduitDifferent;

    /**
     * Constructor
     */
    public PanierDto() {
        mapPanier = new HashMap<>();
    }

    /**
     * Getter for mapPanier
     *
     * @return the mapPanier
     */
    public Map<ProduitDto, String> getMapPanier() {
        return mapPanier;
    }

    /**
     * Setter for mapPanier
     *
     * @param mapPanier the mapPanier to set
     */
    public void setMapPanier(final Map<ProduitDto, String> mapPanier) {
        this.mapPanier = mapPanier;
    }

    /**
     * Getter for nombreProduitTotal
     *
     * @return the nombreProduitTotal
     */
    public String getNombreProduitTotal() {
        return nombreProduitDifferent;
    }

    /**
     * Setter for nombreProduitTotal
     *
     * @param nombreProduitTotal the nombreProduitTotal to set
     */
    public void setNombreProduitTotal(final String nombreProduitTotal) {
        this.nombreProduitDifferent = nombreProduitTotal;
    }
}
