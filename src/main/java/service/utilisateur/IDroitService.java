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
     * Permet de r�cuperer tout les droits
     *
     * @return List de DroitDto ou EmptyList
     */
    List<DroitDto> findAll();
}
