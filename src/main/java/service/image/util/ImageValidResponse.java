/**
 * 
 */
package service.image.util;

/**
 * Classe représentant ImageValidResponse
 *
 * @author Lucas
 */
public class ImageValidResponse {
    private boolean isValid;
    private String  error;

    private ImageValidResponse() {
        //empty
    }

    /**
     * Classe représentant le builder de ImageValidResponse
     *
     * @author Lucas
     */
    public static class ImageValidResponseBuilder {
        private ImageValidResponse response = new ImageValidResponse();

        /**
         * Permet de renseigner si l'image est valide au builder
         *
         * @param  isValid boolean true si l'image est valide, false sinon
         * @return         ImageValidResponseBuilder
         */
        public ImageValidResponseBuilder withIsValid(final boolean isValid) {
            this.response.setValid(isValid);
            return this;
        }

        /**
         * Permet de renseigner l'erreur au builder
         *
         * @param  error String
         * @return       ImageValidResponseBuilder
         */
        public ImageValidResponseBuilder withError(final String error) {
            this.response.error = error;
            return this;
        }

        /**
         * Permet de build le builder
         *
         * @return ImageValidResponse
         */
        public ImageValidResponse build() {
            return this.response;
        }
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

    /**
     * Getter for isValid
     *
     * @return the isValid
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Setter for isValid
     *
     * @param isValid the isValid to set
     */
    public void setValid(final boolean isValid) {
        this.isValid = isValid;
    }

}
