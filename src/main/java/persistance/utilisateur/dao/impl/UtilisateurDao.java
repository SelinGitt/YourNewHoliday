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
     * Constructeur par d�faut
     */
    public UtilisateurDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour r�cup�rer la classe de l'entit�.
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
            logger.info("Utilisateur avec l'email {} non trouv� en base de donn�es.", email, exception);
            return null;
        }
    }

    @Override
    public List<UtilisateurDo> recherche(final String nom) {
        final TypedQuery<UtilisateurDo> query = entityManager.createQuery("From UtilisateurDo WHERE nom LIKE :searchTerm",
                UtilisateurDo.class);
        query.setParameter("searchTerm", "%" + nom + "%");
        return query.getResultList();
    }

    @Override
    public List<UtilisateurDo> rechercheRole(final String role) {
        final TypedQuery<UtilisateurDo> query = entityManager.createQuery("From UtilisateurDo WHERE idRole LIKE :searchFilter",
                UtilisateurDo.class);
        query.setParameter("searchFilter", role);
        return query.getResultList();
    }

    @Override
    public List<UtilisateurDo> rechercheNomRole(final String nom, final String role) {
        final TypedQuery<UtilisateurDo> query = entityManager
                .createQuery("From UtilisateurDo WHERE nom LIKE :searchTerm AND idRole LIKE :searchFilter", UtilisateurDo.class);
        query.setParameter("searchTerm", "%" + nom + "%");
        query.setParameter("searchFilter", role);
        return query.getResultList();
    }
}
