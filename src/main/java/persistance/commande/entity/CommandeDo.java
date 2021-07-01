package persistance.commande.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe représentant une Commande en BD
 */
@Entity
@Table(name = "commande")
public class CommandeDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    private Integer                id;

    @Column(name = "reference")
    private String                 reference;

    @Column(name = "prix_avec_remise")
    private BigDecimal             prixTotal;

    @Column(name = "date_commande")
    private Date                   date;

    @Column(name = "idUtilisateur")
    private Integer                idUtilisateur;

    @OneToMany(mappedBy = "commandeDo")
    private Set<CommandeProduitDo> commandeProduitDoSet;

    @Column(name = "quantiteTotale")
    private Integer                quantiteTotale;

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
     * Getter for reference
     *
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Setter for reference
     *
     * @param reference the reference to set
     */
    public void setReference(final String reference) {
        this.reference = reference;
    }

    /**
     * Getter for prixTotal
     *
     * @return the prixTotal
     */
    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    /**
     * Setter for prixTotal
     *
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(final BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     * Getter for date
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for date
     *
     * @param date the date to set
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * Getter for idUtilisateur
     *
     * @return the idUtilisateur
     */
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * Setter for idUtilisateur
     *
     * @param idUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(final Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * Getter for commandeProduitDoSet
     *
     * @return the commandeProduitDoSet
     */
    public Set<CommandeProduitDo> getCommandeProduitDoSet() {
        return commandeProduitDoSet;
    }

    /**
     * Setter for commandeProduitDoSet
     *
     * @param commandeProduitDoSet the commandeProduitDoSet to set
     */
    public void setCommandeProduitDoSet(final Set<CommandeProduitDo> commandeProduitDoSet) {
        this.commandeProduitDoSet = commandeProduitDoSet;
    }

    /**
     * Getter for quantiteTotale
     * 
     * @return the quantiteTotale
     */
    public Integer getQuantiteTotale() {
        return quantiteTotale;
    }

    /**
     * Setter for quantiteTotale
     * 
     * @param quantiteTotale the quantiteTotale to set
     */
    public void setQuantiteTotale(final Integer quantiteTotale) {
        this.quantiteTotale = quantiteTotale;
    }

}
