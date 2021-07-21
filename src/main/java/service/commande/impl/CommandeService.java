/**
 * 
 */
package service.commande.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import presentation.commande.dto.CommandeDto;
import service.commande.CommandeMapper;
import service.commande.ICommandeService;

/**
 * Classe représentant l'implémentation des services pour les commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommandeService implements ICommandeService {

    private final Logger logger = LoggerFactory.getLogger(CommandeService.class);
    @Autowired
    private ICommandeDao iCommandeDao;

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

}
