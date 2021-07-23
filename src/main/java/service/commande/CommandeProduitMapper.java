/**
 * 
 */
package service.commande;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import persistance.commande.entity.CommandeDo;
import persistance.commande.entity.CommandeProduitDo;
import presentation.commande.dto.CommandeProduitDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.produit.dto.ProduitDto;
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
        commandeProduitDto.setPrixTotal(calculerPrixTotal(commandeProduitDo.getProduitAcheteDo().getPrixUnitaire(), commandeProduitDo
                .getQuantite()));
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

    /**
     * Permet de mapper une Map de ProduitDto, LigneCommandeProduitDto en un Set de commandeProduitDo
     *
     * @param  contenuPanier   la Map de produit
     * @param  commandeAffilie le commandeDo au quel les commandeProduitDo doivent être attaché
     * @return                 Set{@code<CommandeProduitDo>} le Set de commande et de produit
     */
    public static Set<CommandeProduitDo> mapperMapDtoToSetDo(final Map<ProduitDto, LigneCommandeProduitDto> contenuPanier,
            final CommandeDo commandeAffilie) {
        final Set<CommandeProduitDo> setCommandeProduitDo = new HashSet<>();
        for (final Map.Entry<ProduitDto, LigneCommandeProduitDto> entry : contenuPanier.entrySet()) {
            setCommandeProduitDo.add(mapperLignePanierToCommandeProduitDo(entry.getKey(), entry.getValue(), commandeAffilie));
        }
        return setCommandeProduitDo;
    }

    private static CommandeProduitDo mapperLignePanierToCommandeProduitDo(final ProduitDto produit, final LigneCommandeProduitDto ligne,
            final CommandeDo commande) {
        final var commandeProduitDo = new CommandeProduitDo();
        commandeProduitDo.setIdCommandeProduit(null);
        commandeProduitDo.setCommandeDo(commande);
        commandeProduitDo.setProduitAcheteDo(ProduitAcheteMapper.mapperToDo(produit));
        commandeProduitDo.setQuantite(ligne.getQuantite());
        return commandeProduitDo;
    }

}
