/**
 * 
 */
package persistance.utilisateur.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Integer         idDroit;

    @Column(nullable = false, length = 2048)
    private String          url;

    // Ajouter une onetomany vers possede
    @OneToMany(mappedBy = "droit", fetch = FetchType.EAGER)
    private List<PossedeDo> possede;

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

    /**
     * Getter for possede
     *
     * @return the possede
     */
    public List<PossedeDo> getPossede() {
        return possede;
    }

    /**
     * Setter for possede
     *
     * @param possede the possede to set
     */
    public void setPossede(final List<PossedeDo> possede) {
        this.possede = possede;
    }

}
