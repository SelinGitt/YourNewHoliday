/**
 * 
 */
package persistance.utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe représentant PossedeDo
 *
 * @author Chamalo
 */
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
}
