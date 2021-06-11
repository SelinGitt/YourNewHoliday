/**
 * 
 */
package service.utilisateur.util;

import persistance.utilisateur.entity.DroitDo;
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

        droitDto.setIdDroit(droitDo.getIdDroit());
        droitDto.setUrl(droitDo.getUrl());

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

        droitDo.setIdDroit(droitDto.getIdDroit());
        droitDo.setUrl(droitDto.getUrl());

        return droitDo;
    }
}
