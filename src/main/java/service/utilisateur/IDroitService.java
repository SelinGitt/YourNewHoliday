/**
 * 
 */
package service.utilisateur;

import java.util.List;

import presentation.utilisateur.dto.DroitDto;

/**
 * Interface IDroitService
 *
 * @author Valentin
 */
public interface IDroitService {

    /**
     * Permet de récuperer tout les droits
     *
     * @return List de DroitDto ou EmptyList
     */
    List<DroitDto> findAll();

    /**
     * Permet de trouver les roles lie a un droit
     *
     * @param  droit Droit ou il faut trouver les roles
     * @return       List des libelle des roles
     */
    List<String> findRole(final DroitDto droit);
}
