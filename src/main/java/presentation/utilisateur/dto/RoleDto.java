package presentation.utilisateur.dto;

import java.io.Serializable;

/**
 * Classe RoleDto
 *
 * @author Valentin
 */
public class RoleDto implements Serializable {

    /**
     * Generated Serial UID
     */
    private static final long serialVersionUID = 6783656943891448750L;

    private int               idRole;

    private String            libelle;

    /**
     * Getter for idRole
     *
     * @return the idRole
     */
    public int getIdRole() {
        return idRole;
    }

    /**
     * Setter for idRole
     *
     * @param idRole the idRole to set
     */
    public void setIdRole(final int idRole) {
        this.idRole = idRole;
    }

    /**
     * Getter for libelle
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Setter for libelle
     *
     * @param libelle the libelle to set
     */
    public void setLibelle(final String libelle) {
        this.libelle = libelle;
    }

}
