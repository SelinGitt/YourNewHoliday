package persistance.utilisateur.dao;

import java.util.List;

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
     * Permet de renvoyer un UtilisateurDo trouv� g�ce � l'email
     *
     * @param  email � utiliser pour la recherche
     * @return       l'UtilisateurDo correspondant
     */
    UtilisateurDo findByEmail(final String email);

    /**
     * Permet de supprimer une UtilisateurDo en BD
     *
     * @param  id : id de l'utilisateur � supprimer
     * @return    un boolean, true si suppression ok, false sinon
     */
    boolean deleteUtilisateurById(final Integer id);
}
