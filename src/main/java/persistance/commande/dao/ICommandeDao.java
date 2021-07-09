/**
 * 
 */
package persistance.commande.dao;

import java.util.List;

import persistance.commande.entity.CommandeDo;
import persistance.commun.dao.IGenericDao;

/**
 * Interface pour impl�menter le CRUD et les fonctionnalit�s sp�cifiques aux commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface ICommandeDao extends IGenericDao<CommandeDo> {

    /**
     * Permet de retourner la liste des commandes d'un utilisateurs
     *
     * @param  userId l'identifiant de l'utilisateur
     * @return        List{@code<CommandeDto>} la liste des commandes trouv�es
     */
    List<CommandeDo> findByUserId(final Integer userId);

    /**
     * Permet de retourner une commande selon sa r�f�rence
     *
     * @param  reference la r�ference de la commande
     * @return           CommandeDo la commande trouv�, null sinon
     */
    CommandeDo findByRef(final String reference);

    //M�thode utilis�e � la suppression d'un utilisateur
    /**
     * Permet de passer l'attribut idUtilisateur d'une commande � NULL pour pouvoir supprimer l'utilisateur correspondant
     *
     * @param idUtilisateur : l'utisateur qui va �tre supprim� et dont on veut passer l'idUtilisateur des commandes � NULL
     */
    void updateCommandeDoUserDeletion(final Integer idUtilisateur);
}
