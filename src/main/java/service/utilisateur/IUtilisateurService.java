package service.utilisateur;

import java.util.List;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.impl.UtilisateurServiceReturn;

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
     * Permet de renvoyer un UtilisateurDto en le cherchant par l'Id
     *
     * @param  id de l'utilisateur provenant de l'utilisateurConnecteDto
     * @return    un UtilisateurDto, ou null si non trouvé
     */
    UtilisateurDto findUtilisateurById(final Integer id);

    /**
     * Permet de supprimer un UtilisateurDo (donc en BD) en utilisant sa référence
     * 
     * @param  idCurrentUtilisateur : id de l'utilisateur en session
     * @param  referenceUtilisateur : String reference de l'utilisateur à supprimer
     * @param  origin               : page d'origine
     * @return                      un objet retour avec deux booléens (isLastAdmin pour vérifier si la suppression supprime
     *                              le dernier admin, et isSameUserFromList pour voir si l'admin se supprime depuis USR_01
     */
    UtilisateurServiceReturn deleteUtilisateurByRef(final Integer idCurrentUtilisateur, final String referenceUtilisateur,
            final String origin);

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
    UtilisateurDto rechercherReference(final String reference);
}
