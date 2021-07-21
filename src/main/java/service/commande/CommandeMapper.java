package service.commande;

import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.CommandeDto;
import service.util.DateFormatUtil;
import service.util.DecimalFormatUtils;

/**
 * Classe Mapper pour la commande
 *
 * @author Hanan Anghari
 */
public class CommandeMapper {

    /**
     * Constructor
     */
    private CommandeMapper() {
        // void
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
        final var commandeDto = new CommandeDto();
        commandeDto.setId(String.valueOf(commandeDo.getId()));
        commandeDto.setReference(commandeDo.getReference());
        commandeDto.setPrixTotalAvantRemise(DecimalFormatUtils.decimalFormatUtil(commandeDo.getPrixTotalAvantRemise()));
        commandeDto.setDate(DateFormatUtil.formaterDateToString(commandeDo.getDate()));
        commandeDto.setQuantiteTotale(String.valueOf(commandeDo.getQuantiteTotale()));
        commandeDto.setListCommandeProduitDto(CommandeProduitMapper.mapperSetDoToListDto(commandeDo.getCommandeProduitDoSet()));
        commandeDto.setPrixTotalApresRemise(DecimalFormatUtils.decimalFormatUtil(commandeDo.getPrixTotalApresRemise()));
        commandeDto.setRemise(calculerRemise(commandeDto));

        return commandeDto;
    }

    /**
     * Permet de mapper une liste de commandeDo
     *
     * @param  listeCommandeDo la liste à mapper
     * @return                 la liste mappée
     */
    public static List<CommandeDto> mapperListDoToDto(final List<CommandeDo> listeCommandeDo) {
        return listeCommandeDo.stream().map(CommandeMapper::mapperToDto).collect(Collectors.toList());

    }

    private static String calculerRemise(final CommandeDto commande) {
        return DecimalFormatUtils.decimalFormatUtil(DecimalFormatUtils.doubleFormatUtil(commande.getPrixTotalAvantRemise())
                - DecimalFormatUtils.doubleFormatUtil(commande.getPrixTotalApresRemise()));
    }
}
