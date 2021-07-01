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
    private static final long                        serialVersionUID   = 6448345912435295054L;

    private Map<ProduitDto, LigneCommandeProduitDto> mapPanier;
    private Integer                                  nombreDeReferences = 0;
    private String                                   prixTotal          = "0";
    private String                                   prixApresRemise    = "0";

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
    public Map<ProduitDto, LigneCommandeProduitDto> getMapPanier() {
        return mapPanier;
    }

    /**
     * Setter for mapPanier
     *
     * @param mapPanier the mapPanier to set
     */
    public void setMapPanier(final Map<ProduitDto, LigneCommandeProduitDto> mapPanier) {
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

    /**
     * Getter for prixTotal
     *
     * @return the prixTotal
     */
    public String getPrixTotal() {
        return prixTotal;
    }

    /**
     * Setter for prixTotal
     *
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(final String prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     * Getter for prixApresRemise
     *
     * @return the prixApresRemise
     */
    public String getPrixApresRemise() {
        return prixApresRemise;
    }

    /**
     * Setter for prixApresRemise
     *
     * @param prixApresRemise the prixApresRemise to set
     */
    public void setPrixApresRemise(final String prixApresRemise) {
        this.prixApresRemise = prixApresRemise;
    }

}
