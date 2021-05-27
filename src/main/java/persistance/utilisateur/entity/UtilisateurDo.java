package persistance.utilisateur.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe UserDo <br>
 * Incomplete pour le moment, il n'y a que le nécessaire pour démarrer
 *
 * @author Valentin
 */
@Entity
@Table(name = "utilisateur")
public class UtilisateurDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int     id;

    @Column(nullable = false, length = 15, unique = true)
    private String  reference;

    @Column(nullable = false, length = 320, unique = true)
    private String  email;

    @Column(nullable = false, length = 50)
    private String  nom;

    @Column(nullable = false, length = 50)
    private String  prenom;

    @Column(name = "password")
    private String  mdpHash;

    @Column(name = "date_d_inscription")
    private Date    dateInscription;

    @Column(name = "est_desactive")
    private boolean estActif;

    /**
     * Constructor
     */
    public UtilisateurDo() {
        super();
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id the id to set
     */
    public void setId(final int id) {
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
     * Getter for email
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     *
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Getter for nom
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter for nom
     *
     * @param nom the nom to set
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * Getter for prenom
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter for prenom
     *
     * @param prenom the prenom to set
     */
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter for mdpHash
     *
     * @return the mdpHash
     */
    public String getMdpHash() {
        return mdpHash;
    }

    /**
     * Setter for mdpHash
     *
     * @param mdpHash the mdpHash to set
     */
    public void setMdpHash(final String mdpHash) {
        this.mdpHash = mdpHash;
    }

    /**
     * Getter for dateInscription
     *
     * @return the dateInscription
     */
    public Date getDateInscription() {
        return dateInscription;
    }

    /**
     * Setter for dateInscription
     *
     * @param dateInscription the dateInscription to set
     */
    public void setDateInscription(final Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * Getter for estActif
     *
     * @return the estActif
     */
    public boolean isEstActif() {
        return estActif;
    }

    /**
     * Setter for estActif
     *
     * @param estActif the estActif to set
     */
    public void setEstActif(final boolean estActif) {
        this.estActif = estActif;
    }

}
