/**
 * 
 */
package persistance.commande.dao;

import java.util.List;

import persistance.commande.entity.CommandeDo;
import persistance.commun.dao.IGenericDao;

/**
 * Interface pour implémenter le CRUD et les fonctionnalités spécifiques aux commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface ICommandeDao extends IGenericDao<CommandeDo> {

    /**
     * Permet de retourner la liste des commandes d'un utilisateurs
     *
     * @param  userId l'identifiant de l'utilisateur
     * @return        List<CommandeDo> la liste des commandes trouvées
     */
    List<CommandeDo> findByUserId(final Integer userId);

}
