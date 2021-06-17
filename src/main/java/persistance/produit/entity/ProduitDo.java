/**
 * 
 */
package persistance.produit.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe représentant un produit en BD
 *
 * @author Administrateur
 */
@Entity
@Table(name = "produit")
public class ProduitDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduitOriginal;

    private Integer version;

    private String  reference;

    private String  nom;

    private String  description;

    private String  destination;

    @Column(name = "prix_unitaire")
    private Double  prixUnitaire;

    private String  hebergement;

    @Column(name = "mise_en_vente", columnDefinition = "TINYINT", length = 1)
    private Boolean miseEnVente;

    @Column(name = "chemin_de_l_image")
    private String  cheminImage;

    private Integer services;

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
        final ProduitDo other = (ProduitDo) obj;
        return Objects.equals(idProduitOriginal, other.idProduitOriginal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduitOriginal);
    }

    /**
     * Getter for idProduitOriginal
     *
     * @return the idProduitOriginal
     */
    public Integer getIdProduitOriginal() {
        return idProduitOriginal;
    }

    /**
     * Setter for idProduitOriginal
     *
     * @param idProduitOriginal the idProduitOriginal to set
     */
    public void setIdProduitOriginal(final Integer idProduitOriginal) {
        this.idProduitOriginal = idProduitOriginal;
    }

    /**
     * Getter for version
     *
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Setter for version
     *
     * @param version the version to set
     */
    public void setVersion(final Integer version) {
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
    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * Setter for prixUnitaire
     *
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(final Double prixUnitaire) {
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
    public Boolean getMiseEnVente() {
        return miseEnVente;
    }

    /**
     * Setter for miseEnVente
     *
     * @param miseEnVente the miseEnVente to set
     */
    public void setMiseEnVente(final Boolean miseEnVente) {
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
    public Integer getServices() {
        return services;
    }

    /**
     * Setter for services
     *
     * @param services the services to set
     */
    public void setServices(final Integer services) {
        this.services = services;
    }
}
