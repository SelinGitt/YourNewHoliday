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
public class LigneCommandeProduit implements Serializable {

    /**
     * Serial Version UID généré automatiquement
     */
    private static final long serialVersionUID = -2920201985021528588L;

    private Integer           quantite;
    private String            quantiteAffichage;
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

    /**
     * Getter for quantiteAffichage
     *
     * @return the quantiteAffichage
     */
    public String getQuantiteAffichage() {
        return quantiteAffichage;
    }

    /**
     * Setter for quantiteAffichage
     *
     * @param quantiteAffichage the quantiteAffichage to set
     */
    public void setQuantiteAffichage(final String quantiteAffichage) {
        this.quantiteAffichage = quantiteAffichage;
    }

}
