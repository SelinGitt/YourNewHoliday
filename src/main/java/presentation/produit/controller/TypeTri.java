/**
 * 
 */
package presentation.produit.controller;

/**
 * Enum repr�sentant des m�thodes de tri.
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
     * Permet de tester et remplir le type d'enum � renvoyer
     *
     * @param  type le type � rechercher
     * @return      le typeRecherche correspondant � la base, null si pas trouv�
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
