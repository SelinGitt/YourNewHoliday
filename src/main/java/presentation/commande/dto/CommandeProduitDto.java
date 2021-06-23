/**
 * 
 */
package presentation.commande.dto;

/**
 * Classe représentant le Dto de la liste des produits d'une commande
 *
 * @author Mirailov
 */
public class CommandeProduitDto {

    private String           idListeCommande;

    private ProduitAcheteDto produitAcheteDto;

    private String           quantite;

    private String           prixTotal;

    /**
     * Getter for idListeCommande
     *
     * @return the idListeCommande
     */
    public String getIdListeCommande() {
        return idListeCommande;
    }

    /**
     * Setter for idListeCommande
     *
     * @param idListeCommande the idListeCommande to set
     */
    public void setIdListeCommande(final String idListeCommande) {
        this.idListeCommande = idListeCommande;
    }

    /**
     * Getter for produitAcheteDto
     *
     * @return the produitAcheteDto
     */
    public ProduitAcheteDto getProduitAcheteDto() {
        return produitAcheteDto;
    }

    /**
     * Setter for produitAcheteDto
     *
     * @param produitAcheteDto the produitAcheteDto to set
     */
    public void setProduitAcheteDto(final ProduitAcheteDto produitAcheteDto) {
        this.produitAcheteDto = produitAcheteDto;
    }

    /**
     * Getter for quantite
     *
     * @return the quantite
     */
    public String getQuantite() {
        return quantite;
    }

    /**
     * Setter for quantite
     *
     * @param quantite the quantite to set
     */
    public void setQuantite(final String quantite) {
        this.quantite = quantite;
    }

    /**
     * Getter for prixTotal
     *
     * @return the prixTotal
     */
    public String getPrixTotal() {
        return prixTotal;
    }

    /**
     * Setter for prixTotal
     *
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(final String prixTotal) {
        this.prixTotal = prixTotal;
    }

}
