package service.commande;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.CommandeDto;
import service.util.DateFormatUtil;

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
		final BigDecimal prixTotal = commandeDo.getPrixTotal().setScale(2, RoundingMode.FLOOR);
		commandeDto.setPrixTotal(String.format("%,.2f", prixTotal));
		commandeDto.setDate(DateFormatUtil.formaterDateToString(commandeDo.getDate()));
		commandeDto.setQuantiteTotale(commandeDo.getQuantiteTotale().toString());
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
}
