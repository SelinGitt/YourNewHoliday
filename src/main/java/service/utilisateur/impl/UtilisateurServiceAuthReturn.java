/**
 * 
 */
package service.utilisateur.impl;

import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Objet Retour pour UtilisateurService utilisé par la méthode d'authentification
 *
 * @author Damien D.
 */
public class UtilisateurServiceAuthReturn {

    /**
     * utilisateurConnecteDto à envoyer à la couche présentation après authentification
     */
    private UtilisateurConnecteDto utilisateurConnecteDto;

    /**
     * boolean pour savoir si l'utilisateur est désactivé
     */
    private boolean                isDesactive;

    /**
     * Constructeur privé
     */
    private UtilisateurServiceAuthReturn() {
        // empty
    }

    /**
     * Classe statique interne, Builder de l'objet retour
     */
    static class UtilisateurServiceAuthReturnBuilder {
        private UtilisateurServiceAuthReturn utilisateurServiceAuthReturn = new UtilisateurServiceAuthReturn();

        /**
         * Pour renseigner l'utilisateurConnecteDto
         *
         * @return : le builder
         */
        UtilisateurServiceAuthReturnBuilder withUtilisateurConnecteDto(final UtilisateurConnecteDto utilisateurConnecteDto) {
            utilisateurServiceAuthReturn.utilisateurConnecteDto = utilisateurConnecteDto;
            return this;
        }

        /**
         * Pour renseigner le boolean isDesactive
         *
         * @param  isDesactive : le boolean à renseigner
         * @return             : le builder
         */
        UtilisateurServiceAuthReturnBuilder withIsDesactive(final boolean isDesactive) {
            utilisateurServiceAuthReturn.isDesactive = isDesactive;
            return this;
        }

        /**
         * Pour construire l'UtilisateurServiceAuthReturn
         *
         * @return l'utilisateurServiceAuthReturn construit
         */
        UtilisateurServiceAuthReturn build() {
            return utilisateurServiceAuthReturn;
        }
    }

    /**
     * Getter for utilisateurConnecteDto
     *
     * @return the utilisateurConnecteDto
     */
    public UtilisateurConnecteDto getUtilisateurConnecteDto() {
        return utilisateurConnecteDto;
    }

    /**
     * Setter for utilisateurConnecteDto
     *
     * @param utilisateurConnecteDto the utilisateurConnecteDto to set
     */
    public void setUtilisateurConnecteDto(final UtilisateurConnecteDto utilisateurConnecteDto) {
        this.utilisateurConnecteDto = utilisateurConnecteDto;
    }

    /**
     * Getter for isDesactive
     *
     * @return the isDesactive
     */
    public boolean isDesactive() {
        return isDesactive;
    }

    /**
     * Setter for isDesactive
     *
     * @param isDesactive the isDesactive to set
     */
    public void setDesactive(final boolean isDesactive) {
        this.isDesactive = isDesactive;
    }
}
