package service.commande;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.CommandeAdresseDto;
import presentation.commande.dto.CommandeDto;
import presentation.panier.dto.LigneCommandeProduitDto;
import presentation.panier.dto.PanierDto;
import service.util.DateFormatUtil;
import service.util.DecimalFormatUtils;

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
        commandeDto.setPrixTotal(DecimalFormatUtils.decimalFormatUtil(commandeDo.getPrixTotal()));
        commandeDto.setDate(DateFormatUtil.formaterDateToString(commandeDo.getDate()));
        commandeDto.setQuantiteTotale(String.valueOf(commandeDo.getQuantiteTotale()));
        commandeDto.setListCommandeProduitDto(CommandeProduitMapper.mapperSetDoToListDto(commandeDo.getCommandeProduitDoSet()));

        final var livraisonAdresse = new CommandeAdresseDto();
        livraisonAdresse.setAdresse(commandeDo.getAdresseLivraison());
        commandeDto.setAdresseLivraison(livraisonAdresse);

        final var facturationAdresse = new CommandeAdresseDto();
        facturationAdresse.setAdresse(commandeDo.getAdresseFacturation());
        commandeDto.setAdresseFacturation(facturationAdresse);
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

    /**
     * Permet de mapper un Panier en CommandeDo
     *
     * @param  panier        le panier en session
     * @param  adresses      les adresses entrées par l'utilisateur
     * @param  reference     la reference de la commande qui a été généré en ammon
     * @param  idUtilisateur l'id de l'utilisateur en session
     * @return               CommandeDo la commande qui doit être enregistré en base de donnée
     */
    public static CommandeDo mapperPanierDtoToDo(final PanierDto panier, final AdressesDto adresses, final String reference,
            final Integer idUtilisateur) {
        final var commandeDo = new CommandeDo();
        commandeDo.setId(null);
        commandeDo.setReference(reference);
        commandeDo.setDate(new Date());
        commandeDo.setPrixSansRemise(DecimalFormatUtils.bigDecimalFormatUtil(panier.getPrixTotalAffichage()));
        commandeDo.setPrixTotal(DecimalFormatUtils.bigDecimalFormatUtil(panier.getPrixApresRemiseAffichage()));
        commandeDo.setQuantiteTotale(calculerQuantiteTotal(panier));
        commandeDo.setIdUtilisateur(idUtilisateur);
        commandeDo.setCommandeProduitDoSet(CommandeProduitMapper.mapperMapDtoToSetDo(panier.getMapPanier(), commandeDo));
        commandeDo.setAdresseFacturation(adresses.getCommandeAdresseFacturation().getAdresse());
        commandeDo.setAdresseLivraison(adresses.getCommandeAdresseLivraison().getAdresse());
        return commandeDo;
    }

    private static int calculerQuantiteTotal(final PanierDto panier) {
        var quantiteTotal = 0;
        for (LigneCommandeProduitDto ligneProduit : panier.getMapPanier().values()) {
            quantiteTotal += ligneProduit.getQuantite();
        }
        return quantiteTotal;
    }
}
