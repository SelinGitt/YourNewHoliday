/**
 * 
 */
package service.image;

import java.util.stream.Stream;

/**
 * Enum des types utilisés pour récupérer les types d'images
 *
 * @author Lucas
 */
public enum TypeImage {
    /**
     * Type Produit
     */
    PRODUIT("pdt", 1920, 1080, 5_242_880, "imagesProduitsRepo"),

    /**
     * Type Utilisateur
     */
    UTILISATEUR("usr", 200, 200, 512_000, "imagesUtilisateursRepo");

    /**
     * type stocké
     */
    private final String type;

    private final int    width;
    private final int    height;
    private final int    size;

    private final String imageRepo;

    TypeImage(final String type, final int width, final int height, final int size, final String imageRepo) {
        this.type = type;
        this.width = width;
        this.size = size;
        this.height = height;
        this.imageRepo = imageRepo;
    }

    /**
     * Permet de retourner le TypeImage correspondant à la chaîne de caractère entré en paramètre
     *
     * @param  types la chaîne de caratère dont on cherche le type image
     * @return       TypeImage le type de l'image
     */
    public static TypeImage getTypeImage(final String types) {
        return Stream.of(TypeImage.values()).filter(typeImgage -> typeImgage.getType().equals(types)).findFirst().orElse(null);
    }

    /**
     * Getter for type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for width
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for height
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for size
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter for imageRepo
     *
     * @return the imageRepo
     */
    public String getImageRepo() {
        return imageRepo;
    }

}
