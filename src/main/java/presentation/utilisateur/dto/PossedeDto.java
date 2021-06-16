/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;

/**
 * Classe représentant PossedeDto
 *
 * @author Valentin
 */
public class PossedeDto implements Serializable {

    /**
     * Generated Serial UID
     */
    private static final long serialVersionUID = -9037293999653181737L;

    private int               idPossede;

    private RoleDto           roleDto;

    /**
     * Getter for idPossede
     *
     * @return the idPossede
     */
    public int getIdPossede() {
        return idPossede;
    }

    /**
     * Setter for idPossede
     *
     * @param idPossede the idPossede to set
     */
    public void setIdPossede(final int idPossede) {
        this.idPossede = idPossede;
    }

    /**
     * Getter for roleDto
     *
     * @return the roleDto
     */
    public RoleDto getRoleDto() {
        return roleDto;
    }

    /**
     * Setter for roleDto
     *
     * @param roleDto the roleDto to set
     */
    public void setRoleDto(final RoleDto roleDto) {
        this.roleDto = roleDto;
    }

}
