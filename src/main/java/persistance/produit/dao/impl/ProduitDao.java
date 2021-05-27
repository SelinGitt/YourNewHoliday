/**
 * 
 */
package persistance.produit.dao.impl;

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

}
