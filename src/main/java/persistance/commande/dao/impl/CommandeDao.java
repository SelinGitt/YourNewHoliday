/**
 * 
 */
package persistance.commande.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import persistance.commande.entity.CommandeDo;
import persistance.commun.dao.impl.AbstractGenericDao;

/**
 * Classe repr�sentant l'impl�mentation des requ�tes sur la base de donn�es sp�cifiques aux commandes
 *
 * @author Ilitsivery Jacques MADIOMANANA
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CommandeDao extends AbstractGenericDao<CommandeDo> implements ICommandeDao {

    private final Logger logger = LoggerFactory.getLogger(CommandeDao.class);

    /**
     * Constructeur
     */
    public CommandeDao() {
        super(CommandeDo.class);
    }

    @Override
    public CommandeDo findByRef(final String reference) {
        // la requ�te findByRef avec un crit�re
        final var criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<CommandeDo> criteriaQuery = criteriaBuilder.createQuery(CommandeDo.class);
        final Root<CommandeDo> rootEntry = criteriaQuery.from(CommandeDo.class);
        final CriteriaQuery<CommandeDo> allCriteria = criteriaQuery.select(rootEntry);
        // on indique le type de param�tre que l'on veut chercher
        final ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        // on cr�e la clause where avec le param�tre
        final CriteriaQuery<CommandeDo> allWhere = allCriteria.where(criteriaBuilder.equal(rootEntry.get("reference"), parameter));
        final TypedQuery<CommandeDo> allQuery = this.entityManager.createQuery(allWhere);
        // on fournit � la requ�te la valeur du param�tre que l'on cherche
        allQuery.setParameter(parameter, reference);
        // ajout du message pour le debug
        this.logger.debug("findByRef {} ", reference);
        return allQuery.getSingleResult();
    }

    @Override
    public List<CommandeDo> findByUserId(final Integer userId) {
        // la requ�te findByUserID avec un crit�re
        final var criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<CommandeDo> criteriaQuery = criteriaBuilder.createQuery(CommandeDo.class);
        final Root<CommandeDo> rootEntry = criteriaQuery.from(CommandeDo.class);
        final CriteriaQuery<CommandeDo> allCriteria = criteriaQuery.select(rootEntry);
        // on indique le type de param�tre que l'on veut chercher
        final ParameterExpression<Integer> parameter = criteriaBuilder.parameter(Integer.class);
        // on cr�e la clause where avec le param�tre
        final CriteriaQuery<CommandeDo> allWhere = allCriteria.where(criteriaBuilder.equal(rootEntry.get("idUtilisateur"), parameter));
        final TypedQuery<CommandeDo> allQuery = this.entityManager.createQuery(allWhere);
        // on fournit � la requ�te la valeur du param�tre que l'on cherche
        allQuery.setParameter(parameter, userId);
        // ajout du message pour le debug
        this.logger.debug("findByUserID {} ", userId);
        return allQuery.getResultList();
    }

}
