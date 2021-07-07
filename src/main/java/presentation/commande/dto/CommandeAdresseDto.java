/**
 * 
 */
package presentation.commande.dto;

import java.io.Serializable;

/**
 * Classe représentant l'adresse de la commande recuperer dans pan08
 *
 * @author Alexandre
 */
public class CommandeAdresseDto implements Serializable {

    /**
     * Générer Automatiquement pour la sérialisation
     */
    private static final long serialVersionUID = -6733344325013740271L;

    private String            nom;
    private String            prenom;
    private String            adresse;

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

}
