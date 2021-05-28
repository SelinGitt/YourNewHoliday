package service.utilisateur.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import persistance.utilisateur.entity.UtilisateurDo;
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
        utilisateurDto.setDateInscription(formatDateToString(utilisateurDo.getDateInscription()));
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
        utilisateurDo.setDateInscription(formatStringToDate(utilisateurDto.getDateInscription()));
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
     * Permet de formater une date au format dd/mm/yyyy
     *
     * @param  date Date a formater
     * @return      Date formater au format String
     */
    private static String formatDateToString(final Date date) {
        final var pattern = "dd/MM/YYYY";
        final var simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(date);
    }

    /**
     * Permet de formater un string en date
     *
     * @param  date           Date a formater
     * @return                Date formater au format Date
     * @throws ParseException Throw quand on parse la date
     */
    private static Date formatStringToDate(final String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (final ParseException exception) {
            exception.printStackTrace();
        }
        return new Date();
    }
}
