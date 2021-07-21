/**
 * 
 */
package service.image;

/**
 * Enum des types utilis�s pour r�cup�rer les types d'images
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
     * type stock�
     */
    public final String type;

    TypeImage(final String type) {
        this.type = type;
    }

}
