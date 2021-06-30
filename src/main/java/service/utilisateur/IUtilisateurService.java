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
     * Permet de récuperer tout les utilisateurs
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
     * Permet d'authentifier un utilisateur à l'aide de son email et de son mot de passe
     * 
     * @param  email    : l'email saisi par l'utilisateur
     * @param  password : le mot de passe saisi par l'utilisateur
     * @return          un UtilisateurConnecteDto à mettre en session si l'authentification est valide, null sinon
     */
    UtilisateurConnecteDto authentify(final String email, final String password);

    /**
     * Permet de rechercher un utilisater selon le nom et/ou le role
     *
     * @param  nom    Nom a rechercher
     * @param  idRole Role a rechercher
     * @return        List d'UtilisateurDto
     */
    List<UtilisateurDto> rechercherUtilisateur(final String nom, final Integer idRole);

    /**
     * Permet de mettre a jour un utilisateur en base de donnees
     *
     * @param  utilisateurDto Utilisateur a mettre a jour
     * @return                UtilisateurDto mis a jour
     */
    UtilisateurDto updateUtilisateur(final UtilisateurDto utilisateurDto);

    /**
     * Permet de rechercher un utilisateur avec sa reference
     *
     * @param  reference Reference de l'utilisateur
     * @return           Utilisateur
     */
    UtilisateurDto findByReference(final String reference);
}
