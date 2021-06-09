/**
 * 
 */
package persistance.produit.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commun.dao.impl.AbstractGenericDao;
import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;

/**
 * Classe représentant l'implémentation de IProduitDao
 *
 * @author Administrateur
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProduitDao extends AbstractGenericDao<ProduitDo> implements IProduitDao {

    /**
     * Constructeur par défaut
     */
    public ProduitDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour récupérer la classe de l'entité.
        super(ProduitDo.class);
    }

    @Override
    public List<ProduitDo> findAllProduitsEnVente() {
        // la requête findAll avec un critère
        final var criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ProduitDo> criteriaQuery = criteriaBuilder.createQuery(ProduitDo.class);
        final Root<ProduitDo> rootEntry = criteriaQuery.from(ProduitDo.class);
        final ParameterExpression<Boolean> miseEnVente = criteriaBuilder.parameter(Boolean.class);
        // Création du select avec la condition "where"
        final var selectCriteriaQuery = criteriaQuery.select(rootEntry);
        selectCriteriaQuery.where(criteriaBuilder.equal(rootEntry.get("miseEnVente"), miseEnVente));
        // Création de la typedQuery
        final TypedQuery<ProduitDo> allMiseEnVenteQuery = entityManager.createQuery(criteriaQuery);
        allMiseEnVenteQuery.setParameter(miseEnVente, true);
        return allMiseEnVenteQuery.getResultList();
    }

    @Override
    public List<ProduitDo> rechercherProduits() {
        final var criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ProduitDo> criteriaQuery = criteriaBuilder.createQuery(ProduitDo.class);
        final Root<ProduitDo> rootEntry = criteriaQuery.from(ProduitDo.class);
        final ParameterExpression<Boolean> miseEnVente = criteriaBuilder.parameter(Boolean.class);
        // Création du select avec la condition "where"
        final var selectCriteriaQuery = criteriaQuery.select(rootEntry);
        selectCriteriaQuery.where(
                criteriaBuilder.equal(rootEntry.get("SELECT produit.nom FROM produit WHERE produit.reference LIKE '%ITA%' "), miseEnVente));
        // Création de la typedQuery
        final TypedQuery<ProduitDo> allMiseEnVenteQuery = entityManager.createQuery(criteriaQuery);
        allMiseEnVenteQuery.setParameter(miseEnVente, true);
        return allMiseEnVenteQuery.getResultList();
    }
}
