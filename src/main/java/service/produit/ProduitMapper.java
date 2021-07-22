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
     * @param  produitDto le produitDto à mapper
     * @return            Le produitDo mappé
     */
    public static ProduitDo mapToDo(final ProduitDto produitDto) {

        if (produitDto == null) {
            return null;
        }

        final var produitDo = new ProduitDo();
        final var idOriginal = produitDto.getIdProduitOriginal();

        // En Java 8 : permet de gérer l'id null lors de la création d'un produit et l'id existant pour l'édition
        produitDo.setIdProduitOriginal(Optional.ofNullable(idOriginal).map(Integer::parseInt).orElse(null));
        produitDo.setVersion(Integer.valueOf(produitDto.getVersion()));
        produitDo.setReference(produitDto.getReference());
        produitDo.setNom(produitDto.getNom());
        produitDo.setDescription(produitDto.getDescription());
        produitDo.setDestination(produitDto.getDestination());
        produitDo.setPrixUnitaire(DecimalFormatUtils.doubleFormatUtil(produitDto.getPrixUnitaire()));
        produitDo.setHebergement(produitDto.getHebergement());
        produitDo.setMiseEnVente(Boolean.valueOf(produitDto.getMiseEnVente()));
        produitDo.setCheminImage(produitDto.getCheminImage());
        produitDo.setServices(conversionBoolToInt(produitDto.getServices()));
        produitDo.setVersion(Integer.valueOf(produitDto.getVersion()));
        return produitDo;
    }

    /**
     * Permet de mapper un produitDo vers un ProduitDto
     *
     * @param  produitDo le produitDo à mapper
     * @return           le ProduitDto mappé
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
        produitDto.setServices(genererServices(produitDo.getServices()));
        produitDto.setVersion(String.valueOf(produitDo.getVersion()));

        return produitDto;
    }

    /**
     * Permet de mapper une liste de produitDo en liste de produitDto
     *
     * @param  listeProduit la liste de produit à mapper
     * @return              la liste de produit mappée
     */
    public static List<ProduitDto> mapToListDto(final List<ProduitDo> listeProduit) {
        return listeProduit.stream().map(ProduitMapper::mapToDto).collect(Collectors.toList());
    }

    private static Boolean[] genererServices(final Integer value) {
        final Boolean[] services = new Boolean[9];
        var numberToEdit = value;
        if (value != null) {
            for (int i = 8; i >= 0; i--) {
                if ((numberToEdit & 1) != 0) {
                    services[i] = true;
                } else {
                    services[i] = false;

                }
                numberToEdit >>= 1;
            }
            return services;
        }
        return null;
    }

    private static Integer conversionBoolToInt(final Boolean[] booleanArray) {
        Integer numberToConvert = 0;
        for (final Boolean b : booleanArray)
            numberToConvert = (numberToConvert << 1) | (b ? 1 : 0);
        return numberToConvert;
    }
}
