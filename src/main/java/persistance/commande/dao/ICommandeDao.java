/**
 * 
 */
package persistance.commande.dao;

import java.util.List;

import persistance.commande.entity.CommandeDo;
import persistance.commun.dao.IGenericDao;

/**
 * Interface pour implémenter le CRUD et les fonctionnalités spécifiques aux commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface ICommandeDao extends IGenericDao<CommandeDo> {

    /**
     * Permet de retourner la liste des commandes d'un utilisateurs
     *
     * @param  userId l'identifiant de l'utilisateur
     * @return        List{@code<CommandeDto>} la liste des commandes trouvées
     */
    List<CommandeDo> findByUserId(final Integer userId);

    /**
     * Permet de retourner une commande avec ses produits selon sa référence
     *
     * @param  reference la réference de la commande
     * @return           CommandeDo la commande trouvé, null sinon
     */
    CommandeDo findByRef(final String reference);

    /**
     * Permet de retourner une commande sans ses produits et juste la référence afin de vérifier que celle ci existe bien
     *
     * @param  reference la référence de produit à vérifier
     * @return           CommandeDo la commande avec sa référence sans les produits, null sinon
     */
    CommandeDo isCommandeExist(final String reference);

    //Méthode utilisée à la suppression d'un utilisateur
    /**
     * Permet de passer l'attribut idUtilisateur d'une commande à NULL pour pouvoir supprimer l'utilisateur correspondant
     *
     * @param idUtilisateur : l'utisateur qui va être supprimé et dont on veut passer l'idUtilisateur des commandes à NULL
     */
    void updateCommandeDoUserDeletion(final Integer idUtilisateur);
}
