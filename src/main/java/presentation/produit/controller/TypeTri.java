/**
 * 
 */
package presentation.produit.controller;

/**
 * Enum représentant des méthodes de tri.
 *
 * @author Lucas
 */
public enum TypeTri {
    /**
     * Recherche ascendante
     */
    ASC(),
    /**
     * Recherce descendante
     */
    DESC();

    private static String typeDao;

    /**
     * Getter for typeDao
     *
     * @return the typeDao
     */
    public String getTypeDao() {
        return typeDao;
    }

    /**
     * Permet de tester et remplir le type d'enum à renvoyer
     *
     * @param  type le type à rechercher
     * @return      le typeRecherche correspondant à la base, null si pas trouvé
     */
    public static TypeTri checkType(final String type) {
        if ("1".equals(type)) {
            typeDao = "ASC";
            return TypeTri.ASC;
        }
        if ("2".equals(type)) {
            typeDao = "DESC";
            return TypeTri.DESC;
        }
        return checkType("1");
    }
}
