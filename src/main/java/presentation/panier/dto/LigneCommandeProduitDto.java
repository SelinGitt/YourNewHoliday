/**
 * 
 */
package presentation.panier.dto;

import java.io.Serializable;

/**
 * Class represents ProduitLigneCommande
 *
 * @author Steve
 */
public class LigneCommandeProduitDto implements Serializable {
    /**
     * Serial Version UID g�n�r� automatiquement
     */
    private static final long serialVersionUID = 6376789768578611308L;

    private Integer           quantite;
    private String            prix;

    /**
     * Getter for quantite
     *
     * @return the quantite
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     * Getter for prix
     *
     * @return the prix
     */
    public String getPrix() {
        return prix;
    }

    /**
     * Setter for quantite
     *
     * @param quantite the quantite to set
     */
    public void setQuantite(final Integer quantite) {
        this.quantite = quantite;
    }

    /**
     * Setter for prix
     *
     * @param prix the prix to set
     */
    public void setPrix(final String prix) {
        this.prix = prix;
    }
}
