/**
 * 
 */
package persistance.commande.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import persistance.commande.entity.CommandeDo;
import persistance.commun.dao.impl.AbstractGenericDao;

/**
 * Classe représentant l'implémentation des requètes sur la base de données spécifiques aux commandes
 *
 * @author Ilitsivery Jacques MADIOMANANA
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CommandeDao extends AbstractGenericDao<CommandeDo> implements ICommandeDao {

    /**
     * Constructeur
     */
    public CommandeDao() {
        super(CommandeDo.class);
    }

    @Override
    public CommandeDo findByRef(final String reference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CommandeDo> findByUserId(final Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

}
