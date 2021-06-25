package persistance.utilisateur.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public boolean deleteUtilisateurById(final Integer id) {
        try {
            entityManager.remove(entityManager.getReference(UtilisateurDo.class, id));
            return true;
        } catch (final EntityNotFoundException exception) {
            logger.error("Erreur lors de la suppression de l'utilisateur id {}.", id, exception);
            return false;
        }
    }

    @Override
    public List<UtilisateurDo> recherche(final String nom) {
        logger.debug("DAO Rechercher par nom : {}", nom);
        final TypedQuery<UtilisateurDo> query = entityManager.createQuery("From UtilisateurDo WHERE nom LIKE :searchTerm",
                UtilisateurDo.class);
        query.setParameter("searchTerm", "%" + nom + "%");
        return query.getResultList();
    }

    @Override
    public int rechercheNombreParRole(final Integer rang) {
        final TypedQuery<UtilisateurDo> query = entityManager.createQuery("From UtilisateurDo WHERE idRole LIKE :searchTerm",
                UtilisateurDo.class);
        query.setParameter("searchTerm", "%" + rang + "%");
        return query.getResultList().size();
    }

    @Override
    public List<UtilisateurDo> rechercheRole(final Integer idRole) {
        logger.debug("DAO Recherche par idRole : {}", idRole);
        final TypedQuery<UtilisateurDo> query = entityManager.createQuery("From UtilisateurDo WHERE idRole = :searchFilter",
                UtilisateurDo.class);
        query.setParameter("searchFilter", idRole);
        return query.getResultList();
    }

    @Override
    public List<UtilisateurDo> rechercheNomRole(final String nom, final Integer idRole) {
        logger.debug("DAO Recherche par nom et idRole; {} / {}", nom, idRole);
        final TypedQuery<UtilisateurDo> query = entityManager
                .createQuery("From UtilisateurDo WHERE nom LIKE :searchTerm AND idRole = :searchFilter", UtilisateurDo.class);
        query.setParameter("searchTerm", "%" + nom + "%");
        query.setParameter("searchFilter", idRole);
        return query.getResultList();
    }
}
