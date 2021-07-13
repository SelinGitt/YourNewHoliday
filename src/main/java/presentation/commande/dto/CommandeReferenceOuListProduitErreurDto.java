/**
 * 
 */
package presentation.commande.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Classe représentant une List de produit dont les versions ne sont plus en base
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public class CommandeReferenceOuListProduitErreurDto implements Serializable {

    /**
     * Serial ID généré automatiquement
     */
    private static final long serialVersionUID = 7530116138793985507L;

    // La reference de la commande
    private String            reference;

    // la liste des produits qui ne sont plus en base
    private List<Integer>     idProduitNonConcordant;

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
