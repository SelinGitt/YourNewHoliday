/**
 * 
 */
package persistance.utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe représentant un Droit do
 *
 * @author Selin
 */
@Entity
@Table(name = "droit")
public class DroitDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDroit;

    @Column(nullable = false, length = 2048)
    private String  url;

    /**
     * Constructor
     */
    public DroitDo() {
        //   empty
    }

    /**
     * Getter for idDroit
     *
     * @return the idDroit
     */
    public Integer getIdDroit() {
        return idDroit;
    }

    /**
     * Setter for idDroit
     *
     * @param idDroit the idDroit to set
     */
    public void setIdDroit(final Integer idDroit) {
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
