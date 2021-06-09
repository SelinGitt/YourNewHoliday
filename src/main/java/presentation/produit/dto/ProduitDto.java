/**
 * 
 */
package presentation.produit.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe représentant un produit pour la vue
 *
 * @author Administrateur
 */
public class ProduitDto implements Serializable {

    /**
     * Serial Version UID généré aléatoirement
     */
    private static final long serialVersionUID = 8646499598254785864L;

    @Override
    public int hashCode() {
        return Objects.hash(idProduitOriginal);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProduitDto other = (ProduitDto) obj;
        return Objects.equals(idProduitOriginal, other.idProduitOriginal);
    }

    private String idProduitOriginal;

    private String version;

    private String reference;

    private String nom;

    private String description;

    private String destination;

    private String prixUnitaire;

    private String hebergement;

    private String miseEnVente;

    private String cheminImage;

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
     * Getter for prixUnitaire
     *
     * @return the prixUnitaire
     */
    public String getPrixUnitaire() {
        return prixUnitaire;
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
     * Getter for miseEnVente
     *
     * @return the miseEnVente
     */
    public String getMiseEnVente() {
        return miseEnVente;
    }

    /**
     * Setter for miseEnVente
     *
     * @param miseEnVente the miseEnVente to set
     */
    public void setMiseEnVente(final String miseEnVente) {
        this.miseEnVente = miseEnVente;
    }

    /**
     * Getter for cheminImage
     *
     * @return the cheminImage
     */
    public String getCheminImage() {
        return cheminImage;
    }

    /**
     * Setter for cheminImage
     *
     * @param cheminImage the cheminImage to set
     */
    public void setCheminImage(final String cheminImage) {
        this.cheminImage = cheminImage;
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
