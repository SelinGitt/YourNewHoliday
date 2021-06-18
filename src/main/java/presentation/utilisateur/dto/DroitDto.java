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

    private static final long serialVersionUID = 525091163774644464L;

    private String            url;

    private List<PossedeDto>  possede;

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
     * Getter for possede
     *
     * @return the possede
     */
    public List<PossedeDto> getPossede() {
        return possede;
    }

    /**
     * Setter for possede
     *
     * @param possede the possede to set
     */
    public void setPossede(final List<PossedeDto> possede) {
        this.possede = possede;
    }

}
