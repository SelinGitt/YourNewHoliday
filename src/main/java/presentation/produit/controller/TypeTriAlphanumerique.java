/**
 * 
 */
package presentation.produit.controller;

import java.util.stream.Stream;

/**
 * Enum représentant des méthodes de tri.
 *
 * @author Lucas
 */
public enum TypeTriAlphanumerique {
    /**
     * Recherche ascendante
     */
    ASC("1", "ASC"),
    /**
     * Recherce descendante
     */
    DESC("2", "DESC");

    private String typeDao;
    private String typeRecherche;

    /**
     * Constructor
     */
    TypeTriAlphanumerique(final String type, final String typeDao) {
        this.typeRecherche = type;
        this.typeDao = typeDao;
    }

    /**
     * Permet de retrouver un type en fonction d'un string clé
     *
     * @param  type le type à trouver
     * @return      le typeTriAlphanumerique trouvé, null si type n'existe pas
     */
    public static TypeTriAlphanumerique checkType(final String type) {
        return Stream.of(TypeTriAlphanumerique.values()).filter(typeTriAlphanumerique -> typeTriAlphanumerique.typeRecherche.equals(type))
                .findFirst().orElse(null);
    }

    /**
     * Getter for typeDao
     *
     * @return the typeDao
     */
    public String getTypeDao() {
        return typeDao;
    }

}
