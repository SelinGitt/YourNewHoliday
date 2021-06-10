package persistance.utilisateur.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commun.dao.impl.AbstractGenericDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.UtilisateurDo;

/**
 * Classe UtilisateurDao
 *
 * @author Valentin
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UtilisateurDao extends AbstractGenericDao<UtilisateurDo> implements IUtilisateurDao {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurDao.class);

    /**
     * Constructeur par défaut
     */
    public UtilisateurDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour récupérer la classe de l'entité.
        super(UtilisateurDo.class);
    }

    @Override
    public UtilisateurDo findByEmail(final String email) {
        final TypedQuery<UtilisateurDo> query = entityManager.createQuery("select util from UtilisateurDo util where util.email = :email",
                UtilisateurDo.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (final NoResultException exception) {
            logger.info("Utilisateur avec l'email {} non trouvé en base de données.", email, exception);
            return null;
        }
    }
}
