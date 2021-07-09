/**
 * 
 */
package presentation.commande.dto;

import java.util.List;

/**
 * Classe représentant une List de produit dont les versions ne sont plus en base
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public class CommandePanierListProduitErreur {

    // La reference de la commande
    private String        reference              = null;

    // la liste des produits qui ne sont plus en base
    private List<Integer> idProduitNonConcordant = null;

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
     * Getter for idProduitNonConcordant
     *
     * @return the idProduitNonConcordant
     */
    public List<Integer> getIdProduitNonConcordant() {
        return idProduitNonConcordant;
    }

    /**
     * Setter for idProduitNonConcordant
     *
     * @param idProduitNonConcordant the idProduitNonConcordant to set
     */
    public void setIdProduitNonConcordant(final List<Integer> idProduitNonConcordant) {
        this.idProduitNonConcordant = idProduitNonConcordant;
    }
}
