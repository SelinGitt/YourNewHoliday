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

    /**
     * Permet d'effectue une recherche en base selon le rang
     *
     * @param  rang Rang a recherche
     * @return      List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> rechercheRang(final String rang);

    /**
     * Permet d'effectue une recherche en base selon un terme dans une colonne donnee
     *
     * @param  nom Nom a recherche
     * @return     List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> recherche(final String nom);
    
    /**
     * Permet de renvoyer le nombre d'utilisateur d'un r�le donn�e en le passant en param�tre
     *
     * @param  rang : rang de l'utilisateur
     * @return      : un int le nombre d'utilisateurs ayant ce r�le
     */
    int rechercheNombreParRole(final Integer rang);
}
