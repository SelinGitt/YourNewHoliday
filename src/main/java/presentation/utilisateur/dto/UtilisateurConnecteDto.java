/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;

import service.utilisateur.util.UtilisateurRoleEnum;

/**
 * Classe UtilisateurConnecteDto <br>
 * Contient les informations mise en session
 *
 * @author Valentin
 */
public class UtilisateurConnecteDto implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long   serialVersionUID = 1424694129404702994L;

    private UtilisateurRoleEnum role;
    private String              idUtilisateur;
    private String              nom;
    private String              prenom;
    private String              nbProduitPanier;

    /**
     * Constructor
     */
    public UtilisateurConnecteDto() {
        super();
    }

    /**
     * Getter for role
     *
     * @return the role
     */
    public UtilisateurRoleEnum getRole() {
        return role;
    }

    /**
     * Setter for role
     *
     * @param role the role to set
     */
    public void setRole(final UtilisateurRoleEnum role) {
        this.role = role;
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
     * Getter for nbProduitPanier
     *
     * @return the nbProduitPanier
     */
    public String getNbProduitPanier() {
        return nbProduitPanier;
    }

    /**
     * Setter for nbProduitPanier
     *
     * @param nbProduitPanier the nbProduitPanier to set
     */
    public void setNbProduitPanier(final String nbProduitPanier) {
        this.nbProduitPanier = nbProduitPanier;
    }

    /**
     * Getter for serialversionuid
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
