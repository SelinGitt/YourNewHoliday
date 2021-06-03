package service.utilisateur.util;

import persistance.utilisateur.entity.RoleDo;
import presentation.utilisateur.dto.RoleDto;

/**
 * Classe RoleMapper <br>
 * Permet de mapper un DO en DTO, DTO en DO
 * 
 * @author Valentin
 */
public class RoleMapper {

    /**
     * Constructor
     */
    private RoleMapper() {
        // Empty CTR, on cache le CTR public
    }

    /**
     * Permet de map un {@link RoleDo} en {@link RoleDto}
     *
     * @param  roleDo roleDo a map
     * @return        roleDto mapper
     */
    public static RoleDto mapperToDto(final RoleDo roleDo) {
        final var roleDto = new RoleDto();

        roleDto.setIdRole(roleDo.getIdRole());
        roleDto.setLibelle(roleDo.getLibelle());

        return roleDto;
    }

    /**
     * Permet de map un {@link RoleDto} en {@link RoleDo}
     *
     * @param  roleDto roleDto a map
     * @return         roleDo mapper
     */
    public static RoleDo mapperToDo(final RoleDto roleDto) {
        final var roleDo = new RoleDo();

        roleDo.setIdRole(roleDto.getIdRole());
        roleDo.setLibelle(roleDto.getLibelle());

        return roleDo;
    }
}
