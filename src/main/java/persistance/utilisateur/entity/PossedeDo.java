/**
 * 
 */
package persistance.utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe représentant PossedeDo
 *
 * @author Valentin
 */
@Entity
@Table(name = "possede")
public class PossedeDo {

    @Id
    @Column(name = "idPossede")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private RoleDo  role;

    @ManyToOne
    @JoinColumn(name = "idDroit")
    private DroitDo droit;

    /**
     * Constructor
     */
    public PossedeDo() {
        // empty
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Getter for role
     *
     * @return the role
     */
    public RoleDo getRole() {
        return role;
    }

    /**
     * Setter for role
     *
     * @param role the role to set
     */
    public void setRole(final RoleDo role) {
        this.role = role;
    }

    /**
     * Getter for droit
     *
     * @return the droit
     */
    public DroitDo getDroit() {
        return droit;
    }

    /**
     * Setter for droit
     *
     * @param droit the droit to set
     */
    public void setDroit(final DroitDo droit) {
        this.droit = droit;
    }
}
