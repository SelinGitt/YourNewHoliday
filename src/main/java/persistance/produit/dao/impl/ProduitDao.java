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
 * Classe repr�sentant l'impl�mentation de IProduitDao
 *
 * @author Administrateur
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProduitDao extends AbstractGenericDao<ProduitDo> implements IProduitDao {

    /**
     * Constructeur par d�faut
     */
    public ProduitDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour r�cup�rer la classe de l'entit�.
        super(ProduitDo.class);
    }

}
