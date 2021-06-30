/**
 * 
 */
package service.panier.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.util.DecimalFormatUtils;

/**
 * Classe repr�sentant l'interface m�tier {@link IPanierService}
 *
 * @author NathanR
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PanierService implements IPanierService {

    @Autowired
    private IProduitService iProduitService;

    @Override
    public PanierDto updatePanier(final PanierDto panier, final Integer idProduit, final Integer quantite) {
        final ProduitDto produitAjout = iProduitService.trouverProduitEnVente(idProduit);
        // si le produit � ajouter n'est pas en vente ou n'est pas en base, 
        // alors le panier reste inchang�.
        if (produitAjout == null) {
            return panier;
        }
        final Map<ProduitDto, LigneCommandeProduitDto> mapPanier = panier.getMapPanier();
        // On r�cup�re la ligne de commande
        LigneCommandeProduitDto ligneCommande = mapPanier.get(produitAjout);
        // si le produit n'�tait pas dans le panier 
        // le nombre de produits ajout�s � la map correspondra � la quantit� en param�tre.
        if (ligneCommande == null) {
            // on l'ajoute si la quantit� n'est pas nulle ou n�gative
            if (quantite > 0) {
                // on cr�e la ligne de commande
                ligneCommande = new LigneCommandeProduitDto();
                // on ajoute la quantit�
                ligneCommande.setQuantite(quantite);
                // On r�cup�re le prix unitaire               
                final var prixUnitaire = Double.valueOf(produitAjout.getPrixUnitaire());
                // On calcule le prix
                final Double prix = prixUnitaire * quantite;
                // on ajoute le prix format� � la ligne de commande
                ligneCommande.setPrix(DecimalFormatUtils.decimalFormatUtil(prix));
                // on mets � jour la map
                mapPanier.put(produitAjout, ligneCommande);
            }
            // sinon, on mets � jour la quantit� existante
        } else {
            final Integer quantiteProduit = ligneCommande.getQuantite() + quantite;
            // si la quantit� du produit que l'on met � jour devient nulle ou n�gative, 
            // alors le produit est supprim� du panier.
            if (quantiteProduit < 1) {
                mapPanier.remove(produitAjout);
                // on met � jour le produit dans la map du panier avec sa nouvelle quantit�.
            } else {
                // on modifie la ligne de commande
                ligneCommande.setQuantite(quantiteProduit);
                // On r�cup�re le prix unitaire
                final var prixUnitaire = Double.valueOf(produitAjout.getPrixUnitaire());
                // On calcule le prix
                final Double prix = prixUnitaire * quantiteProduit;
                // on ajoute le prix format� � la ligne de commande
                ligneCommande.setPrix(DecimalFormatUtils.decimalFormatUtil(prix));
                // on mets � jour la map
                mapPanier.put(produitAjout, ligneCommande);
            }
        }
        // on met � jour le nombre de r�f�rence dans le panier.
        panier.setNombreDeReferences(panier.getMapPanier().size());
        return panier;
    }
}
