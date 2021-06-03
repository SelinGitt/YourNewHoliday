package service.commande;

import java.math.BigDecimal;
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
public class CommandeMapper {
    private CommandeMapper() {
        // emprty
    }

    /**
     * Permet de mapper une commandeDto en commande Do
     *
     * @param  commandeDo la commande � mapper
     * @return            la commande mapp�
     */
    public static CommandeDto mapperToDto(final CommandeDo commandeDo) {
        if (commandeDo == null) {
            return null;
        }
        final var commandeDto = new CommandeDto();
        commandeDto.setId(String.valueOf(commandeDo.getId()));
        commandeDto.setReference(commandeDo.getReference());
        final BigDecimal prixTotal = commandeDo.getPrixTotal().setScale(2, RoundingMode.FLOOR);
        commandeDto.setPrixTotal(String.format("%,.2f", prixTotal));
        final Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        commandeDto.setDate(formatter.format(commandeDo.getDate()));
        return commandeDto;
    }

    /**
     * Permet de mapper une liste de commandeDo
     *
     * @param  listeCommandeDo la liste � mapper
     * @return                 la liste mapp�e
     */
    public static List<CommandeDto> mapperListDoToDto(final List<CommandeDo> listeCommandeDo) {
        return listeCommandeDo.stream().map(CommandeMapper::mapperToDto).collect(Collectors.toList());

    }
}
