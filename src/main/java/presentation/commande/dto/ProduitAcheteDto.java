/**
 * 
 */
package presentation.commande.dto;

/**
 * Classe représentant le DTO des produits achetés d'une commande
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public class ProduitAcheteDto {

    private String idProduit;

    private String reference;

    private String nom;

    private String description;

    private String prixUnitaire;

    private String cheminDeLImage;

    /**
     * Getter for idProduit
     *
     * @return the idProduit
     */
    public String getIdProduit() {
        return idProduit;
    }

    /**
     * Setter for idProduit
     *
     * @param idProduit the idProduit to set
     */
    public void setIdProduit(final String idProduit) {
        this.idProduit = idProduit;
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

}
