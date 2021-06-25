/**
 * 
 */
package service.commande;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import persistance.commande.entity.CommandeProduitDo;
import presentation.commande.dto.CommandeProduitDto;
import service.util.DecimalFormatUtils;

/**
 * Classe Mapper pour CommandeProduit
 *
 * @author Hanan Anghari
 */
public class CommandeProduitMapper {
    private CommandeProduitMapper() {
        //empty
    }

    /**
     * Permet de mapper une commandeProduitDto en commandeProduit Do
     *
     * @param  commandeProduitDo la commandeProduit à mapper
     * @return                   la commandeProduit mappé
     */
    public static CommandeProduitDto mapperToDto(final CommandeProduitDo commandeProduitDo) {
        if (commandeProduitDo == null) {
            return null;
        }
        final var commandeProduitDto = new CommandeProduitDto();
        commandeProduitDto.setIdListeCommande(String.valueOf(commandeProduitDo.getIdCommandeProduit()));
        commandeProduitDto.setProduitAcheteDto(ProduitAcheteMapper.mapperToDto(commandeProduitDo.getProduitAcheteDo()));
        commandeProduitDto.setQuantite(String.valueOf(commandeProduitDo.getQuantite()));
        commandeProduitDto
                .setPrixTotal(calculerPrixTotal(commandeProduitDo.getProduitAcheteDo().getPrixUnitaire(), commandeProduitDo.getQuantite()));
        return commandeProduitDto;

    }

    /**
     * Permet de mapper une liste de commandeProduitDto en set de commandeProduitDo
     *
     * @param  commandeProduitDoSet le set à mapper
     * @return                      la liste mappée
     */
    public static List<CommandeProduitDto> mapperSetDoToListDto(final Set<CommandeProduitDo> commandeProduitDoSet) {
        if (CollectionUtils.isEmpty(commandeProduitDoSet)) {
            return Collections.emptyList();
        }
        return commandeProduitDoSet.stream().map(CommandeProduitMapper::mapperToDto).collect(Collectors.toList());
    }

    private static String calculerPrixTotal(final BigDecimal prixUnitaire, final int quantite) {
        if (prixUnitaire == null) {
            return DecimalFormatUtils.decimalFormatUtil(BigDecimal.valueOf(0));
        }
        return DecimalFormatUtils.decimalFormatUtil(prixUnitaire.multiply(new BigDecimal(quantite)));
    }

}
