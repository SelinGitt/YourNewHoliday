/**
 * 
 */
package service.utilisateur.mapper;

import java.util.List;
import java.util.stream.Collectors;

import persistance.utilisateur.entity.DroitDo;
import persistance.utilisateur.entity.PossedeDo;
import presentation.utilisateur.dto.DroitDto;

/**
 * Classe DroitMapper <br>
 * Permet de mapper un DO en DTO, DTO en DO
 * 
 * @author Valentin
 */
public class DroitMapper {

    /**
     * Constructor
     */
    private DroitMapper() {
        // Empty CTR, on cache le CTR public
    }

    /**
     * Permet de map un {@link DroitDo} en {@link DroitDto}
     *
     * @param  droitDo droitDo a map
     * @return         droitDto mappe
     */
    public static DroitDto mapperToDto(final DroitDo droitDo) {
        final var droitDto = new DroitDto();

        droitDto.setUrl(droitDo.getUrl());
        droitDto.setRole(RoleMapper.mapperToListDto(droitDo.getPossede().stream().map(PossedeDo::getRole).collect(Collectors.toList())));
        return droitDto;
    }

    /**
     * Permet de map un {@link DroitDto} en {@link DroitDo}
     *
     * @param  droitDto DroitDto a map
     * @return          DroitDo mappe
     */
    public static DroitDo mapperToDo(final DroitDto droitDto) {
        final var droitDo = new DroitDo();

        droitDo.setUrl(droitDto.getUrl());

        return droitDo;
    }

    /**
     * Permet de map une liste de DroitDo en une liste de DroitDto
     * 
     * @param  droitDoList Liste a map
     * @return             Liste mappe
     */
    public static List<DroitDto> mapperToListDto(final List<DroitDo> droitDoList) {
        return droitDoList.stream().map(DroitMapper::mapperToDto).collect(Collectors.toList());
    }
}
