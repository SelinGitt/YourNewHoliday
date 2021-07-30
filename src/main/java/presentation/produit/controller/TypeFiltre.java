/**
 * 
 */
package presentation.produit.controller;

import java.util.stream.Stream;

/**
 * Enum repr�sentant les options du filtre.
 *
 * @author L�o
 */
public enum TypeFiltre {

    /**
     * En vente
     */
    EnVente(true, "1"),
    /**
     * Non en vente
     */
    NonEnVente(false, "2");

    private Boolean typeDao;
    private String  type;

    /**
     * Constructor
     *
     * @param type    le type de filtre, 0 en vente 1 non en vente
     * @param typeDao le type � utiliser dans le DAO
     */
    TypeFiltre(final Boolean typeDao, final String type) {
        this.typeDao = typeDao;
        this.type = type;
    }

    /**
     * Permet de retrouver un type en fonction d'un string
     *
     * @param  type le type � trouver
     * @return      le typeFiltre trouv�, null si le type est inexsistant
     */
    public static TypeFiltre findValue(final String type) {
        return Stream.of(TypeFiltre.values()).filter(typeFiltre -> typeFiltre.type.equals(type)).findFirst().orElse(null);
    }

    /**
     * Getter for typeDao
     *
     * @return the typeDao
     */
    public Boolean getTypeDao() {
        return typeDao;
    }
}
