/**
 * 
 */
package service.utilisateur.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.utilisateur.dao.IDroitDao;
import presentation.utilisateur.dto.DroitDto;
import service.utilisateur.IDroitService;
import service.utilisateur.util.DroitMapper;

/**
 * Classe UtilisateurService <br>
 * Implemente {@link service.utilisateur.IDroitService}
 *
 * @author Valentin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DroitService implements IDroitService {

    @Autowired
    private IDroitDao iDroitDao;

    @Override
    public List<DroitDto> findAll() {
        return DroitMapper.mapperToListDto(this.iDroitDao.findAll());
    }

    @Override
    public List<String> findRole(final DroitDto droit) {
        return this.iDroitDao.findRole(DroitMapper.mapperToDo(droit));
    }

}
