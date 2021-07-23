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
    private final String type;

    TypeImage(final String type) {
        this.type = type;
    }

    /**
     * Getter for type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

}
