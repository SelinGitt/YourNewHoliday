/**
 * 
 */
package persistance.utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe représentant un Rôle Do
 *
 * @author Selin
 */
@Entity
@Table(name = "role")
public class RoleDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer       idRole;

    @Column(nullable = false, length = 50, unique = true)
    private String        libelle;

    @OneToMany(mappedBy = "role")
    private UtilisateurDo utilisateurDo;

    /**
     * Constructor
     */
    public RoleDo() {
        super();
    }

    /**
     * Getter for idRole
     *
     * @return the idRole
     */
    public Integer getIdRole() {
        return idRole;
    }

    /**
     * Setter for idRole
     *
     * @param idRole the idRole to set
     */
    public void setIdRole(final Integer idRole) {
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

    /**
     * Getter for utilisateurDo
     *
     * @return the utilisateurDo
     */
    public UtilisateurDo getUtilisateurDo() {
        return utilisateurDo;
    }

    /**
     * Setter for utilisateurDo
     *
     * @param utilisateurDo the utilisateurDo to set
     */
    public void setUtilisateurDo(final UtilisateurDo utilisateurDo) {
        this.utilisateurDo = utilisateurDo;
    }

}
