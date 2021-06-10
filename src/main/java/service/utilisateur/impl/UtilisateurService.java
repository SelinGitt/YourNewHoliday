package service.utilisateur.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.utilisateur.dao.IUtilisateurDao;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;
import service.utilisateur.util.MDPCrypter;
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

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurService.class);

    @Autowired
    private IUtilisateurDao     iUtilisateurDao;

    @Override
    public List<UtilisateurDto> findAllUtilisateurs() {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.findAll());
    }

    @Override
    public UtilisateurConnecteDto authentify(final String email, final String password) {
        final var utilisateurDo = iUtilisateurDao.findByEmail(email);
        if (utilisateurDo != null) {
            //Dans une prochaine version du cryptage, le mot de passe en BD sera crypté.
            final String passwordCheck = MDPCrypter.crypterMDPV1(utilisateurDo.getMdpHash());
            if (passwordCheck.equals(MDPCrypter.crypterMDPV1(password))) {
                return UtilisateurMapper.mapperToConnecteDto(utilisateurDo);
            }
            logger.info("Erreur d'authentification, les mots de passe ne correspondent pas.");
        }
        return null;
    }
}
