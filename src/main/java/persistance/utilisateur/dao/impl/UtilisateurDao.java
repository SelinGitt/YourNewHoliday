package persistance.utilisateur.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commun.dao.impl.AbstractGenericDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.UtilisateurDo;
import pocLogBack.POCLogBack;

/**
 * Classe UtilisateurDo
 *
 * @author Valentin
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UtilisateurDao extends AbstractGenericDao<UtilisateurDo> implements IUtilisateurDao {

    static final Logger logger = LoggerFactory.getLogger(POCLogBack.class);

    /**
     * Constructeur par d�faut
     */
    public UtilisateurDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour r�cup�rer la classe de l'entit�.
        super(UtilisateurDo.class);
    }

    @Override
    public UtilisateurDo findByEmail(final String email) {
        final Query query = entityManager.createQuery("select util from UtilisateurDo util where util.email = :email", UtilisateurDo.class);
        query.setParameter("email", email);
        try {
            final UtilisateurDo utilisateurDo = (UtilisateurDo) query.getSingleResult();
            return utilisateurDo;
        } catch (final NoResultException exception) {
            logger.warn("Utilisateur avec l'email {} non trouv� en base.", email, exception);
            return null;
        }
    }
}
