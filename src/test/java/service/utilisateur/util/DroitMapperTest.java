/**
 * 
 */
package service.utilisateur.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import persistance.utilisateur.entity.DroitDo;
import presentation.utilisateur.dto.DroitDto;

/**
 * JUnit test pour {@link service.utilisateur.util.DroitMapper}
 * 
 * @author Chamalo
 */
class DroitMapperTest {

    /**
     * Test method for {@link service.utilisateur.util.DroitMapper#mapperToDto(persistance.utilisateur.entity.DroitDo)}.
     */
    @Test
    void testMapperToDto() {
        final DroitDo droit = new DroitDo();

        droit.setIdDroit(1);
        droit.setUrl("test.do");

        final var droitDtoMapper = DroitMapper.mapperToDto(droit);

        Assertions.assertNotNull(droitDtoMapper);

        Assertions.assertEquals(droit.getIdDroit(), droitDtoMapper.getIdDroit());
        Assertions.assertEquals(droit.getUrl(), droitDtoMapper.getUrl());

    }

    /**
     * Test method for {@link service.utilisateur.util.DroitMapper#mapperToDo(presentation.utilisateur.dto.DroitDto)}.
     */
    @Test
    void testMapperToDo() {
        final DroitDto droitDto = new DroitDto();

        droitDto.setIdDroit(1);
        droitDto.setUrl("test.do");

        final var droitDoMapper = DroitMapper.mapperToDo(droitDto);

        Assertions.assertNotNull(droitDoMapper);

        Assertions.assertEquals(droitDto.getIdDroit(), droitDoMapper.getIdDroit());
        Assertions.assertEquals(droitDto.getUrl(), droitDoMapper.getUrl());
    }

    /**
     * Test method for {@link service.utilisateur.util.DroitMapper#mapperToListDto(List)}.
     */
    @Test
    void testMapperListe() {
        final DroitDo droit1 = new DroitDo();
        final DroitDo droit2 = new DroitDo();

        droit1.setIdDroit(1);
        droit2.setIdDroit(2);

        droit1.setUrl("test1");
        droit2.setUrl("test2");

        final List<DroitDto> listDroitsDto = DroitMapper.mapperToListDto(Arrays.asList(droit1, droit2));

        Assertions.assertNotNull(listDroitsDto);
        Assertions.assertEquals(2, listDroitsDto.size());
    }

}
