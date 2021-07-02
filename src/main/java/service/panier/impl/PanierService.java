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
        LigneCommandeProduitDto ligneCommande = mapPanier.getOrDefault(produitAjout, new LigneCommandeProduitDto());
        var quantiteProduit = 0;
        // si le produit n'est pas dans le panier 
        if (ligneCommande.getQuantite() == null) {
            // on effectue la modification que si la quantité n'est pas nulle ou négative
            if (quantite < 1) {
                return panier;
            }
            // le nombre de produits ajoutés à la map correspondra à la quantité en paramètre.            
            quantiteProduit = quantite;
        } else {
            // sinon, on mets à jour la quantité existante            
            quantiteProduit = ligneCommande.getQuantite() + quantite;
        }
        // si la quantité du produit que l'on met à jour devient nulle ou négative, 
        // alors le produit est supprimé du panier.
        if (quantiteProduit < 1) {
            mapPanier.remove(produitAjout);
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
        // on met à jour le nombre de référence dans le panier.
        panier.setNombreDeReferences(panier.getMapPanier().size());
        return panier;
    }

    @Override
    public ProduitDto findProduitMap(final PanierDto panier, final Integer idProduit) {
        return panier.getMapPanier().keySet().stream().filter(p -> p.getIdProduitOriginal().equals(idProduit.toString())).findFirst()
                .orElse(null);

    }

    @Override
    public void deleteProduitPanier(final PanierDto panier, final Integer idProduit) {
        panier.getMapPanier().remove(findProduitMap(panier, idProduit));
        panier.setNombreDeReferences(panier.getMapPanier().size());
    }

    @Override
    public void viderPanier(final PanierDto panier) {
        panier.getMapPanier().clear();
        panier.setNombreDeReferences(0);
    }

    @Override
    public String calculerPrixTotal(final PanierDto panier) {
        var prixTotal = 0.00;
        for (final LigneCommandeProduitDto ligne : panier.getMapPanier().values()) {
            prixTotal += Double.valueOf(ligne.getPrix().replace("\u00A0", "").replace(",", "."));
        }
        return DecimalFormatUtils.decimalFormatUtil(prixTotal);
    }

    @Override
    public void appliquerRemise(final PanierDto panier) {
        final var prixTotal = Double.valueOf(panier.getPrixTotal().replace("\u00A0", "").replace(",", "."));
        if (panier.getNombreDeReferences() >= 5 && prixTotal >= 2000.00) {
            panier.setRemise(DecimalFormatUtils.decimalFormatUtil(prixTotal / 20));
            panier.setPrixApresRemise(DecimalFormatUtils
                    .decimalFormatUtil(prixTotal - Double.valueOf(panier.getRemise().replace("\u00A0", "").replace(",", "."))));
        } else {
            panier.setRemise("0");
            panier.setPrixApresRemise(panier.getPrixTotal());
        }
    }

}
