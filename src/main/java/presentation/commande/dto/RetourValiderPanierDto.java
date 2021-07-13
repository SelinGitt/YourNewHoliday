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
public class RetourValiderPanierDto implements Serializable {

    /**
     * Serial ID généré automatiquement
     */
    private static final long serialVersionUID = -7543566244365676007L;

    // La reference de la commande
    private String            reference;

    // la liste des produits qui ne sont plus en base
    private List<Integer>     listIdProduitNonConcordant;

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
     * Getter for listIdProduitNonConcordant
     *
     * @return the listIdProduitNonConcordant
     */
    public List<Integer> getListIdProduitNonConcordant() {
        return listIdProduitNonConcordant;
    }

    /**
     * Setter for listIdProduitNonConcordant
     *
     * @param listIdProduitNonConcordant the listIdProduitNonConcordant to set
     */
    public void setListIdProduitNonConcordant(final List<Integer> listIdProduitNonConcordant) {
        this.listIdProduitNonConcordant = listIdProduitNonConcordant;
    }
}
