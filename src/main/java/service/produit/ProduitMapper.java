/**
 * 
 */
package service.produit;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import persistance.produit.entity.ProduitDo;
import presentation.produit.dto.ProduitDto;
import service.util.DecimalFormatUtils;

/**
 * Classe Mapper de produit, mappant un produitDto vers un produitDo et vice versa
 *
 * @author Administrateur
 */
public class ProduitMapper {
    private ProduitMapper() {
        //empty Method
    }

    /**
     * Permet de mapper un produitDto vers un produitDo
     *
     * @param  produitDto le produitDto � mapper
     * @return            Le produitDo mapp�
     */
    public static ProduitDo mapToDo(final ProduitDto produitDto) {

        if (produitDto == null) {
            return null;
        }

        final var produitDo = new ProduitDo();
        final var idOriginal = produitDto.getIdProduitOriginal();

        // En Java 8 : permet de g�rer l'id null lors de la cr�ation d'un produit et l'id existant pour l'�dition
        produitDo.setIdProduitOriginal(Optional.ofNullable(idOriginal).map(Integer::parseInt).orElse(null));

        produitDo.setVersion(Integer.valueOf(produitDto.getVersion()));
        produitDo.setReference(produitDto.getReference());
        produitDo.setNom(produitDto.getNom());
        produitDo.setDescription(produitDto.getDescription());
        produitDo.setDestination(produitDto.getDestination());
        if (DecimalFormatUtils.isPrixAVirgule(produitDto.getPrixUnitaire())) {
            produitDo.setPrixUnitaire(Double.valueOf(produitDto.getPrixUnitaire().replace(",", ".")));
        } else {
            produitDo.setPrixUnitaire(Double.valueOf(produitDto.getPrixUnitaire()));
        }
        produitDo.setHebergement(produitDto.getHebergement());
        produitDo.setMiseEnVente(Boolean.valueOf(produitDto.getMiseEnVente()));
        produitDo.setCheminImage(produitDto.getCheminImage());
        produitDo.setServices(Integer.valueOf(produitDto.getServices()));
        produitDo.setVersion(Integer.valueOf(produitDto.getVersion()));

        return produitDo;
    }

    /**
     * Permet de mapper un produitDo vers un ProduitDto
     *
     * @param  produitDo le produitDo � mapper
     * @return           le ProduitDto mapp�
     */
    public static ProduitDto mapToDto(final ProduitDo produitDo) {
        if (produitDo == null) {
            return null;
        }
        final var produitDto = new ProduitDto();
        produitDto.setIdProduitOriginal(String.valueOf(produitDo.getIdProduitOriginal()));
        produitDto.setVersion(String.valueOf(produitDo.getVersion()));
        produitDto.setReference(produitDo.getReference());
        produitDto.setNom(produitDo.getNom());
        produitDto.setDescription(produitDo.getDescription());
        produitDto.setDestination(produitDo.getDestination());
        produitDto.setPrixUnitaire(DecimalFormatUtils.decimalFormatUtil(produitDo.getPrixUnitaire()));
        produitDto.setHebergement(produitDo.getHebergement());
        produitDto.setMiseEnVente(String.valueOf(produitDo.getMiseEnVente()));
        produitDto.setCheminImage(produitDo.getCheminImage());
        produitDto.setServices(String.valueOf(produitDo.getServices()));
        produitDto.setVersion(String.valueOf(produitDo.getVersion()));

        return produitDto;
    }

    /**
     * Permet de mapper une liste de produitDo en liste de produitDto
     *
     * @param  listeProduit la liste de produit � mapper
     * @return              la liste de produit mapp�e
     */
    public static List<ProduitDto> mapToListDto(final List<ProduitDo> listeProduit) {
        return listeProduit.stream().map(ProduitMapper::mapToDto).collect(Collectors.toList());
    }
}
