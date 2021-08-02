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
    private byte[] data;
    private String error;

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
         * Permet de renseigner l'image au builder
         *
         * @param  image File
         * @return       ImageValidResponseBuilder
         */
        public ImageValidResponseBuilder withData(final byte[] image) {
            this.response.data = image;
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
     * Getter for imageToValidate
     *
     * @return the imageToValidate
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Setter for imageToValidate
     *
     * @param data the data to set
     */
    public void setData(final byte[] data) {
        this.data = data;
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
