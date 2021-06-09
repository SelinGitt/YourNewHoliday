/**
 * 
 */
package service.image;

/**
 * Classe repr�sentant XX
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
     * type stock�
     */
    public final String type;

    TypeImage(final String type) {
        this.type = type;
    }

}
