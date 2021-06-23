/**
 * 
 */
package service.commande;

import java.util.List;

import presentation.commande.dto.CommandeDto;

/**
 * Interface pour les services sur les Commandes
 *
 * @author Hanan Anghari
 */
public interface ICommandeService {

    /**
     * Permet de lister les commandes d'un utilisateur
     *
     * @param  idUser l'identifiant de l'utilisateur
     * @return        List<CommandeDto> la liste des commandes
     */
    List<CommandeDto> listerCommandesUtilisateur(final Integer idUser);

    /**
     * Permet de trouver une commande à partir de sa référence
     *
     * @param  reference la référence de la commande qu'on cherche
     * @return           CommandeDto la commandeDto qu'on a trouvée
     */
    CommandeDto trouverCommandeParReference(final String reference);

}
