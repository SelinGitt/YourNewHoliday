/**
 * 
 */
package persistance.commande.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe représentant l'association entre commande et produit
 *
 * @author Hanan Anghari
 */
@Entity
@Table(name = "liste_commande")
public class CommandeProduitDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idListeCommande")
    private Integer         idCommandeProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCommande")
    private CommandeDo      commandeDo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduit")
    private ProduitAcheteDo produitAcheteDo;

    @Column(name = "quantite")
    private Integer         quantite;

    /**
     * Getter for idCommandeProduit
     *
     * @return the idCommandeProduit
     */
    public Integer getIdCommandeProduit() {
        return idCommandeProduit;
    }

    /**
     * Setter for idCommandeProduit
     *
     * @param idCommandeProduit the idCommandeProduit to set
     */
    public void setIdCommandeProduit(final Integer idCommandeProduit) {
        this.idCommandeProduit = idCommandeProduit;
    }

    /**
     * Getter for commandeDo
     *
     * @return the commandeDo
     */
    public CommandeDo getCommandeDo() {
        return commandeDo;
    }

    /**
     * Setter for commandeDo
     *
     * @param commandeDo the commandeDo to set
     */
    public void setCommandeDo(final CommandeDo commandeDo) {
        this.commandeDo = commandeDo;
    }

    /**
     * Getter for produitAcheteDo
     *
     * @return the produitAcheteDo
     */
    public ProduitAcheteDo getProduitAcheteDo() {
        return produitAcheteDo;
    }

    /**
     * Setter for produitAcheteDo
     *
     * @param produitAcheteDo the produitAcheteDo to set
     */
    public void setProduitAcheteDo(final ProduitAcheteDo produitAcheteDo) {
        this.produitAcheteDo = produitAcheteDo;
    }

    /**
     * Getter for quantite
     *
     * @return the quantite
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     * Setter for quantite
     *
     * @param quantite the quantite to set
     */
    public void setQuantite(final Integer quantite) {
        this.quantite = quantite;
    }

}
