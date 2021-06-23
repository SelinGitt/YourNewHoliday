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
 * Classe repr�sentant ProduitAcheteMapper
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
     * @param  produitAcheteDo le produitAchete � mapper
     * @return                 le produitAchete mapp�
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
     * @param  listeProduitAcheteDo la liste � mapper
     * @return                      la liste mapp�e
     */
    public static List<ProduitAcheteDto> mapperListDoToDto(final List<ProduitAcheteDo> listeProduitAcheteDo) {
        return listeProduitAcheteDo.stream().map(ProduitAcheteMapper::mapperToDto).collect(Collectors.toList());
    }

}
