/**
 * 
 */
package presentation.commande.dto;

import java.io.Serializable;

/**
 * Classe représentant servant à rechercher et utiliser les adresses du formulaire de pan_08
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public class AdressesDto implements Serializable {

    /**
     * 
     */
    private static final long  serialVersionUID = -5129924225575835325L;

    private CommandeAdresseDto commandeAdresseLivraison;
    private CommandeAdresseDto commandeAdresseFacturation;
    private CommandeAdresseDto defaultAdresse;

    /**
     * Getter for commandeAdresseLivraison
     *
     * @return the commandeAdresseLivraison
     */
    public CommandeAdresseDto getCommandeAdresseLivraison() {
        return commandeAdresseLivraison;
    }

    /**
     * Setter for commandeAdresseLivraison
     *
     * @param commandeAdresseLivraison the commandeAdresseLivraison to set
     */
    public void setCommandeAdresseLivraison(final CommandeAdresseDto commandeAdresseLivraison) {
        this.commandeAdresseLivraison = commandeAdresseLivraison;
    }

    /**
     * Getter for commandeAdresseFacturation
     *
     * @return the commandeAdresseFacturation
     */
    public CommandeAdresseDto getCommandeAdresseFacturation() {
        return commandeAdresseFacturation;
    }

    /**
     * Setter for commandeAdresseFacturation
     *
     * @param commandeAdresseFacturation the commandeAdresseFacturation to set
     */
    public void setCommandeAdresseFacturation(final CommandeAdresseDto commandeAdresseFacturation) {
        this.commandeAdresseFacturation = commandeAdresseFacturation;
    }

    /**
     * Getter for defaultAdresse
     *
     * @return the defaultAdresse
     */
    public CommandeAdresseDto getDefaultAdresse() {
        return defaultAdresse;
    }

    /**
     * Setter for defaultAdresse
     *
     * @param defaultAdresse the defaultAdresse to set
     */
    public void setDefaultAdresse(final CommandeAdresseDto defaultAdresse) {
        this.defaultAdresse = defaultAdresse;
    }
}
