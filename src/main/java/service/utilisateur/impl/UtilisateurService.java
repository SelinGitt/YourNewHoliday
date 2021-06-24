package service.utilisateur.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public List<UtilisateurDto> rechercherUtilisateur(final String nom, final Integer role, final String searchType) {
        List<UtilisateurDto> listUtilisateur = new ArrayList<>();

        // Si on effectue une recherche par nom et par filtre
        if (!nom.isEmpty() && role != null) {
            listUtilisateur = this.rechercherUtilisateurNomRole(nom, role);
        } else {
            // Si on effectue une recherche par nom ou si on selectionne filter a tous et que la recherche par nom n'est pas vide
            if ("search".equals(searchType) || ("filter".equals(searchType) && role == null)) {
                listUtilisateur = this.rechercherUtilisateurNom(nom);
            }

            // Si on effectue une recherche par filtre et que la recherche par nom est vide sinon ecrase la liste
            if ("filter".equals(searchType) && nom.isBlank()) {
                listUtilisateur = this.rechercherUtilisateurRole(role);
            }
        }

        return listUtilisateur;
    }

    /**
     * Permet de rechercher un utilisateur selon le nom
     *
     * @param  nom Nom a rechercher
     * @return     List des utilisateur avec le nom
     */
    private List<UtilisateurDto> rechercherUtilisateurNom(final String nom) {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.recherche(nom));
    }

    /**
     * Permet de rechercher un utilisateur selon le role
     *
     * @param  role Role a rechercher
     * @return      List des utilisateur avec le role
     */
    private List<UtilisateurDto> rechercherUtilisateurRole(final Integer role) {
        if (role == null) {
            return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.findAll());
        }
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.rechercheRole(role));
    }

    /**
     * Permet de rechercher un utilisateur selon le nom et le role
     * 
     * @param  nom  Nom a rechercher
     * @param  role Role a rechercher
     * @return      List des utilisateur avec le nom et le role
     */
    private List<UtilisateurDto> rechercherUtilisateurNomRole(final String nom, final Integer role) {
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.rechercheNomRole(nom, role));
    }
}
