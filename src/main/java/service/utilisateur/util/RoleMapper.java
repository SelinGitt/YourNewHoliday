package service.utilisateur.util;

import java.util.List;
import java.util.stream.Collectors;

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
     * @return        roleDto mappe
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
     * @return         roleDo mappe
     */
    public static RoleDo mapperToDo(final RoleDto roleDto) {
        final var roleDo = new RoleDo();

        roleDo.setIdRole(roleDto.getIdRole());
        roleDo.setLibelle(roleDto.getLibelle());

        return roleDo;
    }

    /**
     * Permet de map une liste de RoleDo en une liste de RoleDto
     * 
     * @param  roleDoList Liste a map
     * @return            Liste mappee
     */
    public static List<RoleDto> mapperToListDto(final List<RoleDo> roleDoList) {
        return roleDoList.stream().map(RoleMapper::mapperToDto).collect(Collectors.toList());
    }
}
