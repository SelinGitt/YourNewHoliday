/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Classe pour Droit Dto
 *
 * @author Selin
 */
public class DroitDto implements Serializable {

    /**
     * Generated Serial UID
     */
    private static final long serialVersionUID = 2929848773606000408L;

    private String            url;

    private List<RoleDto>     role;

    /**
     * Getter for url
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for url
     *
     * @param url the url to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Getter for role
     *
     * @return the role
     */
    public List<RoleDto> getRole() {
        return role;
    }

    /**
     * Setter for role
     *
     * @param role the role to set
     */
    public void setRole(final List<RoleDto> role) {
        this.role = role;
    }

}
