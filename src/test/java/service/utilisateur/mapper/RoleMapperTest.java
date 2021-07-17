/**
 * 
 */
package service.utilisateur.util;

import org.junit.jupiter.api.Assertions;
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

        role.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        role.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        final var roleDtoMapper = RoleMapper.mapperToDto(role);

        Assertions.assertNotNull(role);

        Assertions.assertEquals(role.getIdRole(), roleDtoMapper.getIdRole());
        Assertions.assertEquals(role.getLibelle(), roleDtoMapper.getLibelle());

    }

    /**
     * Test method for {@link service.utilisateur.util.RoleMapper#mapperToDo(presentation.utilisateur.dto.RoleDto)}.
     */
    @Test
    void testMapperToDo() {
        final RoleDto roleDto = new RoleDto();

        roleDto.setIdRole(UtilisateurRoleEnum.ADMINISTRATEUR.getId());
        roleDto.setLibelle(UtilisateurRoleEnum.ADMINISTRATEUR.getLibelle());

        final var roleDoMapper = RoleMapper.mapperToDo(roleDto);

        Assertions.assertNotNull(roleDoMapper);

        Assertions.assertEquals(roleDto.getIdRole(), roleDoMapper.getIdRole());
        Assertions.assertEquals(roleDto.getLibelle(), roleDoMapper.getLibelle());

    }

}
