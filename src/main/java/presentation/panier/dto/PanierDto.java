/**
 * 
 */
package presentation.panier.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import presentation.produit.dto.ProduitDto;

/**
 * Classe représentant un panier pour la vue
 *
 * @author NathanB
 */
public class PanierDto implements Serializable {
    
    /**
     * serial
     */
    private static final long serialVersionUID = -1559416502575443553L;
    private Map<ProduitDto, Integer> mapPanier;
    private Integer                  nombreDeReferences = 0;

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
    public Map<ProduitDto, Integer> getMapPanier() {
        return mapPanier;
    }

    /**
     * Setter for mapPanier
     *
     * @param mapPanier the mapPanier to set
     */
    public void setMapPanier(final Map<ProduitDto, Integer> mapPanier) {
        this.mapPanier = mapPanier;
    }

    /**
     * Getter for serialversionuid
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Getter for nombreDeReferences
     *
     * @return the nombreDeReferences
     */
    public Integer getNombreDeReferences() {
        return nombreDeReferences;
    }

    /**
     * Setter for nombreDeReferences
     *
     * @param nombreDeReferences the nombreDeReferences to set
     */
    public void setNombreDeReferences(final Integer nombreDeReferences) {
        this.nombreDeReferences = nombreDeReferences;
    }

    
}
