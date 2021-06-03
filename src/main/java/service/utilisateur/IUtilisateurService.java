package service.utilisateur;

import java.util.List;

import persistance.utilisateur.entity.UtilisateurDo;
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
     * Permet de renvoyer un UtilisateurDO � l'aide de son email
     *
     * @param  email : l'email de l'utilisateur
     * @return       un UtilisateurDO
     */
    UtilisateurDo findByEmail(final String email);

    /**
     * Permet d'authentifier un utilisateur � l'aide de son email et de son mot de passe
     *
     * @param  email    : l'email saisi par l'utilisateur
     * @param  password : le mot de passe saisi par l'utilisateur
     * @return          un UtilisateurConnecteDto � mettre en session si l'authentification est valide, null sinon
     */
    UtilisateurConnecteDto authentify(final String email, final String password);
}
