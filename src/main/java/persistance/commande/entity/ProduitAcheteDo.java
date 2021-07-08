/**
 * 
 */
package persistance.commande.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * classe représentant un ProduitAcheteen BD
 *
 * @author Hanan Anghari
 */
@Entity
@Table(name = "produit_achete")
public class ProduitAcheteDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private Integer    idProduit;

    @Column(name = "idDeLOriginal")
    private Integer    idDeLOriginal;

    private Integer    version;

    @Column(name = "reference")
    private String     reference;

    @Column(name = "nom")
    private String     nom;

    @Column(name = "description")
    private String     description;

    @Column(name = "destination")
    private String     destination;

    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;

    private String     hebergement;

    @Column(name = "mise_en_vente", columnDefinition = "TINYINT", length = 1)
    private Boolean    miseEnVente;

    @Column(name = "chemin_de_l_image")
    private String     cheminImage;

    private Integer    services;

    /**
     * Constructor
     */
    public ProduitAcheteDo() {
        //empty
    }

    /**
     * Getter for idProduit
     *
     * @return the idProduit
     */
    public Integer getIdProduit() {
        return idProduit;
    }

    /**
     * Setter for idProduit
     *
     * @param idProduit the idProduit to set
     */
    public void setIdProduit(final Integer idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * Getter for idDeLOriginal
     *
     * @return the idDeLOriginal
     */
    public Integer getIdDeLOriginal() {
        return idDeLOriginal;
    }

    /**
     * Setter for idDeLOriginal
     *
     * @param idDeLOriginal the idDeLOriginal to set
     */
    public void setIdDeLOriginal(final Integer idDeLOriginal) {
        this.idDeLOriginal = idDeLOriginal;
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
    public void setVersion(Integer version) {
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
    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * Setter for prixUnitaire
     *
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(final BigDecimal prixUnitaire) {
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
    public void setHebergement(String hebergement) {
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
    public void setMiseEnVente(Boolean miseEnVente) {
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
    public void setServices(Integer services) {
        this.services = services;
    }

}
