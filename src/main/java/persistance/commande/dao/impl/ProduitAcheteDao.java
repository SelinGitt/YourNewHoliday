/**
 * 
 */
package persistance.commande.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.IProduitAcheteDao;
import persistance.commande.entity.ProduitAcheteDo;
import persistance.commun.dao.impl.AbstractGenericDao;

/**
 * Classe représentant l'implémentation des requète supplémentaire en base de données
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProduitAcheteDao extends AbstractGenericDao<ProduitAcheteDo> implements IProduitAcheteDao {

    private final Logger logger = LoggerFactory.getLogger(ProduitAcheteDao.class);

    /**
     * Constructor
     */
    public ProduitAcheteDao() {
        super(ProduitAcheteDo.class);
    }

    @Override
    public ProduitAcheteDo recupererProduitAcheteDo(final Integer idOriginal, final Integer version) {
        logger.info("Recherche le produit achete {} dont la version est {}.", idOriginal, version);
        final var request = new StringBuilder("SELECT pa FROM ProduitAcheteDo pa");
        request.append(" WHERE pa.idDeLOriginal = :idOriginal AND pa.version = :version");
        final TypedQuery<ProduitAcheteDo> query = entityManager.createQuery(request.toString(), ProduitAcheteDo.class);
        query.setParameter("idOriginal", idOriginal);
        query.setParameter("version", version);

        try {
            return query.getSingleResult();
        } catch (final NoResultException exception) {
            logger.info("Le produit {} de version {} n'est pas dans la table", idOriginal, version, exception);
            return null;
        }
    }

}
