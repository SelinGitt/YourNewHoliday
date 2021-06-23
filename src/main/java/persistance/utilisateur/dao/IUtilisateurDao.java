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
     * Permet de renvoyer un UtilisateurDo trouvé gâce à l'email
     *
     * @param  email à utiliser pour la recherche
     * @return       l'UtilisateurDo correspondant
     */
    UtilisateurDo findByEmail(final String email);

    /**
     * Permet d'effectue une recherche en base selon un terme dans une colonne donnee
     *
     * @param  nom Nom a recherche
     * @return     List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> recherche(final String nom);

    /**
     * Permet d'effectue une recherche en base selon le role
     *
     * @param  role Role a recherche
     * @return      List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> rechercheRole(final String role);

    /**
     * Permet d'effectue une recherche en base selon le nom et le role
     * 
     * @param  nom  Nom a recherche
     * @param  role Role a recherche
     * @return      List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> rechercheNomRole(final String nom, final String role);
}
