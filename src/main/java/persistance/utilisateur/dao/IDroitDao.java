/**
 * 
 */
package persistance.utilisateur.dao;

import java.util.List;

import persistance.commun.dao.IGenericDao;
import persistance.utilisateur.entity.DroitDo;

/**
 * Interface IDroitDao
 *
 * @author Valentin
 */
public interface IDroitDao extends IGenericDao<DroitDo> {

    /**
     * Permet de trouver les roles lie a un droit
     *
     * @param  droit Droit ou il faut trouver les roles
     * @return       List des libelle des roles
     */
    List<String> findRole(final DroitDo droit);
}
