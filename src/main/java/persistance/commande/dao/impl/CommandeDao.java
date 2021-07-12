/**
 * 
 */
package persistance.commande.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
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
        // creation du "order by" date
        allWhere.orderBy(criteriaBuilder.desc(rootEntry.get("date")));
        final TypedQuery<CommandeDo> allQuery = this.entityManager.createQuery(allWhere);
        // on fournit � la requ�te la valeur du param�tre que l'on cherche
        allQuery.setParameter(parameter, userId);
        // ajout du message pour le debug
        this.logger.debug("findByUserID {} ", userId);
        return allQuery.getResultList();
    }

    @Override
    public CommandeDo findByRef(final String reference) {
        System.out.println("ref : " + reference);
        // Le Inner Join Fetch nous permet de faire la requ�te JPQL en une seule requ�te SQL et de r�cup�rer toutes les valeurs
        // des attributs des tables bien qu'on soit en FetchType.LAZY.
        final var request = new StringBuilder("SELECT c FROM CommandeDo c");
        request.append(" INNER JOIN FETCH c.commandeProduitDoSet cp");
        request.append(" INNER JOIN FETCH cp.produitAcheteDo p");
        request.append(" WHERE c.reference = :reference");
        final TypedQuery<CommandeDo> query = entityManager.createQuery(request.toString(), CommandeDo.class);
        query.setParameter("reference", reference);

        logger.info("Recherche la commande avec le r�f�rence {} en base de donn�es.", reference);
        try {
            return query.getSingleResult();
        } catch (final NoResultException exception) {
            logger.info("Pas de r�f�rence : {} ", exception.getMessage());
            return null;
        }
    }

    //M�thode utilis�e � la suppression d'un utilisateur
    @Override
    public void updateCommandeDoUserDeletion(final Integer idUtilisateur) {
        //on r�cup�re la liste des commandes de l'utilisateur � supprimer
        final List<CommandeDo> listeCommande = findByUserId(idUtilisateur);
        logger.info("L'utilisateur d'id {} poss�de {} commande(s) lui �tant rattach�e(s)", idUtilisateur, listeCommande.size());
        //on passe tous les idUtilisateur de ces commandes � NULL
        for (final CommandeDo commande : listeCommande) {
            logger.info("La commande d'id {} a �t� d�tach�e de l'utilisateur d'id {}", commande.getId(), idUtilisateur);
            commande.setIdUtilisateur(null);
            entityManager.merge(commande);
        }
    }
}
