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
 * Classe repr�sentant l'interface m�tier {@link IPanierService}
 *
 * @author NathanR
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PanierService implements IPanierService {

    /**
     * Permet de d�terminer le pourcentage de la remise que l'on souhaite appliquer lorsque les conditions sont respect�es.
     */
    private static final int    POURCENTAGE_REMISE                    = 5;
    /**
     * Permet de d�terminer le prix total minimum que doit faire le panier pour que la remise soit appliqu�e. <br />
     * (� condition de respecter aussi les autres cri�tres)
     */
    private static final double PRIX_TOTAL_MINIMUM_POUR_REMISE        = 10000.00;
    /**
     * Permet de d�terminer le nombre de r�f�rences minimum que doit contenir le panier pour que la remise soit appliqu�e.
     * <br />
     * (� condition de respecter aussi les autres cri�tres)
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
            final var prixString = produitAjout.getPrixUnitaire();
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
    public boolean isRemiseExpected(final PanierDto panier) {
        // s'il y a sufisamment de r�f�rences dans le panier et que le prix total est sup�rieur ou �gal
        // au minimum impos�, alors la remise est applicable.
        return panier.getNombreDeReferences() >= NOMBRE_REFERENCES_MINIMUM_POUR_REMISE
                && DecimalFormatUtils.doubleFormatUtil(panier.getPrixTotalAffichage()) >= PRIX_TOTAL_MINIMUM_POUR_REMISE;
    }

    @Override
    public void actualiserPrix(final PanierDto panier) {
        final var prixTotal = calculerPrixTotal(panier);
        // (il est n�cessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
        // afin qu'il corresponde au format Double et qu'on puisse faire des op�rations dessus)
        final var prixTotalAffichage = DecimalFormatUtils.doubleFormatUtil(prixTotal);
        // on actualise le prix total du panier
        panier.setPrixTotalAffichage(prixTotal);
        // si la remise est applicable...
        if (isRemiseExpected(panier)) {
            // ... alors on actualise la valeur de la remise en fonction du pourcentage fix� en constante
            panier.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(prixTotalAffichage * POURCENTAGE_REMISE / 100));
            // (il est n�cessaire de reformater le prix pour qu'il n'y ait plus d'espace ni de virgule
            // afin qu'il corresponde au format Double et qu'on puisse faire des op�rations dessus)
            // on actualise aussi de fait le prix apr�s remise
            panier.setPrixApresRemiseAffichage(DecimalFormatUtils
                    .decimalFormatUtil(prixTotalAffichage - DecimalFormatUtils.doubleFormatUtil(panier.getRemiseAffichage())));
            // sinon, la remise vaut 0 et le prix apr�s remise est le prix total du panier
        } else {
            panier.setRemiseAffichage(DecimalFormatUtils.decimalFormatUtil(0.00));
            panier.setPrixApresRemiseAffichage(panier.getPrixTotalAffichage());

        }
    }

    @Override
    public boolean modifierQuantite(final PanierDto panier, final Integer idProduit, final int modif) {
        // On teste si le produit est conforme � la modification
        if (isProduitConforme(idProduit)) {
            // On r�cup�re le produit
            final ProduitDto produit = findProduitMap(panier, idProduit);

            // On r�cup�re la quantit� avant modification
            final Integer quantiteInitiale = panier.getMapPanier().get(produit).getQuantite();

            // On teste aussi les valeurs � modifier avant de modifier
            if (isModificationAutorisee(modif, quantiteInitiale)) {
                updatePanier(panier, idProduit, modif);
            }
            return true;
        }
        return false;
    }

    /**
     * <Pre>
     * Permets de d�terminer si le produit peut �tre modifi�, Pour cela il doit : - toujours �tre en vente - ne pas avoir
     * �t� modifi� par un admin (controle du num�ro de version
     *
     * @param  id du produit � v�rifier
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
     * Permets de v�rifier si les conditions necessaires � la modification
     * de la quantit� d'une produit du panier sont r�unies :
     * - le r�sultat apr�s d�cr�ment doit �tre > 0
     * - le r�sultat apr�s incr�ment doit �tre < = 100
     * </pre>
     * 
     * @param  modif            valeur d'incr�ment
     * @param  quantiteInitiale du produit dans le panier
     * @return                  true si c'est ok, false sinon.
     */
    private boolean isModificationAutorisee(final int modif, final int quantiteInitiale) {
        // d�cr�ment
        if (modif == -1) {
            // On autorise le d�cr�ment uniquement si le r�sultat > 0
            // pour supprimer un produit du panier
            // l'utilisateur doit utiliser la corbeille.
            return quantiteInitiale > 1;
        }
        // incr�ment 
        if (modif == 1) {
            // On autorise l'incr�ment uniquement si le r�sultat <= 100
            return quantiteInitiale < 100;
        }
        // On attends pas d'autre valeur 
        return false;
    }

    @Override
    public RetourValiderPanierDto validerPanier(final PanierDto panier, final AdressesDto adresses, final Integer idUtilisateur) {
        final var utilisateur = this.iUtilisateurService.findUtilisateurById(idUtilisateur);
        if (null == utilisateur) {
            logger.warn("Utilisateur effac� {}", idUtilisateur);
            return null;
        }
        final var retourValiderPanier = new RetourValiderPanierDto();
        retourValiderPanier.setListIdProduitNonConcordant(this.iCommandeService.verifierProduitsAvecVersion(panier.getMapPanier()));
        if (retourValiderPanier.getListIdProduitNonConcordant().isEmpty()) {
            final var commandeDoReference = this.iCommandeService.validerPanier(panier, adresses, utilisateur);
            retourValiderPanier.setReference(commandeDoReference);
            this.viderPanier(panier);
            logger.info("Commande de r�f�rence {} pass�e avec succ�s.", commandeDoReference);
        }
        logger.info("Fin de validation Commande avec {} produits non concordant.",
                retourValiderPanier.getListIdProduitNonConcordant().size());
        return retourValiderPanier;
    }
}
