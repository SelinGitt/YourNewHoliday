package persistance.utilisateur.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commun.dao.impl.AbstractGenericDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.UtilisateurDo;

/**
 * Classe UtilisateurDao
 *
 * @author Valentin
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UtilisateurDao extends AbstractGenericDao<UtilisateurDo> implements IUtilisateurDao {

    /**
     * Constructeur par défaut
     */
    public UtilisateurDao() {
        // on utilise le constructeur de la superclass avec ProduitDo.class pour récupérer la classe de l'entité.
        super(UtilisateurDo.class);
    }
}
