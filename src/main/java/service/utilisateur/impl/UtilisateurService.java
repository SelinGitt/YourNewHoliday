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
import service.util.impl.GenerateReferenceUtilisateurUtil;
import service.utilisateur.IUtilisateurService;
import service.utilisateur.mapper.UtilisateurMapper;
import service.utilisateur.util.MDPCrypter;

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
        return UtilisateurMapper.mapperToListDto(this.iUtilisateurDao.findAllTriAlpha());
    }

    @Override
    public UtilisateurDto createUtilisateur(final UtilisateurDto utilisateurDto) {
        // Verifie si l'email est deja pris
        if (this.iUtilisateurDao.findByEmail(utilisateurDto.getEmail()) != null) {
            logger.info("Erreur création d'utilisateur. Email déjà pris {}", utilisateurDto.getEmail());
            return null;
        }

        final var roleDto = new RoleDto();
        roleDto.setIdRole(utilisateurDto.getRole().getIdRole());

        utilisateurDto.setRole(roleDto);

        utilisateurDto.setDateInscription(Date.from(Instant.now()).toString());

        utilisateurDto.setEstDesactive(false);

        utilisateurDto.setReference(new GenerateReferenceUtilisateurUtil().generateReference());

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
    public UtilisateurServiceReturn deleteUtilisateurByRef(final Integer idUtilisateurConnecte, final String referenceUtilisateur,
            final String origin) {

        //Instanciation du builder, qui va être renseigné au fil de l'eau avant de construire l'objet retour en retour de méthode
        final var builder = new UtilisateurServiceReturn.UtilisateurServiceReturnBuilder();

        //On récupère l'id de l'utilisateurDo correspondant à l'utilisateurDto
        final var idUtilisateurASupprimer = iUtilisateurDao.findByReference(referenceUtilisateur).getIdUtilisateur();

        //On teste si la page d'origine est la liste USR_01 et si l'admin se supprime lui-même
        final var isSameUserFromList = isSameUserFromList(origin, idUtilisateurConnecte, idUtilisateurASupprimer);
        builder.withIsSameUserFromList(isSameUserFromList);

        //On teste si l'utilisateur est le dernier admin
        if (iUtilisateurDao.isLastAdmin(idUtilisateurASupprimer)) {
            builder.withIsSucceeded(false);
        } else {
            //Suppression autorisée
            //On détache les commandes de l'utilisateur
            iCommandeDao.updateCommandeDoUserDeletion(idUtilisateurASupprimer);
            //On le supprime
            iUtilisateurDao.deleteUtilisateurById(idUtilisateurASupprimer);
            builder.withIsSucceeded(true);
        }
        return builder.build();
    }

    private boolean isSameUserFromList(final String origin, final Integer idUtilisateurConnecte, final Integer idUtilisateurASupprimer) {
        return ("2".equals(origin) && idUtilisateurConnecte.equals(idUtilisateurASupprimer));
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

    @Override
    public UtilisateurDto updateUtilisateur(final UtilisateurDto utilisateurDto) {
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.update(UtilisateurMapper.mapperToDo(utilisateurDto)));
    }

    @Override
    public UtilisateurDto rechercherReference(final String reference) {
        final var utilisateurDo = iUtilisateurDao.findByReference(reference);

        return (utilisateurDo == null ? null : UtilisateurMapper.mapperToDto(utilisateurDo));
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
