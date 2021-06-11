/**
 * 
 */
package service.commande.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import persistance.commande.entity.CommandeDo;
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

    /**
     * pour inverser l'odre de comparaison des dates
     */
    private static final int INVERSE_ORDRE = -1;

    private final Logger     logger        = LoggerFactory.getLogger(CommandeService.class);
    @Autowired
    private ICommandeDao     iCommandeDao;

    @Override
    public List<CommandeDto> listerCommandesUtilisateur(final Integer idUser) {
        logger.info("la liste  des commandes utilisateur avec  idUser {}", idUser);
        final List<CommandeDo> listCommandeDo = this.iCommandeDao.findByUserId(idUser);
        this.trierCommande(listCommandeDo);
        return CommandeMapper.mapperListDoToDto(listCommandeDo);
    }

    /**
     * Permet de trier une liste de CommandeDo à partir des dates dans l'ordre antéchronologie
     *
     * @param listCommandeDo la liste à trier
     */
    private void trierCommande(final List<CommandeDo> listCommandeDo) {
        Collections.sort(listCommandeDo, new Comparator<CommandeDo>() {
            @Override
            public int compare(final CommandeDo commande1, final CommandeDo commande2) {
                return INVERSE_ORDRE * commande1.getDate().compareTo(commande2.getDate());
            }
        });
    }

}
