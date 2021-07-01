package service.utilisateur.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.commande.dao.ICommandeDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.util.IGenerateReferenceUtil;
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

    private static final Logger    logger = LoggerFactory.getLogger(UtilisateurService.class);

    @Autowired
    private IUtilisateurDao        iUtilisateurDao;

    @Autowired
    private ICommandeDao           iCommandeDao;

    @Autowired
    @Qualifier("USR")
    private IGenerateReferenceUtil iGenerateReferenceUtil;

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
        utilisateurDto.setReference(this.iGenerateReferenceUtil.generateRef());

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
    public boolean deleteUtilisateurById(final Integer idUtilisateur, final Integer idRole) {
        //S'il ne reste qu'un admin et qu'on cherche à le supprimer -> false
        if (iUtilisateurDao.isLastAdmin(idRole)) {
            return false;
        }
        //On détache les commandes de l'utilisateur
        iCommandeDao.updateCommandeDoUserDeletion(idUtilisateur);
        //On le supprime
        iUtilisateurDao.deleteUtilisateurById(idUtilisateur);
        return true;
    }

    @Override
    public List<UtilisateurDto> rechercherUtilisateur(final String nom, final Integer idRole) {
        // Si nom empty on fait une recherche par filtre
        if (nom.isEmpty()) {
            if (idRole == 0) {
                return this.findAllUtilisateurs();
            }
            return this.rechercherUtilisateurRole(idRole);
        }

        // Nom pas empty, donc recherche par nom ou nom + role
        if (idRole == 0) {
            return this.rechercherUtilisateurNom(nom);
        }
        return this.rechercherUtilisateurNomRole(nom, idRole);
    }

    /**
     * Permet de rechercher un utilisateur selon le nom
     *
     * @param  nom Nom a rechercher
     * @return     List des utilisateur avec le nom
     */
    private List<UtilisateurDto> rechercherUtilisateurNom(final String nom) {
        logger.debug("Recherche par nom : {}", nom);
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.recherche(nom));
    }

    /**
     * Permet de rechercher un utilisateur selon le role
     *
     * @param  idRole Role a rechercher
     * @return        List des utilisateur avec le role
     */
    private List<UtilisateurDto> rechercherUtilisateurRole(final Integer idRole) {
        logger.debug("Recherche par idRole");
        if (idRole == null) {
            logger.debug("idRole null");
            return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.findAll());
        }
        logger.debug("idRole : {}", idRole);
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.rechercheRole(idRole));
    }

    /**
     * Permet de rechercher un utilisateur selon le nom et le role
     * 
     * @param  nom    Nom a rechercher
     * @param  idRole Role a rechercher
     * @return        List des utilisateur avec le nom et le role
     */
    private List<UtilisateurDto> rechercherUtilisateurNomRole(final String nom, final Integer idRole) {
        logger.debug("Recherche par nom et idRole; {} / {}", nom, idRole);
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.rechercheNomRole(nom, idRole));
    }
}
