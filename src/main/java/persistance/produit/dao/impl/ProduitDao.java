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
import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;
import presentation.produit.controller.TypeTriAlphanumerique;

/**
 * Classe représentant l'implémentation de IProduitDao
 *
 * @author Administrateur
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProduitDao extends AbstractGenericDao<ProduitDo> implements IProduitDao {

    private static final Logger logger = LoggerFactory.getLogger(ProduitDao.class);

    /**
     * Constructeur par défaut
     */
    public ProduitDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour récupérer la classe de l'entité.
        super(ProduitDo.class);
    }

    @Override
    public List<ProduitDo> findAllProduitsEnVente() {
        logger.debug("ProduitDao findAllProduitsEnVente");
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
    public ProduitDo findProduitEnVente(final Integer idProduit) {
        logger.debug("ProduitDao findProduitEnVente (par ID); idProduit : {}", idProduit);
        try {
            // Une requête JPQL qui cherche un produit en vente en base suivant son ID
            final TypedQuery<ProduitDo> query = entityManager
                    .createQuery("FROM ProduitDo WHERE idProduitOriginal = :id AND mise_en_vente = 1", ProduitDo.class);
            query.setParameter("id", idProduit);
            // On retourne le produit trouvé
            return query.getSingleResult();
            // Si l'id n'existe pas en base ou si le produit recherché n'est pas en vente, on retourne null.
        } catch (final NoResultException noResultException) {
            // Si exception 
            logger.error("Le produit d'ID {idProduit} n'est pas en base ou n'est pas en vente.", noResultException);
            return null;
        }
    }

    @Override
    public List<ProduitDo> rechercherProduitsEnVente(final String searchTerm) {
        final TypedQuery<ProduitDo> query = entityManager
                .createQuery("From ProduitDo WHERE reference LIKE :searchTerm AND mise_en_vente = 1", ProduitDo.class);
        query.setParameter("searchTerm", "%" + searchTerm + "%");
        logger.debug("ProduitDao rechercherProduitsEnVente (par référence); searchTerm : {}", searchTerm);
        return query.getResultList();
    }

    @Override
    public List<ProduitDo> trierListe(final TypeTriAlphanumerique typeTri) {
        final TypedQuery<ProduitDo> query = entityManager.createQuery(
                "FROM ProduitDo WHERE mise_en_vente = 1 ORDER BY prix_unitaire ".concat(typeTri.getTypeDao()), ProduitDo.class);
        logger.debug("Produit Dao trierListe, typeTri : {}", typeTri.getTypeDao());
        return query.getResultList();
    }

    @Override
    public List<ProduitDo> trierFiltreListe(final TypeTriAlphanumerique typeTri, final String searchTerm) {
        final TypedQuery<ProduitDo> query = entityManager
                .createQuery("FROM ProduitDo WHERE reference LIKE :searchTerm AND mise_en_vente = 1 ORDER BY prix_unitaire "
                        .concat(typeTri.getTypeDao()), ProduitDo.class);
        query.setParameter("searchTerm", "%" + searchTerm + "%");
        logger.debug("ProduitDao trierFiltreListe; searchTerm : {}; typeTri : {}", searchTerm, typeTri.getTypeDao());
        return query.getResultList();
    }

    @Override
    public ProduitDo findByReference(final String reference) {
        final TypedQuery<ProduitDo> query = entityManager.createQuery("SELECT pdt FROM ProduitDo pdt WHERE pdt.reference = :ref",
                ProduitDo.class);
        query.setParameter("ref", reference);
        try {
            logger.debug("ProduitDao findByReference; reference: {}", reference);
            return query.getSingleResult();

        } catch (final NoResultException noResultException) {
            // Si exception 
            logger.info("Le produit de référence {reference} n'est pas en base.", noResultException);
            return null;
        }
    }

    @Override
    public List<ProduitDo> rechercherAllProduits(final String searchTerm) {
        logger.debug("ProduitDao rechercherAllProduits (par référence, tous); searchTerm : {}", searchTerm);
        final TypedQuery<ProduitDo> query = entityManager.createQuery("From ProduitDo WHERE reference LIKE :searchTerm", ProduitDo.class);
        query.setParameter("searchTerm", "%" + searchTerm + "%");
        return query.getResultList();
    }

    @Override
    public ProduitDo findProduitEnVenteAvecVersion(final Integer idProduit, final Integer version) {
        try {
            // Une requête JPQL qui cherche un produit en vente en base suivant son ID
            final TypedQuery<ProduitDo> query = entityManager.createQuery(
                    "FROM ProduitDo WHERE idProduitOriginal = :id AND version = :version AND mise_en_vente = 1", ProduitDo.class);
            query.setParameter("id", idProduit);
            query.setParameter("version", version);
            // On retourne le produit trouvé
            return query.getSingleResult();
            // Si l'id n'existe pas en base ou si le produit recherché n'est pas en vente, on retourne null.
        } catch (final NoResultException noResultException) {
            // Si exception 
            logger.info("Le produit d'ID {idProduit} n'est pas en base, n'est pas en vente ou n'a pas la bonne version.",
                    noResultException);
            return null;
        }
    }

    @Override
    public List<ProduitDo> trouverProduitsFiltre(final boolean filtre) {
        final TypedQuery<ProduitDo> query = entityManager.createQuery("FROM ProduitDo WHERE mise_en_vente = :filtre", ProduitDo.class);
        query.setParameter("filtre", filtre);
        logger.debug("ProduitDao trouverProduitFiltre; filtre ; {}", filtre);
        return query.getResultList();
    }

    @Override
    public List<ProduitDo> trouverProduitsRechercheFiltre(final String searchTerm, final boolean filtre) {
        final TypedQuery<ProduitDo> query = entityManager
                .createQuery("FROM ProduitDo WHERE reference like :searchTerm AND mise_en_vente = :filtre", ProduitDo.class);
        query.setParameter("searchTerm", "%" + searchTerm + "%");
        logger.debug("ProduitDao / méthode : trouverProduitsRechercheFiltre; searchTerm : {}", searchTerm);
        query.setParameter("filtre", filtre);
        logger.debug("ProduitDao / méthode : trouverProduitsRechercheFiltre; filtre : {}", filtre);
        return query.getResultList();
    }

    @Override
    public List<ProduitDo> findAllProduitsTriAlpha() {
        final TypedQuery<ProduitDo> query = entityManager.createQuery("FROM ProduitDo ORDER BY reference ASC", ProduitDo.class);
        return query.getResultList();
    }
}
