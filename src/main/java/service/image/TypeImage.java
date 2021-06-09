/**
 * 
 */
package service.image;

/**
 * Classe représentant XX
 *
 * @author LucasNotAdmin
 */
public enum TypeImage {
    /**
     * Type Produit
     */
    PRODUIT("pdt"),
    /**
     * Type User
     */
    USER("usr");

    /**
     * type stocké
     */
    public final String type;

    TypeImage(final String type) {
        this.type = type;
    }

}
