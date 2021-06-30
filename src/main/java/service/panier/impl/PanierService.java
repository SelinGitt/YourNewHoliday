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
 * Classe représentant l'interface métier {@link IPanierService}
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
        // si le produit à ajouter n'est pas en vente ou n'est pas en base, 
        // alors le panier reste inchangé.
        if (produitAjout == null) {
            return panier;
        }
        final Map<ProduitDto, LigneCommandeProduitDto> mapPanier = panier.getMapPanier();
        // On récupère la ligne de commande
        LigneCommandeProduitDto ligneCommande = mapPanier.get(produitAjout);
        // si le produit n'était pas dans le panier 
        // le nombre de produits ajoutés à la map correspondra à la quantité en paramètre.
        if (ligneCommande == null) {
            // on l'ajoute si la quantité n'est pas nulle ou négative
            if (quantite > 0) {
                // on crée la ligne de commande
                ligneCommande = new LigneCommandeProduitDto();
                // on ajoute la quantité
                ligneCommande.setQuantite(quantite);
                // On récupère le prix unitaire               
                final var prixUnitaire = Double.valueOf(produitAjout.getPrixUnitaire());
                // On calcule le prix
                final Double prix = prixUnitaire * quantite;
                // on ajoute le prix formaté à la ligne de commande
                ligneCommande.setPrix(DecimalFormatUtils.decimalFormatUtil(prix));
                // on mets à jour la map
                mapPanier.put(produitAjout, ligneCommande);
            }
            // sinon, on mets à jour la quantité existante
        } else {
            final Integer quantiteProduit = ligneCommande.getQuantite() + quantite;
            // si la quantité du produit que l'on met à jour devient nulle ou négative, 
            // alors le produit est supprimé du panier.
            if (quantiteProduit < 1) {
                mapPanier.remove(produitAjout);
                // on met à jour le produit dans la map du panier avec sa nouvelle quantité.
            } else {
                // on modifie la ligne de commande
                ligneCommande.setQuantite(quantiteProduit);
                // On récupère le prix unitaire
                final var prixUnitaire = Double.valueOf(produitAjout.getPrixUnitaire());
                // On calcule le prix
                final Double prix = prixUnitaire * quantiteProduit;
                // on ajoute le prix formaté à la ligne de commande
                ligneCommande.setPrix(DecimalFormatUtils.decimalFormatUtil(prix));
                // on mets à jour la map
                mapPanier.put(produitAjout, ligneCommande);
            }
        }
        // on met à jour le nombre de référence dans le panier.
        panier.setNombreDeReferences(panier.getMapPanier().size());
        return panier;
    }
}
