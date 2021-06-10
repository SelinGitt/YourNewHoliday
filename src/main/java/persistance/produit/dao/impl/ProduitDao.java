/**
 * 
 */
package persistance.produit.dao.impl;

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

import persistance.commun.dao.impl.AbstractGenericDao;
import persistance.contact.impl.FichierContactDao;
import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;

/**
 * Classe repr�sentant l'impl�mentation de IProduitDao
 *
 * @author Administrateur
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProduitDao extends AbstractGenericDao<ProduitDo> implements IProduitDao {

    private static final Logger logger = LoggerFactory.getLogger(FichierContactDao.class);

    /**
     * Constructeur par d�faut
     */
    public ProduitDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour r�cup�rer la classe de l'entit�.
        super(ProduitDo.class);
    }

    @Override
    public List<ProduitDo> findAllProduitsEnVente() {
        // la requ�te findAll avec un crit�re
        final var criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ProduitDo> criteriaQuery = criteriaBuilder.createQuery(ProduitDo.class);
        final Root<ProduitDo> rootEntry = criteriaQuery.from(ProduitDo.class);
        final ParameterExpression<Boolean> miseEnVente = criteriaBuilder.parameter(Boolean.class);
        // Cr�ation du select avec la condition "where"
        final var selectCriteriaQuery = criteriaQuery.select(rootEntry);
        selectCriteriaQuery.where(criteriaBuilder.equal(rootEntry.get("miseEnVente"), miseEnVente));
        // Cr�ation de la typedQuery
        final TypedQuery<ProduitDo> allMiseEnVenteQuery = entityManager.createQuery(criteriaQuery);
        allMiseEnVenteQuery.setParameter(miseEnVente, true);
        return allMiseEnVenteQuery.getResultList();
    }

    @Override
    public ProduitDo findProduitEnVente(final Integer idProduit) {
        try {
            // Une requ�te JPQL qui cherche un produit en vente en base suivant son ID
            final TypedQuery<ProduitDo> query = entityManager
                    .createQuery("FROM ProduitDo WHERE idProduitOriginal = :id AND mise_en_vente = 1", ProduitDo.class);
            query.setParameter("id", idProduit);
            // Instanciation du produit trouv�
            final ProduitDo produitDo = query.getSingleResult();
            return produitDo;
            // Si l'id n'existe pas en base ou si le produit recherch� n'est pas en vente, on retourne null.
        } catch (final NoResultException noResultException) {
            // Si exception 
            logger.error("NoResult Exception", noResultException);
            return null;
        }

    }
}
