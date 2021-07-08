/**
 * 
 */
package service.utilisateur.impl;

/**
 * Objet Retour pour UtilisateurService utilisé par la méthode de suppression
 *
 * @author Damien D.
 */
public class UtilisateurServiceReturn {

    /**
     * boolean pour savoir si la suppression a réussi
     */
    private boolean isSucceeded;

    /**
     * boolean pour savoir si l'utilisateur essaie de se supprimer lui-même depuis la liste des utilisateurs (USR_01)
     */
    private boolean isSameUserFromList;

    /**
     * Constructeur privé
     */
    private UtilisateurServiceReturn() {
        // empty
    }

    /**
     * Classe statique interne, Builder de l'objet retour
     */
    static class UtilisateurServiceReturnBuilder {
        private UtilisateurServiceReturn utilisateurServiceReturn = new UtilisateurServiceReturn();

        /**
         * Pour renseigner le boolean isSucceeded
         *
         * @param  isSucceeded : boolean à renseigner
         * @return             : le builder
         */
        UtilisateurServiceReturnBuilder withIsSucceeded(final boolean isSucceeded) {
            utilisateurServiceReturn.isSucceeded = isSucceeded;
            return this;
        }

        /**
         * Pour renseigner le boolean isSameUserFromList
         *
         * @param  isSameUserFromList : le boolean à renseigner
         * @return                    : le builder
         */
        UtilisateurServiceReturnBuilder withIsSameUserFromList(final boolean isSameUserFromList) {
            utilisateurServiceReturn.isSameUserFromList = isSameUserFromList;
            return this;
        }

        /**
         * Pour construire l'UtilisateurServiceReturn
         *
         * @return l'utilisateurServiceReturn construit
         */
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
