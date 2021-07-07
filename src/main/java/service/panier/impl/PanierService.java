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

    /**
     * Permet de déterminer le pourcentage de la remise que l'on souhaite appliquer lorsque les conditions sont respectées.
     */
    private static final int    POURCENTAGE_REMISE                    = 5;
    /**
     * Permet de déterminer le prix total minimum que doit faire le panier pour que la remise soit appliquée. <br />
     * (à condition de respecter aussi les autres criètres)
     */
    private static final double PRIX_TOTAL_MINIMUM_POUR_REMISE        = 10000.00;
    /**
     * Permet de déterminer le nombre de références minimum que doit contenir le panier pour que la remise soit appliquée.
     * <br />
     * (à condition de respecter aussi les autres criètres)
     */
    private static final int    NOMBRE_REFERENCES_MINIMUM_POUR_REMISE = 5;

    @Autowired
    private IProduitService     iProduitService;

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
        // on ajoute le sous-total de chaque ligne du panier au prix total
        for (final LigneCommandeProduitDto ligne : panier.getMapPanier().values()) {
            // il est nécessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
            // afin qu'il corresponde au format Double et qu'on puisse faire des opérations dessus
            prixTotal += DecimalFormatUtils.doubleFormatUtil(ligne.getPrix());
        }
        return DecimalFormatUtils.decimalFormatUtil(prixTotal);
    }

    @Override
    public void appliquerRemise(final PanierDto panier) {
        // il est nécessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
        // afin qu'il corresponde au format Double et qu'on puisse faire des opérations dessus
        final var prixTotal = DecimalFormatUtils.doubleFormatUtil(panier.getPrixTotalAffichage());
        // s'il y a 5 références ou plus dans le panier et que son prix total est supérieur ou égal
        // à 2000€, alors on applique une remise de 5%
        if (panier.getNombreDeReferences() >= NOMBRE_REFERENCES_MINIMUM_POUR_REMISE && prixTotal >= PRIX_TOTAL_MINIMUM_POUR_REMISE) {
            panier.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(prixTotal * POURCENTAGE_REMISE / 100));
            // il est nécessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
            // afin qu'il corresponde au format Double et qu'on puisse faire des opérations dessus
            panier.setPrixApresRemiseAffichage(
                    DecimalFormatUtils.decimalFormatUtil(prixTotal - DecimalFormatUtils.doubleFormatUtil(panier.getRemiseAffichage())));
            // sinon, la remise vaut 0 et le prix après remise est le prix total du panier
        } else {
            panier.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(0.00));
            panier.setPrixApresRemiseAffichage(panier.getPrixTotalAffichage());
        }
    }

    @Override
    public void actualiserPrix(final PanierDto panier) {
        panier.setPrixTotalAffichage(calculerPrixTotal(panier));
        appliquerRemise(panier);
    }

}
