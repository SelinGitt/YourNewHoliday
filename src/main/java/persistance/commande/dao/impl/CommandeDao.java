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
 * Classe représentant l'implémentation des requètes sur la base de données spécifiques aux commandes
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
    public List<CommandeDo> findByUserId(final Integer userId) {
        // la requête findByUserID avec un critère
        final var criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<CommandeDo> criteriaQuery = criteriaBuilder.createQuery(CommandeDo.class);
        final Root<CommandeDo> rootEntry = criteriaQuery.from(CommandeDo.class);
        final CriteriaQuery<CommandeDo> allCriteria = criteriaQuery.select(rootEntry);
        // on indique le type de paramètre que l'on veut chercher
        final ParameterExpression<Integer> parameter = criteriaBuilder.parameter(Integer.class);
        // on crée la clause where avec le paramètre
        final CriteriaQuery<CommandeDo> allWhere = allCriteria.where(criteriaBuilder.equal(rootEntry.get("idUtilisateur"), parameter));
        // creation du "order by" date
        allWhere.orderBy(criteriaBuilder.desc(rootEntry.get("date")));
        final TypedQuery<CommandeDo> allQuery = this.entityManager.createQuery(allWhere);
        // on fournit à la requête la valeur du paramètre que l'on cherche
        allQuery.setParameter(parameter, userId);
        // ajout du message pour le debug
        this.logger.debug("findByUserID {} ", userId);
        return allQuery.getResultList();
    }

    @Override
    public CommandeDo findByRef(final String reference) {
        // Le Inner Join Fetch nous permet de faire la requête JPQL en une seule requête SQL et de récupérer toutes les valeurs
        // des attributs des tables bien qu'on soit en FetchType.LAZY.
        final TypedQuery<CommandeDo> query = entityManager.createQuery(
                "select c from CommandeDo c Inner join Fetch c.commandeProduitDoSet cp Inner Join Fetch cp.produitAcheteDo p where c.reference=:reference ",
                CommandeDo.class);
        query.setParameter("reference", reference);

        logger.info("commande avec le reference {} non trouvé en base de données.", reference);

        return query.getSingleResult();

    }

}
