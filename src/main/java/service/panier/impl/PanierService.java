/**
 * 
 */
package service.panier.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.RetourValiderPanierDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.commande.ICommandeService;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.util.DecimalFormatUtils;
import service.utilisateur.IUtilisateurService;

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

    private final Logger        logger                                = LoggerFactory.getLogger(PanierService.class);

    @Autowired
    private IProduitService     iProduitService;

    @Autowired
    private ICommandeService    iCommandeService;

    @Autowired
    private IUtilisateurService iUtilisateurService;

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
            final var prixString = produitAjout.getPrixUnitaire();
            final var prixUnitaire = DecimalFormatUtils.doubleFormatUtil(prixString);
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
    public boolean isRemiseExpected(final PanierDto panier) {
        // s'il y a sufisamment de références dans le panier et que le prix total est supérieur ou égal
        // au minimum imposé, alors la remise est applicable.
        return panier.getNombreDeReferences() >= NOMBRE_REFERENCES_MINIMUM_POUR_REMISE
                && DecimalFormatUtils.doubleFormatUtil(panier.getPrixTotalAffichage()) >= PRIX_TOTAL_MINIMUM_POUR_REMISE;
    }

    @Override
    public void actualiserPrix(final PanierDto panier) {
        final var prixTotal = calculerPrixTotal(panier);
        // (il est nécessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
        // afin qu'il corresponde au format Double et qu'on puisse faire des opérations dessus)
        final var prixTotalAffichage = DecimalFormatUtils.doubleFormatUtil(prixTotal);
        // on actualise le prix total du panier
        panier.setPrixTotalAffichage(prixTotal);
        // si la remise est applicable...
        if (isRemiseExpected(panier)) {
            // ... alors on actualise la valeur de la remise en fonction du pourcentage fixé en constante
            panier.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(prixTotalAffichage * POURCENTAGE_REMISE / 100));
            // (il est nécessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
            // afin qu'il corresponde au format Double et qu'on puisse faire des opérations dessus)
            // on actualise aussi de fait le prix après remise
            panier.setPrixApresRemiseAffichage(DecimalFormatUtils
                    .decimalFormatUtil(prixTotalAffichage - DecimalFormatUtils.doubleFormatUtil(panier.getRemiseAffichage())));
            // sinon, la remise vaut 0 et le prix après remise est le prix total du panier
        } else {
            panier.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(0.00));
            panier.setPrixApresRemiseAffichage(panier.getPrixTotalAffichage());

        }
    }

    @Override
    public boolean modifierQuantite(final PanierDto panier, final Integer idProduit, final int modif) {
        // On teste si le produit est conforme à la modification
        if (isProduitConforme(idProduit)) {
            // On récupère le produit
            final ProduitDto produit = findProduitMap(panier, idProduit);

            // On récupère la quantité avant modification
            final Integer quantiteInitiale = panier.getMapPanier().get(produit).getQuantite();

            // On teste aussi les valeurs à modifier avant de modifier
            if (isModificationAutorisee(modif, quantiteInitiale)) {
                updatePanier(panier, idProduit, modif);
            }
            return true;
        }
        return false;
    }

    /**
     * <Pre>
     * Permets de déterminer si le produit peut être modifié, Pour cela il doit : - toujours être en vente - ne pas avoir
     * été modifié par un admin (controle du numéro de version
     *
     * @param  id du produit à vérifier
     * @return    true si le produit est conforme, false sinon.
     */
    private boolean isProduitConforme(final Integer id) {
        final ProduitDto produitEnvente = iProduitService.trouverProduitEnVente(id);
        if (produitEnvente == null) {
            return false;
        }
        // TODO : controle de la version. (ISSUES 295)
        return true;
    }

    /**
     * <pre>
     * Permets de vérifier si les conditions necessaires à la modification
     * de la quantité d'une produit du panier sont réunies :
     * - le résultat après décrément doit être > 0
     * - le résultat après incrément doit être < = 100
     * </pre>
     * 
     * @param  modif            valeur d'incrément
     * @param  quantiteInitiale du produit dans le panier
     * @return                  true si c'est ok, false sinon.
     */
    private boolean isModificationAutorisee(final int modif, final int quantiteInitiale) {
        // décrément
        if (modif == -1) {
            // On autorise le décrément uniquement si le résultat > 0
            // pour supprimer un produit du panier
            // l'utilisateur doit utiliser la corbeille.
            return quantiteInitiale > 1;
        }
        // incrément 
        if (modif == 1) {
            // On autorise l'incrément uniquement si le résultat <= 100
            return quantiteInitiale < 100;
        }
        // On attends pas d'autre valeur 
        return false;
    }

    @Override
    public RetourValiderPanierDto validerPanier(final PanierDto panier, final AdressesDto adresses, final Integer idUtilisateur) {
        final var utilisateur = this.iUtilisateurService.findUtilisateurById(idUtilisateur);
        if (null == utilisateur) {
            logger.warn("Utilisateur effacé {}", idUtilisateur);
            return null;
        }
        final var retourValiderPanier = new RetourValiderPanierDto();
        retourValiderPanier.setListIdProduitNonConcordant(this.iCommandeService.verifierProduitsAvecVersion(panier.getMapPanier()));
        if (retourValiderPanier.getListIdProduitNonConcordant().isEmpty()) {
            final var commandeDoReference = this.iCommandeService.validerPanier(panier, adresses, utilisateur);
            retourValiderPanier.setReference(commandeDoReference);
            this.viderPanier(panier);
            logger.info("Commande de référence {} passée avec succès.", commandeDoReference);
        }
        logger.info("Fin de validation Commande avec {} produits non concordant.",
                retourValiderPanier.getListIdProduitNonConcordant().size());
        return retourValiderPanier;
    }
}
