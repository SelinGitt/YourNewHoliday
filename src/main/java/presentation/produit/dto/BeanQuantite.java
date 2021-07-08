/**
 * 
 */
package presentation.produit.dto;

/**
 * Classe représentant un bean de quantité pour ajouter des produits au panier
 *
 * @author Lucas
 */
public class BeanQuantite {
    private String quantite;
    private String id;

    /**
     * Getter for quantite
     *
     * @return the quantite
     */
    public String getQuantite() {
        return quantite;
    }

    /**
     * Setter for quantite
     *
     * @param quantite the quantite to set
     */
    public void setQuantite(final String quantite) {
        this.quantite = quantite;
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

}
