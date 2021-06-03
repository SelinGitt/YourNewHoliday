/**
 * 
 */
package service.commande;

import java.util.List;

import presentation.commande.dto.CommandeDto;

/**
 * Interface pour les services sur les Commandes
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface ICommandeService {

    /**
     * Permet de trouver une commande � partir de sa r�f�rence
     *
     * @param  reference la r�f�rence de la commande qu'on cherche
     * @return           CommandeDto la commandeDto qu'on a trouv�e
     */
    CommandeDto trouverCommandeParReference(final String reference);

    /**
     * Permet de lister les commandes d'un utilisateur
     *
     * @param  idUser l'identifiant de l'utilisateur
     * @return        List<CommandeDto> la liste des commandes
     */
    List<CommandeDto> listerCommandesUtilisateur(final Integer idUser);
}
