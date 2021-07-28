package service.commande;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.CommandeDo;
import persistance.commande.entity.ProduitAcheteDo;
import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.CommandeAdresseDto;
import presentation.commande.dto.CommandeDto;
import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
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
        commandeDto.setPrixTotalAvantRemise(DecimalFormatUtils.decimalFormatUtil(commandeDo.getPrixSansRemise()));
        commandeDto.setDate(DateFormatUtil.formaterDateToString(commandeDo.getDate()));
        commandeDto.setQuantiteTotale(String.valueOf(commandeDo.getQuantiteTotale()));
        commandeDto.setListCommandeProduitDto(CommandeProduitMapper.mapperSetDoToListDto(commandeDo.getCommandeProduitDoSet()));
        commandeDto.setPrixTotalApresRemise(DecimalFormatUtils.decimalFormatUtil(commandeDo.getPrixTotalApresRemise()));
        commandeDto.setRemise(calculerRemise(commandeDto));

        final var livraisonAdresse = new CommandeAdresseDto();
        livraisonAdresse.setNom(commandeDo.getNomLivraison());
        livraisonAdresse.setPrenom(commandeDo.getPrenomLivraison());
        livraisonAdresse.setAdresse(commandeDo.getAdresseLivraison());
        commandeDto.setAdresseLivraison(livraisonAdresse);

        final var facturationAdresse = new CommandeAdresseDto();
        facturationAdresse.setNom(commandeDo.getNomFacturation());
        facturationAdresse.setPrenom(commandeDo.getPrenomFacturation());
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

    private static String calculerRemise(final CommandeDto commande) {
        return DecimalFormatUtils.decimalFormatUtil(DecimalFormatUtils.doubleFormatUtil(commande.getPrixTotalAvantRemise())
                - DecimalFormatUtils.doubleFormatUtil(commande.getPrixTotalApresRemise()));
    }

    /**
     * Permet de mapper un Panier en CommandeDo
     *
     * @param  panier        le panier en session
     * @param  adresses      les adresses entrées par l'utilisateur
     * @param  dateCommande  la date à la quelle la commande sera enregistré
     * @param  reference     la reference de la commande qui a été généré en ammon
     * @param  idUtilisateur l'id de l'utilisateur en session
     * @return               CommandeDo la commande qui doit être enregistré en base de donnée
     */
    public static CommandeDo mapperPanierDtoToDo(final PanierDto panier, final AdressesDto adresses, final Date dateCommande,
            final String reference, final Integer idUtilisateur) {
        final var commandeDo = new CommandeDo();
        commandeDo.setId(null);
        commandeDo.setReference(reference);
        commandeDo.setDate(dateCommande);
        commandeDo.setPrixSansRemise(DecimalFormatUtils.bigDecimalFormatUtil(panier.getPrixTotalAffichage()));
        commandeDo.setPrixTotalApresRemise(DecimalFormatUtils.bigDecimalFormatUtil(panier.getPrixApresRemiseAffichage()));
        commandeDo.setQuantiteTotale(panier.getNombreDeReferences());
        commandeDo.setIdUtilisateur(idUtilisateur);
        commandeDo.setCommandeProduitDoSet(CommandeProduitMapper.mapperMapDtoToSetDo(panier.getMapPanier(), commandeDo));
        final var facturationAdresse = adresses.getCommandeAdresseFacturation();
        commandeDo.setNomFacturation(facturationAdresse.getNom());
        commandeDo.setPrenomFacturation(facturationAdresse.getPrenom());
        commandeDo.setAdresseFacturation(facturationAdresse.getAdresse());
        final var livraisonAdresse = adresses.getCommandeAdresseLivraison();
        commandeDo.setNomLivraison(livraisonAdresse.getNom());
        commandeDo.setPrenomLivraison(livraisonAdresse.getPrenom());
        commandeDo.setAdresseLivraison(livraisonAdresse.getAdresse());
        return commandeDo;
    }

    /**
     * Allows to map to ProduitDto a produitAcheteDO
     *
     * @param  produitAchete to map
     * @return               mapped ProduitDto
     */
    public static ProduitDto mapToDto(final ProduitAcheteDo produitAchete) {
        if (produitAchete == null) {
            return null;
        }
        final var produitDto = new ProduitDto();
        produitDto.setIdProduitOriginal(String.valueOf(produitAchete.getIdDeLOriginal()));
        produitDto.setVersion(String.valueOf(produitAchete.getVersion()));
        produitDto.setReference(produitAchete.getReference());
        produitDto.setNom(produitAchete.getNom());
        produitDto.setDescription(produitAchete.getDescription());
        produitDto.setDestination(produitAchete.getDestination());
        produitDto.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(produitAchete.getPrixUnitaire()));
        produitDto.setHebergement(produitAchete.getHebergement());
        produitDto.setMiseEnVente(String.valueOf(produitAchete.getMiseEnVente()));
        produitDto.setCheminImage(produitAchete.getCheminImage());
        produitDto.setServices(String.valueOf(produitAchete.getServices()));
        produitDto.setVersion(String.valueOf(produitAchete.getVersion()));
        return produitDto;
    }
}
