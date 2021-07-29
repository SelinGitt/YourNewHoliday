/**
 * 
 */
package service.commande;

import persistance.commande.entity.ProduitAcheteDo;
import presentation.commande.dto.ProduitAcheteDto;
import presentation.produit.dto.ProduitDto;
import service.produit.ProduitMapper;
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
        produitAcheteDto.setVersion(String.valueOf(produitAcheteDo.getVersion()));
        produitAcheteDto.setIdDeLOriginal(String.valueOf(produitAcheteDo.getIdDeLOriginal()));
        produitAcheteDto.setReference(produitAcheteDo.getReference());
        produitAcheteDto.setNom(produitAcheteDo.getNom());
        produitAcheteDto.setDescription(produitAcheteDo.getDescription());
        produitAcheteDto.setDestination(produitAcheteDo.getDestination());
        produitAcheteDto.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(produitAcheteDo.getPrixUnitaire()));
        produitAcheteDto.setCheminDeLImage(produitAcheteDo.getCheminImage());
        return produitAcheteDto;

    }

    /**
     * Permet de mapper un ProduitDto provenant du panier en ProduitAcheteDo
     *
     * @param  produitPanier le produit provenant du panier
     * @return               ProduitAcheteDo le produit à enregistrer dans la base de données
     */
    public static ProduitAcheteDo mapperToDo(final ProduitDto produitPanier) {
        if (produitPanier == null) {
            return null;
        }
        final var produitAcheteDo = new ProduitAcheteDo();
        produitAcheteDo.setIdProduit(null);
        produitAcheteDo.setIdDeLOriginal(Integer.parseInt(produitPanier.getIdProduitOriginal()));
        produitAcheteDo.setVersion(Integer.parseInt(produitPanier.getVersion()));
        produitAcheteDo.setReference(produitPanier.getReference());
        produitAcheteDo.setNom(produitPanier.getNom());
        produitAcheteDo.setDescription(produitPanier.getDescription());
        produitAcheteDo.setDestination(produitPanier.getDestination());
        produitAcheteDo.setPrixUnitaire(DecimalFormatUtils.bigDecimalFormatUtil(produitPanier.getPrixUnitaire()));
        produitAcheteDo.setHebergement(produitPanier.getHebergement());
        produitAcheteDo.setMiseEnVente(Boolean.valueOf(produitPanier.getMiseEnVente()));
        produitAcheteDo.setCheminImage(produitPanier.getCheminImage());
        produitAcheteDo.setServices(ProduitMapper.conversionBoolToInt(produitPanier.getServices()));
        return produitAcheteDo;
    }

}
