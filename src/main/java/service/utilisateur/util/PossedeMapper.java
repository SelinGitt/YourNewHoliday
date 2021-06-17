/**
 * 
 */
package service.utilisateur.util;

import java.util.List;
import java.util.stream.Collectors;

import persistance.utilisateur.entity.PossedeDo;
import presentation.utilisateur.dto.PossedeDto;

/**
 * Classe PossedeMapper <br>
 * Permet de mapper un DO en DTO
 * 
 * @author Valentin
 */
public class PossedeMapper {

    /**
     * Constructor
     */
    private PossedeMapper() {
        // Empty ctr
    }

    /**
     * Permet de map un {@link PossedeDo} en {@link PossedeDto}
     *
     * @param  possedeDo possedeDo a map
     * @return           possedeDto mappe
     */
    public static PossedeDto mapperToDto(final PossedeDo possedeDo) {
        final var possedeDto = new PossedeDto();

        possedeDto.setIdPossede(possedeDo.getId());
        possedeDto.setRoleDto(RoleMapper.mapperToDto(possedeDo.getRole()));

        return possedeDto;
    }

    /**
     * Permet de map une liste de PossedeDo en une liste de PossedeDto
     * 
     * @param  possedeDoList Liste a map
     * @return               Liste mappee
     */
    public static List<PossedeDto> mapperToListDto(final List<PossedeDo> possedeDoList) {
        return possedeDoList.stream().map(PossedeMapper::mapperToDto).collect(Collectors.toList());
    }

}
