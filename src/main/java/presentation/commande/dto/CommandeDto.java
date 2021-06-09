package presentation.commande.dto;

/**
 * Classe repr�sentant une commande pour la vue
 */
public class CommandeDto {
	private String id;
	private String reference;
	private String prixTotal;
	private String date;
	private String quantiteTotale;

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

}
