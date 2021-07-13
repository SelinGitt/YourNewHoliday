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
     * Permet d'effectue une recherche en base selon un terme dans une colonne donnee
     *
     * @param  nom Nom a recherche
     * @return     List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> recherche(final String nom);

    /**
     * Permet d'effectue une recherche en base selon le role
     *
     * @param  idRole Role a recherche
     * @return        List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> rechercheRole(final Integer idRole);

    /**
     * Permet d'effectue une recherche en base selon le nom et le role
     * 
     * @param  nom    Nom a recherche
     * @param  idRole Role a recherche
     * @return        List d'UtilisateurDo correspondant a la recherche
     */
    List<UtilisateurDo> rechercheNomRole(final String nom, final Integer idRole);

    /**
     * Permet de savoir si un utilisateur devant �tre supprim� est le dernier administrateur
     *
     * @param  idUtilisateur = id de l'utilisateur dont on veut savoir s'il peut �tre supprim�
     * @return               un boolean true si c'est le dernier administrateur, false sinon
     */
    boolean isLastAdmin(final Integer idUtilisateur);

    /**
     * Permet de rechercher un utilisateur grace a ca reference
     *
     * @param  reference Reference de l'utilisateur
     * @return           UtilisateurDo correspondant a la recherche
     */
    UtilisateurDo findByReference(final String reference);
    
    /**
     * Permet de trier la liste des utilisateurs par nom dans l'ordre alphab�tique.
     *
     * @return la liste tri�e 
     */
    List<UtilisateurDo> findAllTriAlpha();
    
}
