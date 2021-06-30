/**
 * 
 */
package presentation.produit.controller;

/**
 * Enum repr�sentant des m�thodes de tri.
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
     * Getter for typeDao
     *
     * @return the typeDao
     */
    public String getTypeDao() {
        return typeDao;
    }

    /**
     * Permet de retrouver un type en fonction d'un string cl�
     *
     * @param  type le type � trouver
     * @return      le typeTriAlphanumerique
     */
    public static TypeTriAlphanumerique checkType(final String type) {
        for (final TypeTriAlphanumerique tta : TypeTriAlphanumerique.values()) {
            if (tta.typeRecherche.equals(type)) {
                return tta;
            }
        }
        return ASC;
    }

}
