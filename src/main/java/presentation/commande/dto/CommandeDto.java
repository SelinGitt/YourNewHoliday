package presentation.commande.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Classe représentant une commande pour la vue
 */
public class CommandeDto implements Serializable {

    /**
     * Générer Automatiquement pour la sérialisation
     */
    private static final long        serialVersionUID = -7225820006767319912L;

    private String                   id;
    private String                   reference;
    private String                   prixTotal;
    private String                   date;
    private String                   quantiteTotale;
    private List<CommandeProduitDto> listCommandeProduitDto;
    private CommandeAdresseDto       adresseLivraison;
    private CommandeAdresseDto       adresseFacturation;

    /**
     * Getter for adresseLivraison
     *
     * @return the adresseLivraison
     */
    public CommandeAdresseDto getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     * Setter for adresseLivraison
     *
     * @param adresseLivraison the adresseLivraison to set
     */
    public void setAdresseLivraison(final CommandeAdresseDto adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    /**
     * Getter for adresseFacturation
     *
     * @return the adresseFacturation
     */
    public CommandeAdresseDto getAdresseFacturation() {
        return adresseFacturation;
    }

    /**
     * Setter for adresseFacturation
     *
     * @param adresseFacturation the adresseFacturation to set
     */
    public void setAdresseFacturation(final CommandeAdresseDto adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id the id to set
     */

    public void setId(final String id) {
        this.id = id;
    }

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
     * Getter for prixTotal
     *
     * @return the prixTotal
     */
    public String getPrixTotal() {
        return prixTotal;
    }

    /**
     * Setter for prixTotal
     *
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(final String prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     * Getter for date
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter for date
     *
     * @param date the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * Getter for quantiteTotale
     * 
     * @return the quantiteTotale
     */
    public String getQuantiteTotale() {
        return quantiteTotale;
    }

    /**
     * Setter for quantiteTotale
     * 
     * @param quantiteTotale the quantiteTotale to set
     */
    public void setQuantiteTotale(final String quantiteTotale) {
        this.quantiteTotale = quantiteTotale;
    }

    /**
     * Getter for listCommandeProduitDto
     *
     * @return the listCommandeProduitDto
     */
    public List<CommandeProduitDto> getListCommandeProduitDto() {
        return listCommandeProduitDto;
    }

    /**
     * Setter for listCommandeProduitDto
     *
     * @param listCommandeProduitDto the listCommandeProduitDto to set
     */
    public void setListCommandeProduitDto(final List<CommandeProduitDto> listCommandeProduitDto) {
        this.listCommandeProduitDto = listCommandeProduitDto;
    }

}
