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
import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.RoleDto;
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
            logger.info("Erreur cr�ation d'utilisateur. Email d�j� pris {}", utilisateurDto.getEmail());
            return null;
        }

        final var roleDto = new RoleDto();
        roleDto.setIdRole(utilisateurDto.getRole().getIdRole());

        utilisateurDto.setRole(roleDto);

        utilisateurDto.setDateInscription(Date.from(Instant.now()).toString());

        utilisateurDto.setEstDesactive(false);

        final String reference = new GenerateReferenceUtilisateurUtil().generateReference();
        utilisateurDto.setReference(reference);

        final var utilisateurDo = UtilisateurMapper.mapperToDo(utilisateurDto);
        logger.debug("Utilisateur ref : {} cr��.", reference);
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.create(utilisateurDo));
    }

    @Override
    public UtilisateurServiceAuthReturn authentify(final String email, final String password) {
        //Instanciation du builder, qui va �tre renseign� au fil de l'eau avant de construire l'objet retour en retour de m�thode
        final var builder = new UtilisateurServiceAuthReturn.UtilisateurServiceAuthReturnBuilder();

        final var utilisateurDo = iUtilisateurDao.findByEmail(email);

        if (utilisateurDo == null) {
            logger.debug("Utilisateur avec login : {} n'existe pas en BD.", email);
            builder.withUtilisateurConnecteDto(null).withIsDesactive(false);
            return builder.build();
        }
        //On compare avec le mot de passe saisi qu'on hashe
        if (checkPassword(password, utilisateurDo)) {
            //Les mots de passe correspondent, on v�rifie si l'utilisateur est d�sactiv� ou non
            if (Boolean.TRUE.equals(utilisateurDo.getEstDesactive())) {
                logger.debug("Utilisateur avec login : {} est d�sactiv�.", email);
                builder.withUtilisateurConnecteDto(null).withIsDesactive(true);
            } else {
                logger.debug("Utilisateur avec login : {} connect� avec succ�s.", email);
                final var utilisateurConnecteDto = UtilisateurMapper.mapperToConnecteDto(utilisateurDo);
                builder.withUtilisateurConnecteDto(utilisateurConnecteDto).withIsDesactive(false);
            }
        } else {
            logger.info("Erreur d'authentification, les mots de passe ne correspondent pas.");
            builder.withUtilisateurConnecteDto(null).withIsDesactive(false);
        }
        return builder.build();
    }

    /**
     * Permet de comparer un mot de passe saisi avec celui connu en BD
     *
     * @param  password      String mot de passe saisi
     * @param  utilisateurDo l'utilisateur en BD dont on va r�cup�rer le mot de passe hash� pour la comparaison
     * @return               un boolean, true si identiques, false sinon
     */
    private boolean checkPassword(final String password, final UtilisateurDo utilisateurDo) {
        final var passwordCheck = utilisateurDo.getMdpHash();
        return passwordCheck.equals(MDPCrypter.crypterMDPV1(password));
    }

    @Override
    public UtilisateurDto findUtilisateurById(final Integer id) {
        logger.debug("Recherche de l'utilisateur d'id : {}.", id);
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.findById(id));
    }

    @Override
    public UtilisateurServiceReturn deleteUtilisateurByRef(final Integer idUtilisateurConnecte, final String referenceUtilisateur,
            final String origin) {

        //Instanciation du builder, qui va �tre renseign� au fil de l'eau avant de construire l'objet retour en retour de m�thode
        final var builder = new UtilisateurServiceReturn.UtilisateurServiceReturnBuilder();

        //On r�cup�re l'id de l'utilisateurDo correspondant � l'utilisateurDto
        final var idUtilisateurASupprimer = iUtilisateurDao.findByReference(referenceUtilisateur).getIdUtilisateur();

        //On teste si la page d'origine est la liste USR_01 et si l'admin se supprime lui-m�me
        final var isSameUserFromList = isSameUserFromList(origin, idUtilisateurConnecte, idUtilisateurASupprimer);
        builder.withIsSameUserFromList(isSameUserFromList);

        //On teste si l'utilisateur est le dernier admin
        if (iUtilisateurDao.isLastAdmin(idUtilisateurASupprimer)) {
            logger.info("L'utilisateur ref : {} est le dernier administrateur, suppression impossible", referenceUtilisateur);
            builder.withIsSucceeded(false);
        } else {
            //Suppression autoris�e
            //On d�tache les commandes de l'utilisateur
            iCommandeDao.updateCommandeDoUserDeletion(idUtilisateurASupprimer);
            //On le supprime
            iUtilisateurDao.deleteUtilisateurById(idUtilisateurASupprimer);
            logger.debug("L'utilisateur ref : {} a �t� supprim�.", referenceUtilisateur);
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
                logger.debug("Recherche de tous les utilisateurs.");
                return this.findAllUtilisateurs();
            }
            logger.debug("Recherche de tous les utilisateurs de r�le d'id {}.", idRole);
            return this.rechercherUtilisateurRole(idRole);
        }

        // Nom pas empty, donc recherche par nom ou nom + role
        if (idRole == 0) {
            logger.debug("Recherche de tous les utilisateurs de nom {}.", nom);
            return this.rechercherUtilisateurNom(nom);
        }
        logger.debug("Recherche de tous les utilisateurs de nom {} et de r�le d'id {}.", nom, idRole);
        return this.rechercherUtilisateurNomRole(nom, idRole);
    }

    @Override
    public UtilisateurDto updateUtilisateur(final UtilisateurDto utilisateurDto) {
        final var userFound = this.iUtilisateurDao.findByEmail(utilisateurDto.getEmail());
        // Verifie si l'email est deja pris par un autre utilisateur
        if (userFound != null && (!userFound.getIdUtilisateur().equals(utilisateurDto.getId()))) {
            logger.info("Erreur mise � jour d'utilisateur. Email d�j� pris {}. Ref utilisateur : {}", utilisateurDto.getEmail(),
                    utilisateurDto.getReference());
            return null;
        }

        final var userDo = UtilisateurMapper.mapperToDo(utilisateurDto);

        // Si l'utilisateur ne change pas son mdp, on recup son ancien mdp hash
        // Obligatoire car le mappeur hash le mdp
        // On n'utilise pas findByEmail car l'utilisateur peut modifier l'email
        if (utilisateurDto.getPassword().isEmpty()) {
            userDo.setMdpHash(this.iUtilisateurDao.findById(utilisateurDto.getId()).getMdpHash());
        }

        logger.info("L'utilisateur ref : {} a �t� mis � jour", utilisateurDto.getReference());
        return UtilisateurMapper.mapperToDto(this.iUtilisateurDao.update(userDo));
    }

    @Override
    public UtilisateurDto rechercherReference(final String reference) {
        final var utilisateurDo = iUtilisateurDao.findByReference(reference);
        if (utilisateurDo == null) {
            logger.debug("Utilisateur {} non trouv�.", reference);
            return null;
        }
        logger.debug("Utilisateur {} trouv�.", reference);
        return UtilisateurMapper.mapperToDto(utilisateurDo);
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
