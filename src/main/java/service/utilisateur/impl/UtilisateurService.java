package service.utilisateur.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.util.GenerateReferenceUtil;
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

    @Autowired
    private ICommandeDao        iCommandeDao;

    @Override
    public List<UtilisateurDto> findAllUtilisateurs() {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.findAll());
    }

    @Override
    public UtilisateurDto createUtilisateur(final UtilisateurDto utilisateurDto) {
        final var roleDto = new RoleDto();
        roleDto.setIdRole(1);

        utilisateurDto.setRole(roleDto);

        utilisateurDto.setDateInscription(Date.from(Instant.now()).toString());

        utilisateurDto.setEstDesactive(false);

        // TODO : Temporaire avec le generateReference
        utilisateurDto.setReference(GenerateReferenceUtil.generateReference());

        final var utilisateurDo = UtilisateurMapper.mapperToDo(utilisateurDto);
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.create(utilisateurDo));
    }

    @Override
    public UtilisateurConnecteDto authentify(final String email, final String password) {
        final var utilisateurDo = iUtilisateurDao.findByEmail(email);
        if (utilisateurDo != null) {
            //On récupère le mot de passe hashé en BD
            final String passwordCheck = utilisateurDo.getMdpHash();
            //On compare avec le mot de passe saisi qu'on hashe
            if (passwordCheck.equals(MDPCrypter.crypterMDPV1(password))) {
                return UtilisateurMapper.mapperToConnecteDto(utilisateurDo);
            }
            logger.info("Erreur d'authentification, les mots de passe ne correspondent pas.");
        }
        return null;
    }

    @Override
    public UtilisateurDto findUtilisateurById(final Integer id) {
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.findById(id));
    }

    @Override
    public boolean deleteUtilisateurById(final Integer id, final Integer role) {
        if (1 == this.iUtilisateurDao.rechercheNombreParRole(3) && (3 == role)) {
            return false;
        }
        iCommandeDao.updateCommandeDoUserDeletion(id);
        iUtilisateurDao.deleteUtilisateurById(id);
        return true;
    }

    @Override
    public List<UtilisateurDto> rechercherUtilisateurRang(final String rang) {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.rechercheRang(rang));
    }

    @Override
    public List<UtilisateurDto> rechercherUtilisateur(final String nom) {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.recherche(nom));
    }
}
