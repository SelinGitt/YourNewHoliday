/**
 * 
 */
package service.utilisateur.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DroitService.class);

    @Autowired
    private IDroitDao           iDroitDao;

    @Override
    public List<DroitDto> findAll() {
        logger.debug("Récupération des droits");
        return DroitMapper.mapperToListDto(this.iDroitDao.findAll());
    }

}
