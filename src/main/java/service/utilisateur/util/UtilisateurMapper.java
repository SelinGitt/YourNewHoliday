package service.utilisateur.util;

import java.util.List;
import java.util.stream.Collectors;

import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Classe UtilisateurMapper <br>
 * Permet de mapper un DO en DTO, DTO en DO et une liste de DTO en liste de DO
 * 
 * @author Valentin
 */
public class UtilisateurMapper {

    /**
     * Constructor
     */
    private UtilisateurMapper() {
        // Empty CTR, on cache le CTR public
    }

    /**
     * Method to map UtilisateurDO into UtilisateurDTO
     * 
     * @param  utilisateurDo Utilisateur to map
     * @return               Mapped UtilisateurDto
     */
    public static UtilisateurDto mapperToDto(final UtilisateurDo utilisateurDo) {
        final var utilisateurDto = new UtilisateurDto();

        utilisateurDto.setReference(utilisateurDo.getReference());
        utilisateurDto.setEmail(utilisateurDo.getEmail());
        utilisateurDto.setDateInscription(utilisateurDo.getDateInscription());
        utilisateurDto.setNom(utilisateurDo.getNom());
        utilisateurDto.setPrenom(utilisateurDo.getPrenom());
        utilisateurDto.setEstActif(utilisateurDo.getEstActif());

        return utilisateurDto;
    }

    /**
     * Method to map UtilisateurDto into UtilisateurDO
     * 
     * @param  utilisateurDto Utilisateur to map
     * @return                Mapped UtilisateurDO
     */
    public static UtilisateurDo mapperToDo(final UtilisateurDto utilisateurDto) {
        final var utilisateurDo = new UtilisateurDo();

        utilisateurDo.setReference(utilisateurDto.getReference());
        utilisateurDo.setEmail(utilisateurDto.getEmail());
        utilisateurDo.setDateInscription(utilisateurDto.getDateInscription());
        utilisateurDo.setNom(utilisateurDto.getNom());
        utilisateurDo.setPrenom(utilisateurDto.getPrenom());
        utilisateurDo.setEstActif(utilisateurDto.getEstActif());

        return utilisateurDo;
    }

    /**
     * Method to map List of UtilisateurDO into List of UtilisateurDTO
     * 
     * @param  utilisateurDoList Utilisateur List to map
     * @return                   Mapped List UtilisateurDto
     */
    public static List<UtilisateurDto> mapperToListDto(final List<UtilisateurDo> utilisateurDoList) {
        return utilisateurDoList.stream().map(UtilisateurMapper::mapperToDto).collect(Collectors.toList());
    }

    /**
     * Method to map UtilisateurDo into UtilisateurConnecteDto
     *
     * @param  utilisateurDo : Utilisateur to map
     * @return               Mapped UtilisateurConnecteDto
     */
    public static UtilisateurConnecteDto mapperToConnecteDto(final UtilisateurDo utilisateurDo) {
        final var utilisateurConnecteDto = new UtilisateurConnecteDto();

        //TODO à changer quand les rôles seront gérés
        utilisateurConnecteDto.setIdRole("1");
        //TODO à changer quand les rôles seront gérés
        utilisateurConnecteDto.setNomRole("Rôle");

        utilisateurConnecteDto.setIdUtilisateur(String.valueOf(utilisateurDo.getIdUtilisateur()));
        utilisateurConnecteDto.setNom(utilisateurDo.getNom());
        utilisateurConnecteDto.setPrenom(utilisateurDo.getPrenom());
        //TODO gestion du panier à travailler avec l'équipe Panier
        utilisateurConnecteDto.setNbProduitPanier("0");

        return utilisateurConnecteDto;
    }
}
