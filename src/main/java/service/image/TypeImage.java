/**
 * 
 */
package service.image;

/**
 * Enum des types utilisés pour récupérer les types d'images
 *
 * @author Lucas
 */
public enum TypeImage {
    /**
     * Type Produit
     */
    PRODUIT("pdt"),

    /**
     * Type Utilisateur
     */
    UTILISATEUR("usr");

    /**
     * type stocké
     */
    public final String type;

    TypeImage(final String type) {
        this.type = type;
    }

}
