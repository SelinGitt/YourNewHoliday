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
    private static final long serialVersionUID = -6957282466346848192L;

    private RoleDto           roleDto;

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
