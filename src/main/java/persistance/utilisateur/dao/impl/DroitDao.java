/**
 * 
 */
package persistance.utilisateur.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

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

    @Override
    public List<String> findRole(final DroitDo droit) {
        final TypedQuery<String> query = entityManager.createQuery(
                "SELECT r.libelle FROM RoleDo r, DroitDo d, PossedeDo p WHERE d.id = p.droit.idDroit AND p.role.idRole = r.id AND d.url = :urlDroit",
                String.class);
        query.setParameter("urlDroit", droit.getUrl());

        return query.getResultList();
    }
}
