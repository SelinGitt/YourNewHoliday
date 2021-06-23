package service.utilisateur;

import java.util.List;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Interface IUtilisateurService
 *
 * @author Valentin
 */
public interface IUtilisateurService {

    /**
     * Permet de r�cuperer tout les utilisateurs
     *
     * @return List d'UtilisateurDo ou EmptyList
     */
    List<UtilisateurDto> findAllUtilisateurs();

    /**
     * Permet de creer un utilisateur en base de donnees
     *
     * @param  utilisateurDto Utilisateur a creer
     * @return                Utilisateur creer
     */
    UtilisateurDto createUtilisateur(final UtilisateurDto utilisateurDto);

    /**
     * Permet d'authentifier un utilisateur � l'aide de son email et de son mot de passe
     * 
     * @param  email    : l'email saisi par l'utilisateur
     * @param  password : le mot de passe saisi par l'utilisateur
     * @return          un UtilisateurConnecteDto � mettre en session si l'authentification est valide, null sinon
     */
    UtilisateurConnecteDto authentify(final String email, final String password);

    /**
     * Permet de renvoyer un UtilisateurDto en le cherchant par l'Id
     *
     * @param  id de l'utilisateur provenant de l'utilisateurConnecteDto
     * @return    un UtilisateurDto, ou null si non trouv�
     */
    UtilisateurDto findUtilisateurById(final Integer id);

    /**
     * Permet de supprimer un UtilisateurDo (donc en BD) en utilisant son Id
     *
     * @param  id : id de l'utilisateur � supprimer
     * @return    true si la suppression a r�ussi, false sinon
     */
    boolean deleteUtilisateurById(final Integer id);
}
