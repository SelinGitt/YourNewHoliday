/**
 * 
 */
package presentation.produit.controller;

import java.util.stream.Stream;

/**
 * Enum repr�sentant des m�thodes de filtre.
 *
 * @author L�o
 */
public enum TypeFiltre {

    /**
     * En vente
     */
    EV(true, "1"),
    /**
     * Non en vente
     */
    NEV(false, "2");

    private Boolean typeDao;
    private String  typeFiltre;

    /**
     * Constructor
     *
     * @param typeFiltre le type de filtre, 0 en vente 1 non en vente
     * @param typeDao    le type � utiliser dans le DAO
     */
    TypeFiltre(final Boolean typeDao, final String typeFiltre) {
        this.typeDao = typeDao;
        this.typeFiltre = typeFiltre;
    }

    /**
     * Permet de retrouver un type en fonction d'un string
     *
     * @param  type le type � trouver
     * @return      le triFiltre trouv�, null si le type est inexsistant
     */
    public static TypeFiltre findValue(final String type) {
        return Stream.of(TypeFiltre.values()).filter(typeFiltre -> typeFiltre.typeFiltre.equals(type)).findFirst().orElse(null);
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
