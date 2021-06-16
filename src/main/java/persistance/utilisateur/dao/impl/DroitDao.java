/**
 * 
 */
package persistance.utilisateur.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commun.dao.impl.AbstractGenericDao;
import persistance.utilisateur.dao.IDroitDao;
import persistance.utilisateur.entity.DroitDo;

/**
 * Classe DroitDao
 *
 * @author Valentin
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class DroitDao extends AbstractGenericDao<DroitDo> implements IDroitDao {

    /**
     * Constructeur par défaut
     */
    public DroitDao() {
        // on utilise le constructeur de la superclass avec DroitDo.class pour récupérer la classe de l'entité.
        super(DroitDo.class);
    }
}
