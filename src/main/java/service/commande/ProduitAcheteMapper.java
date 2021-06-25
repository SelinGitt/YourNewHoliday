/**
 * 
 */
package service.commande;

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
        final var produitAcheteDto = new ProduitAcheteDto();
        produitAcheteDto.setIdProduit(String.valueOf(produitAcheteDo.getIdProduit()));
        produitAcheteDto.setIdDeLOriginal(String.valueOf(produitAcheteDo.getIdDeLOriginal()));
        produitAcheteDto.setReference(produitAcheteDo.getReference());
        produitAcheteDto.setNom(produitAcheteDo.getNom());
        produitAcheteDto.setDescription(produitAcheteDo.getDescription());
        produitAcheteDto.setDestination(produitAcheteDo.getDestination());
        produitAcheteDto.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(produitAcheteDo.getPrixUnitaire()));
        produitAcheteDto.setCheminDeLImage(produitAcheteDo.getCheminImage());
        return produitAcheteDto;

    }

}
