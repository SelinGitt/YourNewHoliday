package service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.CommandeDto;

/*
 * Classe mapper pour la Commande
 */
public class CommandeMappeur {
	private CommandeMappeur() {
		// emprty
	}

	/*
	 * Métode permettant de mapper un CommandeDo en CommandeDto
	 */
	public static CommandeDto mapperToDto(final CommandeDo commandeDo) {
		if (commandeDo == null) {
			return null;
		}
		final CommandeDto commandeDto = new CommandeDto();
		commandeDto.setId(commandeDo.getId().toString());
		commandeDto.setReference(commandeDo.getReference());
		commandeDto.setPrixTotal(commandeDo.getPrixTotal().toString());
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		commandeDto.setDate(formatter.format(commandeDto.getDate()));
		return commandeDto;
	}

	public static List<CommandeDto> mapperListDoToDto(final List<CommandeDo> listeProduitDo) {
		return listeProduitDo.stream().map(CommandeMappeur::mapperToDto).collect(Collectors.toList());

	}
}
