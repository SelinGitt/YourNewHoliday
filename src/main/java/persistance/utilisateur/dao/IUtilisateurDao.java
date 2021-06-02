package persistance.utilisateur.dao;

import persistance.commun.dao.IGenericDao;
import persistance.utilisateur.entity.UtilisateurDo;

/**
 * Interface IUtilisateurDao <br>
 * Extends {@link persistance.commun.dao.IGenericDao}
 *
 * @author Valentin
 */
public interface IUtilisateurDao extends IGenericDao<UtilisateurDo> {

    /**
     * Permet de renvoyer un UtilisateurDo trouvé gâce à l'email
     *
     * @param  email à utiliser pour la recherche
     * @return       l'UtilisateurDo correspondant
     */
    UtilisateurDo findByEmail(final String email);
}