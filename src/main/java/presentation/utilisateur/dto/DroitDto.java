/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;

/**
 * Classe pour Droit Dto
 *
 * @author Selin
 */
public class DroitDto implements Serializable {

    /**
     * Generated Serial UID
     */
    private static final long serialVersionUID = 5037471217411182997L;

    private int               idDroit;

    private String            url;

    /**
     * Getter for idDroit
     *
     * @return the idDroit
     */
    public int getIdDroit() {
        return idDroit;
    }

    /**
     * Setter for idDroit
     *
     * @param idDroit the idDroit to set
     */
    public void setIdDroit(final int idDroit) {
        this.idDroit = idDroit;
    }

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
}
