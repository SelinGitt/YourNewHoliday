/**
 * 
 */
package service.utilisateur.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import persistance.utilisateur.entity.RoleDo;
import presentation.utilisateur.dto.RoleDto;

/**
 * JUnit test pour {@link service.utilisateur.util.RoleMapper}
 *
 * @author Selin
 */
class RoleMapperTest {

    /**
     * Test method for {@link service.utilisateur.util.RoleMapper#mapperToDto(persistance.utilisateur.entity.RoleDo)}.
     */
    @Test
    void testMapperToDto() {
        final RoleDo role = new RoleDo();

        role.setIdRole(1);
        role.setLibelle("Client");

        final var roleDtoMapper = RoleMapper.mapperToDto(role);

        assertNotNull(role);

        assertEquals(role.getIdRole(), roleDtoMapper.getIdRole());
        assertEquals(role.getLibelle(), roleDtoMapper.getLibelle());

    }

    /**
     * Test method for {@link service.utilisateur.util.RoleMapper#mapperToDo(presentation.utilisateur.dto.RoleDto)}.
     */
    @Test
    void testMapperToDo() {
        final RoleDto roleDto = new RoleDto();

        roleDto.setIdRole(2);
        roleDto.setLibelle("roleDto");

        final var roleDoMapper = RoleMapper.mapperToDo(roleDto);

        assertNotNull(roleDoMapper);

        assertEquals(roleDto.getIdRole(), roleDoMapper.getIdRole());
        assertEquals(roleDto.getLibelle(), roleDoMapper.getLibelle());

    }

}
