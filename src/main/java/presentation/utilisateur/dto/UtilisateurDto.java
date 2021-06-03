/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe représentant un utilisateur pour la vue
 *
 * @author Meliodas-sama
 */
public class UtilisateurDto implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -9088276324507198365L;
    private String            idUtilisateur;
    private String            email;
    private String            password;
    private String            reference;
    private String            nom;
    private String            prenom;
    private Date              dateInscription;
    private Boolean           estActif;

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
     * Getter for password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     *
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
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
     * Getter for idUtilisateur
     *
     * @return the idUtilisateur
     */
    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * Setter for idUtilisateur
     *
     * @param idUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(final String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}
