/**
 * 
 */
package service.utilisateur.mapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import persistance.utilisateur.entity.DroitDo;
import presentation.utilisateur.dto.DroitDto;

/**
 * JUnit test pour {@link service.utilisateur.mapper.DroitMapper}
 * 
 * @author Chamalo
 */
class DroitMapperTest {

    /**
     * Test method for {@link service.utilisateur.mapper.DroitMapper#mapperToDto(persistance.utilisateur.entity.DroitDo)}.
     */
    @Test
    void testMapperToDto() {
        final DroitDo droit = new DroitDo();

        droit.setIdDroit(1);
        droit.setUrl("test.do");
        droit.setPossede(Collections.emptyList());

        final var droitDtoMapper = DroitMapper.mapperToDto(droit);

        Assertions.assertNotNull(droitDtoMapper);

        Assertions.assertEquals(droit.getUrl(), droitDtoMapper.getUrl());

    }

    /**
     * Test method for {@link service.utilisateur.mapper.DroitMapper#mapperToDo(presentation.utilisateur.dto.DroitDto)}.
     */
    @Test
    void testMapperToDo() {
        final DroitDto droitDto = new DroitDto();

        droitDto.setUrl("test.do");

        final var droitDoMapper = DroitMapper.mapperToDo(droitDto);

        Assertions.assertNotNull(droitDoMapper);

        Assertions.assertEquals(droitDto.getUrl(), droitDoMapper.getUrl());
    }

    /**
     * Test method for {@link service.utilisateur.mapper.DroitMapper#mapperToListDto(List)}.
     */
    @Test
    void testMapperListe() {
        final DroitDo droit1 = new DroitDo();
        final DroitDo droit2 = new DroitDo();

        droit1.setIdDroit(1);
        droit2.setIdDroit(2);

        droit1.setUrl("test1");
        droit2.setUrl("test2");

        droit1.setPossede(Collections.emptyList());
        droit2.setPossede(Collections.emptyList());

        final List<DroitDto> listDroitsDto = DroitMapper.mapperToListDto(Arrays.asList(droit1, droit2));

        Assertions.assertNotNull(listDroitsDto);
        Assertions.assertEquals(2, listDroitsDto.size());
    }

}
