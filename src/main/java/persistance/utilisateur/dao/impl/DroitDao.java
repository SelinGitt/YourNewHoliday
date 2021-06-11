/**
 * 
 */
package persistance.utilisateur.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DroitDao.class);

    /**
     * Constructeur par défaut
     */
    public DroitDao() {
        // on utilise le constructeur de la superclass avec DroitDo.class pour récupérer la classe de l'entité.
        super(DroitDo.class);
    }

    @Override
    public List<String> findRole(final DroitDo droit) {
        final TypedQuery<String> query = entityManager
                .createQuery("SELECT r.libelle FROM RoleDo r, DroitDo d WHERE d.url LIKE '" + droit.getUrl() + "'", String.class);
        try {
            return query.getResultList();
        } catch (final NoResultException exception) {
            logger.info("Pas de droits pour {}", droit.getUrl(), exception);
            return null;
        }
    }
}
