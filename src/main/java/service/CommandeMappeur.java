package service;

import java.math.RoundingMode;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.CommandeDto;

/**
 * Classe Mapper pour la commande
 *
 * @author Hanan Anghari
 */
public class CommandeMappeur {
    private CommandeMappeur() {
        // emprty
    }

    /**
     * Permet de mapper une commandeDto en commande Do
     *
     * @param  commandeDo la commande à mapper
     * @return            la commande mappé
     */
    public static CommandeDto mapperToDto(final CommandeDo commandeDo) {
        if (commandeDo == null) {
            return null;
        }
        final CommandeDto commandeDto = new CommandeDto();
        commandeDto.setId(String.valueOf(commandeDo.getId()));
        commandeDto.setReference(commandeDo.getReference());
        commandeDto.setPrixTotal(String.valueOf(commandeDo.getPrixTotal().setScale(2, RoundingMode.FLOOR)));
        if (commandeDo.getDate() != null) {
            final Format formatter = new SimpleDateFormat("dd/MM/yyyy");

            commandeDto.setDate(formatter.format(commandeDo.getDate()));
        }

        return commandeDto;
    }

    /**
     * Permet de mapper une liste de commandeDo
     *
     * @param  listeCommandeDo la liste à mapper
     * @return                 la liste mappée
     */
    public static List<CommandeDto> mapperListDoToDto(final List<CommandeDo> listeCommandeDo) {
        return listeCommandeDo.stream().map(CommandeMappeur::mapperToDto).collect(Collectors.toList());

    }
}
