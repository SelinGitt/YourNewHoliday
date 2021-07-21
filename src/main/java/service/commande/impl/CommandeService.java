/**
 * 
 */
package service.commande.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import persistance.commande.dao.IProduitAcheteDao;
import persistance.commande.entity.CommandeDo;
import persistance.commande.entity.CommandeProduitDo;
import persistance.produit.dao.IProduitDao;
import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.CommandeDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.commande.CommandeMapper;
import service.commande.ICommandeService;
import service.util.IGenerateReferenceUtil;

/**
 * Classe représentant l'implémentation des services pour les commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommandeService implements ICommandeService {

    private final Logger           logger = LoggerFactory.getLogger(CommandeService.class);

    @Autowired
    @Qualifier("CMD")
    private IGenerateReferenceUtil referenceCommande;

    @Autowired
    private ICommandeDao           iCommandeDao;

    @Autowired
    private IProduitDao            iProduitDao;

    @Autowired
    private IProduitAcheteDao      iProduitAchete;

    @Override
    public List<CommandeDto> listerCommandesUtilisateur(final Integer idUser) {
        logger.info("la liste  des commandes utilisateur avec  idUser {}", idUser);
        return CommandeMapper.mapperListDoToDto(this.iCommandeDao.findByUserId(idUser));
    }

    @Override
    public CommandeDto chercherCommandeParReference(final String reference) {
        logger.info("Recherche de la commande avec la réference {}", reference);
        return CommandeMapper.mapperToDto(iCommandeDao.findByRef(reference));
    }

    @Override
    public List<Integer> verifierProduitsAvecVersion(final Map<ProduitDto, LigneCommandeProduitDto> produitsPanier) {
        final List<Integer> listProduitEnErreur = new ArrayList<>();
        for (final ProduitDto produit : produitsPanier.keySet()) {
            final Integer idProduit = Integer.parseInt(produit.getIdProduitOriginal());
            if (this.iProduitDao.findProduitEnVenteAvecVersion(idProduit, Integer.parseInt(produit.getVersion())) == null) {
                listProduitEnErreur.add(idProduit);
            }
        }
        return listProduitEnErreur;
    }

    @Override
    public CommandeDto validerPanier(final PanierDto panier, final AdressesDto adresses, final Integer idUtilisateur) {
        String reference = null;
        do {
            reference = this.referenceCommande.generateReference();
            // Passer les adresses à la méthode
        } while (this.iCommandeDao.isCommandeExist(reference));
        // Passer les adresses à la méthode
        logger.info("Création de commande avec la réference {}", reference);
        return CommandeMapper.mapperToDto(this.iCommandeDao.create(
                this.recupereProduitAchetePourCommande(CommandeMapper.mapperPanierDtoToDo(panier, adresses, reference, idUtilisateur))));
    }

    /**
     * Permet de mettre les produits achetés déjà en base dans la commande
     *
     * @param  commande la commande à persister
     * @return          CommandeDo la commande avec les produits acheté en base si ils ont déjà été enregistré
     */
    private CommandeDo recupereProduitAchetePourCommande(final CommandeDo commande) {
        for (final CommandeProduitDo commandeProduit : commande.getCommandeProduitDoSet()) {
            final var produitAcheteDo = commandeProduit.getProduitAcheteDo();
            final var produitAcheteDoEnBase = this.iProduitAchete.recupererProduitAcheteDo(produitAcheteDo.getIdDeLOriginal(),
                    produitAcheteDo.getVersion());
            if (produitAcheteDoEnBase != null) {
                commandeProduit.setProduitAcheteDo(produitAcheteDoEnBase);
                logger.info("Produit {} de référence {} déjà en base.", produitAcheteDo.getIdDeLOriginal(), produitAcheteDo.getVersion());
            }
        }
        return commande;
    }
}
