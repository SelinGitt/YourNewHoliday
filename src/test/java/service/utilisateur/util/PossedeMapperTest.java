/**
 * 
 */
package service.utilisateur.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import persistance.utilisateur.entity.PossedeDo;
import persistance.utilisateur.entity.RoleDo;
import presentation.utilisateur.dto.PossedeDto;

/**
 * JUnit test pour {@link service.utilisateur.util.PossedeMapper}
 *
 * @author Selin
 */
class PossedeMapperTest {

    /**
     * Test method for {@link service.utilisateur.util.PossedeMapper#mapperToDto(persistance.utilisateur.entity.PossedeDo)}.
     */
    @Test
    void testMapperToDto() {
        final PossedeDo possede = new PossedeDo();
        final RoleDo role = new RoleDo();
        role.setIdRole(1);
        role.setLibelle("Client");

        possede.setId(1);
        possede.setRole(role);

        final var PossedeDtoMapper = PossedeMapper.mapperToDto(possede);

        Assertions.assertNotNull(possede);

        Assertions.assertEquals(possede.getId(), PossedeDtoMapper.getIdPossede());
        Assertions.assertEquals(possede.getRole().getLibelle(), PossedeDtoMapper.getRoleDto().getLibelle());
    }

    /**
     * Test method for {@link service.utilisateur.util.PossedeMapper#mapperToListDto(java.util.List)}.
     */
    @Test
    void testMapperToListDto() {
        final PossedeDo possede1 = new PossedeDo();
        final PossedeDo possede2 = new PossedeDo();

        final RoleDo role = new RoleDo();
        role.setIdRole(1);
        role.setLibelle("Client");

        final RoleDo role2 = new RoleDo();
        role.setIdRole(2);
        role.setLibelle("Admin");

        possede1.setId(1);
        possede2.setId(2);

        possede1.setRole(role);
        possede2.setRole(role2);

        final List<PossedeDto> listPossedeDto = PossedeMapper.mapperToListDto(Arrays.asList(possede1, possede2));

        Assertions.assertNotNull(listPossedeDto);
        Assertions.assertEquals(2, listPossedeDto.size());
    }

}
