package persistance.utilisateur.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Integer idUtilisateur;

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

    @Column(name = "date_de_naissance")
    private Date    dateNaissance;

    @Column(name = "adresse")
    private String  adresse;

    @Column(name = "chemin_de_lavatar")
    private String  cheminAvatar;

    @Column(name = "est_desactive")
    private Boolean estActif;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private RoleDo  role;

    /**
     * Constructor
     */
    public UtilisateurDo() {
        super();
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
    public Boolean getEstActif() {
        return estActif;
    }

    /**
     * Setter for estActif
     *
     * @param estActif the estActif to set
     */
    public void setEstActif(final Boolean estActif) {
        this.estActif = estActif;
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
     * Getter for dateNaissance
     *
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter for dateNaissance
     *
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(final Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter for adresse
     *
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter for adresse
     *
     * @param adresse the adresse to set
     */
    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter for cheminAvatar
     *
     * @return the cheminAvatar
     */
    public String getCheminAvatar() {
        return cheminAvatar;
    }

    /**
     * Setter for cheminAvatar
     *
     * @param cheminAvatar the cheminAvatar to set
     */
    public void setCheminAvatar(final String cheminAvatar) {
        this.cheminAvatar = cheminAvatar;
    }

}
