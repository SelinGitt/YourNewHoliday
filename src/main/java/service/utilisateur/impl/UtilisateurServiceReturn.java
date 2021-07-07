/**
 * 
 */
package service.utilisateur.impl;

/**
 * Objet Retour pour UtilisateurService
 *
 * @author Administrateur
 */
public class UtilisateurServiceReturn {

    private boolean isSucceeded;

    private boolean isSameUserFromList;

    private UtilisateurServiceReturn() {
        // empty
    }

    static class UtilisateurServiceReturnBuilder {
        private UtilisateurServiceReturn utilisateurServiceReturn = new UtilisateurServiceReturn();

        UtilisateurServiceReturnBuilder withIsSucceeded(final boolean isSucceeded) {
            utilisateurServiceReturn.isSucceeded = isSucceeded;
            return this;
        }

        UtilisateurServiceReturnBuilder withIsSameUserFromList(final boolean isSameUserFromList) {
            utilisateurServiceReturn.isSameUserFromList = isSameUserFromList;
            return this;
        }

        UtilisateurServiceReturn build() {
            return utilisateurServiceReturn;
        }
    }

    /**
     * Getter for isSucceeded
     *
     * @return the isSucceeded
     */
    public boolean isSucceeded() {
        return isSucceeded;
    }

    /**
     * Setter for isSucceeded
     *
     * @param isSucceeded the isSucceeded to set
     */
    public void setSucceeded(final boolean isSucceeded) {
        this.isSucceeded = isSucceeded;
    }

    /**
     * Getter for isSameUserFromList
     *
     * @return the isSameUserFromList
     */
    public boolean isSameUserFromList() {
        return isSameUserFromList;
    }

    /**
     * Setter for isSameUserFromList
     *
     * @param isSameUserFromList the isSameUserFromList to set
     */
    public void setSameUserFromList(final boolean isSameUserFromList) {
        this.isSameUserFromList = isSameUserFromList;
    }
}
