/**
 * 
 */
package presentation.produit.dto;

/**
 * Classe représentant un produit pour la vue
 *
 * @author Administrateur
 */
public class ProduitDto {
    private String idProduitOriginal;

    private String version;

    private String reference;

    private String nom;

    private String description;

    private String destination;

    private String prix_unitaire;

    private String hebergement;

    private String mise_en_vente;

    private String chemin_de_l_image;

    private String services;

    /**
     * Getter for idProduitOriginal
     *
     * @return the idProduitOriginal
     */
    public String getIdProduitOriginal() {
        return idProduitOriginal;
    }

    /**
     * Setter for idProduitOriginal
     *
     * @param idProduitOriginal the idProduitOriginal to set
     */
    public void setIdProduitOriginal(final String idProduitOriginal) {
        this.idProduitOriginal = idProduitOriginal;
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
     * Getter for prix_unitaire
     *
     * @return the prix_unitaire
     */
    public String getPrix_unitaire() {
        return prix_unitaire;
    }

    /**
     * Setter for prix_unitaire
     *
     * @param prix_unitaire the prix_unitaire to set
     */
    public void setPrix_unitaire(final String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
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

    /**
     * Getter for mise_en_vente
     *
     * @return the mise_en_vente
     */
    public String getMise_en_vente() {
        return mise_en_vente;
    }

    /**
     * Setter for mise_en_vente
     *
     * @param mise_en_vente the mise_en_vente to set
     */
    public void setMise_en_vente(final String mise_en_vente) {
        this.mise_en_vente = mise_en_vente;
    }

    /**
     * Getter for chemin_de_l_image
     *
     * @return the chemin_de_l_image
     */
    public String getChemin_de_l_image() {
        return chemin_de_l_image;
    }

    /**
     * Setter for chemin_de_l_image
     *
     * @param chemin_de_l_image the chemin_de_l_image to set
     */
    public void setChemin_de_l_image(final String chemin_de_l_image) {
        this.chemin_de_l_image = chemin_de_l_image;
    }

    /**
     * Getter for services
     *
     * @return the services
     */
    public String getServices() {
        return services;
    }

    /**
     * Setter for services
     *
     * @param services the services to set
     */
    public void setServices(final String services) {
        this.services = services;
    }
}
