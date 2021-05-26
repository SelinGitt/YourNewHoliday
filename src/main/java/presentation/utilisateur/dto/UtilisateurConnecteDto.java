/**
 * 
 */
package presentation.utilisateur.dto;

import java.io.Serializable;

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
    private static final long serialVersionUID = -2043241208068422853L;
    
    private String idRole;
    private String idUtilisateur;
    private String nom;
    private String prenom;
    private String nbProduitPanier;

    /**
     * Constructor
     */
    public UtilisateurConnecteDto() {
        super();
    }

    /**
     * Getter for idRole
     *
     * @return the idRole
     */
    public String getIdRole() {
        return idRole;
    }

    /**
     * Setter for idRole
     *
     * @param idRole the idRole to set
     */
    public void setIdRole(String idRole) {
        this.idRole = idRole;
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
    public void setIdUtilisateur(String idUtilisateur) {
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
    public void setNom(String nom) {
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
    public void setPrenom(String prenom) {
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
    public void setNbProduitPanier(String nbProduitPanier) {
        this.nbProduitPanier = nbProduitPanier;
    }

}
