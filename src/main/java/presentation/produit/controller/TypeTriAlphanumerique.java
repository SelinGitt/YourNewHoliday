/**
 * 
 */
package presentation.produit.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum repr�sentant des m�thodes de tri.
 *
 * @author Lucas
 */
public enum TypeTriAlphanumerique {
    /**
     * Recherche ascendante
     */
    ASC("1"),
    /**
     * Recherce descendante
     */
    DESC("2");

    //utilis� pour rechercher un tri depuis son type
    private static final Map<String, TypeTriAlphanumerique> lookup = new HashMap<>();
    static {
        for (final TypeTriAlphanumerique tta : TypeTriAlphanumerique.values()) {
            lookup.put(tta.getTypeRecherche(), tta);
        }
    }
    private String typeDao;
    private String typeRecherche;

    /**
     * Constructor
     */
    TypeTriAlphanumerique(final String type) {
        typeRecherche = type;
    }

    /**
     * Permet de tester et remplir le type d'enum � renvoyer
     *
     * @return le typeRecherche correspondant � la base, ASC par d�faut si pas trouv�
     */
    public TypeTriAlphanumerique checkType() {
        if ("2".equals(typeRecherche)) {
            typeDao = "DESC";
            return DESC;
        }
        typeDao = "ASC";
        return ASC;
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
     * Getter for typeRecherche
     *
     * @return the typeRecherche
     */
    public String getTypeRecherche() {
        return typeRecherche;
    }

    /**
     * Permet de retrouver un type en fonction d'un string cl�
     *
     * @param  type le type � trouver
     * @return      le typeTriAlphanumerique
     */
    public static TypeTriAlphanumerique getValue(final String type) {
        return lookup.get(type);
    }

}
