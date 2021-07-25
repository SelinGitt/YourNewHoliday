/**
 * 
 */
package presentation.commande.dto;

import java.io.Serializable;

/**
 * Classe représentant le DTO des produits achetés d'une commande
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public class ProduitAcheteDto implements Serializable {

    /**
     * Générer Automatiquement pour la sérialisation
     */
    private static final long serialVersionUID = 4734697887239927315L;

    private String            id;

    private String            idDeLOriginal;

    private String            version;

    private String            hebergement;

    private String            reference;

    private String            nom;

    private String            description;

    private String            destination;

    private String            prixUnitaire;

    private String            cheminDeLImage;

    /**
     * Getter for idDeLOriginal
     *
     * @return the idDeLOriginal
     */
    public String getIdDeLOriginal() {
        return idDeLOriginal;
    }

    /**
     * Setter for idDeLOriginal
     *
     * @param idDeLOriginal the idDeLOriginal to set
     */
    public void setIdDeLOriginal(final String idDeLOriginal) {
        this.idDeLOriginal = idDeLOriginal;
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
     * Getter for description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Getter for destination
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter for destination
     *
     * @param destination the destination to set
     */
    public void setDestination(final String destination) {
        this.destination = destination;
    }

    /**
     * Setter for prixUnitaire
     *
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(final String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    /**
     * Getter for prixUnitaire
     *
     * @return the prixUnitaire
     */
    public String getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * Getter for cheminDeLImage
     *
     * @return the cheminDeLImage
     */
    public String getCheminDeLImage() {
        return cheminDeLImage;
    }

    /**
     * Setter for cheminDeLImage
     *
     * @param cheminDeLImage the cheminDeLImage to set
     */
    public void setCheminDeLImage(final String cheminDeLImage) {
        this.cheminDeLImage = cheminDeLImage;
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Getter for version
     *
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter for version
     *
     * @param version the version to set
     */
    public void setVersion(final String version) {
        this.version = version;
    }

    /**
     * Getter for hebergement
     *
     * @return the hebergement
     */
    public String getHebergement() {
        return hebergement;
    }

    /**
     * Setter for hebergement
     *
     * @param hebergement the hebergement to set
     */
    public void setHebergement(final String hebergement) {
        this.hebergement = hebergement;
    }

}
