/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;

/**
 * Classe représentant un utilisateur pour la vue
 *
 * @author Meliodas-sama
 */
public class UtilisateurDto implements Serializable {

    /**
     * Generated Serial UID
     */
    private static final long serialVersionUID = -2412085353414875962L;

    private Integer           id;
    private String            email;
    private String            password;
    private String            confirmPassword;
    private String            reference;
    private String            nom;
    private String            prenom;
    private String            adresse;
    private String            dateInscription;
    private String            dateNaissance;
    private Boolean           estDesactive;
    private RoleDto           role;
    private String            cheminAvatar;

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
    public String getDateInscription() {
        return dateInscription;
    }

    /**
     * Setter for dateInscription
     *
     * @param dateInscription the dateInscription to set
     */
    public void setDateInscription(final String dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * Getter for estDesactive
     *
     * @return the estDesactive
     */
    public Boolean getEstDesactive() {
        return estDesactive;
    }

    /**
     * Setter for estDesactive
     *
     * @param estDesactive the estActif to set
     */
    public void setEstDesactive(final Boolean estDesactive) {
        this.estDesactive = estDesactive;
    }

    /**
     * Getter for role
     *
     * @return the role
     */
    public RoleDto getRole() {
        return role;
    }

    /**
     * Setter for role
     *
     * @param role the role to set
     */
    public void setRole(final RoleDto role) {
        this.role = role;
    }

    /**
     * Getter for confirmPassword
     *
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Setter for confirmPassword
     *
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Getter for dateNaissance
     *
     * @return the dateNaissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter for dateNaissance
     *
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(final String dateNaissance) {
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
