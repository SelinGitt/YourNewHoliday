/**
 * 
 */
package persistance.commun.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commun.dao.IGenericDao;

/**
 * Classe implémentant IGenericDao
 *
 * @author     Ilaitsivery Jacques MADIOMANANA
 * @param  <T> Le type à utiliser pour la classe
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public abstract class AbstractGenericDao<T> implements IGenericDao<T> {

    // insertion du logger pour ajouter le logg des requêtes sql dans le fichier
    private final Logger    logger = LoggerFactory.getLogger(AbstractGenericDao.class);

    // l'entityManager instancier par spring sous forme de beanSpring
    @PersistenceContext(unitName = "puYnh")
    protected EntityManager entityManager;

    // le type de l'objet sur le quelle on fait le CRUD
    /**
     * Il faut stocker le type de la classe générique
     */
    private Class<T>        entiteClass;

    /**
     * Constructeur par défaut
     */
    protected AbstractGenericDao() {
        super();
    }

    /**
     * Constructeur paramétré
     *
     * @param entiteClass le type de l'objet sur lequel on va effectuer le CRUD
     */
    protected AbstractGenericDao(final Class<T> entiteClass) {
        super();
        this.entiteClass = entiteClass;
    }

    @Override
    public List<T> findAll() {
        // la requête findAll avec un critère
        final var criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entiteClass);
        final Root<T> rootEntry = criteriaQuery.from(this.entiteClass);
        final CriteriaQuery<T> allCriteria = criteriaQuery.select(rootEntry);
        final TypedQuery<T> allQuery = this.entityManager.createQuery(allCriteria);
        // ajout du message pour le debug
        this.logger.debug("Generic Dao {} findAll ", this.entiteClass.getSimpleName());
        return allQuery.getResultList();
    }

    // les autres méthodes du CRUD à ajouter

}
