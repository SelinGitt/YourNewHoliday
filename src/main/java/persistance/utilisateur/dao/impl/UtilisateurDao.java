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
    public boolean deleteUtilisateurById(final Integer id) {
        try {
            entityManager.remove(entityManager.getReference(UtilisateurDo.class, id));
            logger.info("L'utilisateur d'id {} a �t� supprim�", id);
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

    @Override
    public boolean isLastAdmin(final Integer idRole) {
        final var result = (1 == rechercheNombreParRole(3) && (3 == idRole));
        logger.debug("Cet utilisateur est le dernier administrateur : {}", result);
        return result;
    }

    /**
     * Permet de renvoyer le nombre d'utilisateur d'un r�le donn�e en le passant en param�tre
     *
     * @param  rang : rang de l'utilisateur
     * @return      : un int le nombre d'utilisateurs ayant ce r�le
     */
    private int rechercheNombreParRole(final Integer rang) {
        final TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(idRole) From UtilisateurDo WHERE idRole LIKE :searchTerm",
                Long.class);
        query.setParameter("searchTerm", "%" + rang + "%");
        final var result = query.getSingleResult().intValue();
        logger.debug("Nombre d'administrateurs restant : {}", result);
        return result;
    }
}
