/**
 * 
 */
package service.produit.util;

import presentation.produit.dto.ProduitDto;

/**
 * Classe représentant ProduitEditerResponse
 *
 * @author Valentin
 */
public class ProduitEditerResponse {

    private ProduitDto produit;

    private String     error;

    /**
     * Constructor
     */
    private ProduitEditerResponse() {
        // Empty CTR
    }

    /**
     * ProduitEditerResponseBuilder Classe <br>
     * Build la reponse
     */
    public static class ProduitEditerResponseBuilder {
        private final ProduitEditerResponse pdtResponse = new ProduitEditerResponse();

        /**
         * Permet de renseigner un produit
         *
         * @param  produit ProduitDto
         * @return         ProduitEditerResponseBuilder
         */
        public ProduitEditerResponseBuilder withPdt(final ProduitDto produit) {
            this.pdtResponse.produit = produit;
            return this;
        }

        /**
         * Permet de renseigner une erreur
         *
         * @param  error Erreur
         * @return       ProduitEditerResponseBuilder
         */
        public ProduitEditerResponseBuilder withError(final String error) {
            this.pdtResponse.error = error;
            return this;
        }

        /**
         * Permet de build la reponse
         *
         * @return ProduitEditerResponse
         */
        public ProduitEditerResponse build() {
            return this.pdtResponse;
        }
    }

    /**
     * Getter for produit
     *
     * @return the produit
     */
    public ProduitDto getProduit() {
        return produit;
    }

    /**
     * Setter for produit
     *
     * @param produit the produit to set
     */
    public void setProduit(final ProduitDto produit) {
        this.produit = produit;
    }

    /**
     * Getter for error
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Setter for error
     *
     * @param error the error to set
     */
    public void setError(final String error) {
        this.error = error;
    }

}
