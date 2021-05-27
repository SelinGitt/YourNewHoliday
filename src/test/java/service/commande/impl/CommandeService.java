/**
 * 
 */
package service.commande.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.commande.dao.ICommandeDao;
import presentation.commande.dto.CommandeDto;
import service.commande.ICommandeService;

/**
 * Classe représentant l'implémentation des services pour les commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Service
public class CommandeService implements ICommandeService {

    private final Logger logger = LoggerFactory.getLogger(CommandeService.class);

    @Autowired
    private ICommandeDao iCommandeDao;

    @Override
    public CommandeDto trouverCommandeParReference(String reference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CommandeDto> listerCommandesUtilisateur(Integer idUser) {
        // TODO Auto-generated method stub
        return null;
    }

}
