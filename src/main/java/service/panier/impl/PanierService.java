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
        LigneCommandeProduitDto ligneCommande = mapPanier.getOrDefault(produitAjout, new LigneCommandeProduitDto());
        var quantiteProduit = 0;
        // si le produit n'est pas dans le panier 
        if (ligneCommande.getQuantite() == null) {
            // on effectue la modification que si la quantit� n'est pas nulle ou n�gative
            if (quantite < 1) {
                return panier;
            }
            // le nombre de produits ajout�s � la map correspondra � la quantit� en param�tre.            
            quantiteProduit = quantite;
        } else {
            // sinon, on mets � jour la quantit� existante            
            quantiteProduit = ligneCommande.getQuantite() + quantite;
        }
        // si la quantit� du produit que l'on met � jour devient nulle ou n�gative, 
        // alors le produit est supprim� du panier.
        if (quantiteProduit < 1) {
            mapPanier.remove(produitAjout);
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
        // on met � jour le nombre de r�f�rence dans le panier.
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
            // il est n�cessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
            // afin qu'il corresponde au format Double et qu'on puisse faire des op�rations dessus
            prixTotal += DecimalFormatUtils.doubleFormatUtil(ligne.getPrix());
        }
        return DecimalFormatUtils.decimalFormatUtil(prixTotal);
    }

    @Override
    public void appliquerRemise(final PanierDto panier) {
        // il est n�cessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
        // afin qu'il corresponde au format Double et qu'on puisse faire des op�rations dessus
        final var prixTotal = DecimalFormatUtils.doubleFormatUtil(panier.getPrixTotal());
        // s'il y a 5 r�f�rences ou plus dans le panier et que son prix total est sup�rieur ou �gal
        // � 2000�, alors on applique une remise de 5%
        if (panier.getNombreDeReferences() >= 5 && prixTotal >= 2000.00) {
            panier.setRemise(DecimalFormatUtils.decimalFormatUtil(prixTotal / 20));
            // il est n�cessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
            // afin qu'il corresponde au format Double et qu'on puisse faire des op�rations dessus
            panier.setPrixApresRemise(
                    DecimalFormatUtils.decimalFormatUtil(prixTotal - DecimalFormatUtils.doubleFormatUtil(panier.getRemise())));
            // sinon, la remise vaut 0 et le prix apr�s remise est le prix total du panier
        } else {
            panier.setRemise("0");
            panier.setPrixApresRemise(panier.getPrixTotal());
        }
    }

}
