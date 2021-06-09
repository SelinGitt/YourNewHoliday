package service.utilisateur.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.utilisateur.dao.IUtilisateurDao;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;
import service.utilisateur.util.UtilisateurMapper;

/**
 * Classe UtilisateurService <br>
 * Implemente {@link service.utilisateur.IUtilisateurService}
 *
 * @author Valentin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UtilisateurService implements IUtilisateurService {

    @Autowired
    private IUtilisateurDao iUtilisateurDao;

    @Override
    public List<UtilisateurDto> findAllUtilisateurs() {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.findAll());
    }

    @Override
    public UtilisateurDto createUtilisateur(final UtilisateurDto utilisateurDto) {
        final var utilisateurDo = UtilisateurMapper.mapperToDo(utilisateurDto);
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.create(utilisateurDo));
    }

}
