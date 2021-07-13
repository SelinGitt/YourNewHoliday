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
import persistance.commande.entity.CommandeDo;
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

    // TODO ajouter List<CommandeAdresseDto> 
    @Override
    public CommandeDo passerCommande(final PanierDto panier, final AdressesDto adresses, final Integer idUtilisateur) {
        String reference = null;
        do {
            reference = this.referenceCommande.generateReference();
            // Passer les adresses à la méthode
        } while (this.iCommandeDao.findByRef(reference) != null);
        // Passer les adresses à la méthode
        return this.iCommandeDao.create(CommandeMapper.mapperPanierDtoToDo(panier, adresses, reference, idUtilisateur));
    }

}
