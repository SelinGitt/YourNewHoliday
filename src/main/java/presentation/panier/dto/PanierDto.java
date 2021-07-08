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
    private String                                   prixTotalAffichage;
    private String                                   remiseAffichage;
    private String                                   prixApresRemiseAffichage;

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
     * Getter for prixTotalAffichage
     *
     * @return the prixTotalAffichage
     */
    public String getPrixTotalAffichage() {
        return prixTotalAffichage;
    }

    /**
     * Setter for prixTotalAffichage
     *
     * @param prixTotalAffichage the prixTotalAffichage to set
     */
    public void setPrixTotalAffichage(final String prixTotalAffichage) {
        this.prixTotalAffichage = prixTotalAffichage;
    }

    /**
     * Getter for remiseAffichage
     *
     * @return the remiseAffichage
     */
    public String getRemiseAffichage() {
        return remiseAffichage;
    }

    /**
     * Setter for remiseAffichage
     *
     * @param remiseAffichage the remiseAffichage to set
     */
    public void setRemiseAffichage(final String remiseAffichage) {
        this.remiseAffichage = remiseAffichage;
    }

    /**
     * Getter for prixApresRemiseAffichage
     *
     * @return the prixApresRemiseAffichage
     */
    public String getPrixApresRemiseAffichage() {
        return prixApresRemiseAffichage;
    }

    /**
     * Setter for prixApresRemiseAffichage
     *
     * @param prixApresRemiseAffichage the prixApresRemiseAffichage to set
     */
    public void setPrixApresRemiseAffichage(final String prixApresRemiseAffichage) {
        this.prixApresRemiseAffichage = prixApresRemiseAffichage;
    }

}
