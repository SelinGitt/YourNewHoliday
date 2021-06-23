/**
 * 
 */
package service.commande;

import java.util.List;
import java.util.stream.Collectors;

import persistance.commande.entity.ProduitAcheteDo;
import presentation.commande.dto.ProduitAcheteDto;
import service.util.DecimalFormatUtils;

/**
 * Classe représentant ProduitAcheteMapper
 * 
 * @author Hanan Anghari
 */
public class ProduitAcheteMapper {

    private ProduitAcheteMapper() {
        //empty
    }

    /**
     * Permet de mapper un produitAcheteDto en produitAcheteDo
     *
     * @param  produitAcheteDo le produitAchete à mapper
     * @return                 le produitAchete mappé
     */
    public static ProduitAcheteDto mapperToDto(final ProduitAcheteDo produitAcheteDo) {
        if (produitAcheteDo == null) {
            return null;
        }
        final ProduitAcheteDto produitAcheteDto = new ProduitAcheteDto();
        produitAcheteDto.setIdProduit(String.valueOf(produitAcheteDo.getIdProduit()));
        produitAcheteDto.setReference(produitAcheteDo.getReference());
        produitAcheteDto.setNom(produitAcheteDo.getNom());
        produitAcheteDto.setDescription(produitAcheteDo.getDescription());
        produitAcheteDto.setDestination(produitAcheteDo.getDestination());
        produitAcheteDto.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(produitAcheteDo.getPrixUnitaire()));
        produitAcheteDto.setCheminDeLImage(produitAcheteDo.getCheminImage());
        return produitAcheteDto;

    }
    //TODO pas besoin 

    /**
     * Permet de mapper une liste de ProduitAchete
     *
     * @param  listeProduitAcheteDo la liste à mapper
     * @return                      la liste mappée
     */
    public static List<ProduitAcheteDto> mapperListDoToDto(final List<ProduitAcheteDo> listeProduitAcheteDo) {
        return listeProduitAcheteDo.stream().map(ProduitAcheteMapper::mapperToDto).collect(Collectors.toList());
    }

}
