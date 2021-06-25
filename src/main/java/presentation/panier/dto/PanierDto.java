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
     * Serial Version UID généré automatiquement
     */
    private static final long                     serialVersionUID   = 6448345912435295054L;

    private Map<ProduitDto, LigneCommandeProduit> mapPanier;
    private Integer                               nombreDeReferences = 0;

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
    public Map<ProduitDto, LigneCommandeProduit> getMapPanier() {
        return mapPanier;
    }

    /**
     * Setter for mapPanier
     *
     * @param mapPanier the mapPanier to set
     */
    public void setMapPanier(final Map<ProduitDto, LigneCommandeProduit> mapPanier) {
        this.mapPanier = mapPanier;
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
