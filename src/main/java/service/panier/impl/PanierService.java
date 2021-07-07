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
            final String prixString = produitAjout.getPrixUnitaire();
            final var prixUnitaire = DecimalFormatUtils.doubleFormatUtil(prixString);
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
    public void modifierQuantite(final PanierDto panier, final Integer idProduit, final int modif) {
        // On r�cup�re le produit
        final ProduitDto produit = findProduitMap(panier, idProduit);
        // On r�cup�re la quantit� avant modification
        final Integer quantiteInitiale = panier.getMapPanier().get(produit).getQuantite();

        if (modificationAutorisee(modif, quantiteInitiale)) {
            updatePanier(panier, idProduit, modif);
        }
    }

    /**
     * Permets de v�rifier si les conditions necessaires � la modification de la quantit� d'une produit du panier sont
     * r�unies
     *
     * @param  modif            valeur d'incr�ment
     * @param  quantiteInitiale du produit dans le panier
     * @return                  true si c'est ok, false sinon.
     */
    private boolean modificationAutorisee(final int modif, final int quantiteInitiale) {
        var regleUne = true;
        var regleDeux = true;
        // D�cr�ment
        if (modif == -1) {
            // On autorise le d�cr�ment uniquement si le r�sultat > 0
            // pour supprimer un produit du panier
            // l'utilisateur doit utiliser la corbeille.
            regleUne = quantiteInitiale > 1;
        } else {
            // Incr�ment
            if (modif == 1) {
                // On autorise l'incr�ment uniquement si le r�sultat <= 100
                regleDeux = quantiteInitiale < 100;
            } else {
                // On attends pas d'autre valeur 
                return false;
            }
        }
        return (regleUne && regleDeux);
    }
}
