package service.utilisateur.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import persistance.utilisateur.entity.RoleDo;
import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.util.MDPCrypter;
import service.utilisateur.util.UtilisateurRoleEnum;

/**
 * JUnit test pour {@link service.utilisateur.mapper.UtilisateurMapper}
 *
 * @author Valentin
 */
class UtilisateurMapperTest {

    /**
     * Test de {@link service.utilisateur.mapper.UtilisateurMapper#mapperToDo(presentation.utilisateur.dto.UtilisateurDto)}
     */
    @Test
    void testMapToDo() {
        //TODO : Quand upload img ok, tester également le chemin de l'avatar dans ce test
        final var utilisateurDto = new UtilisateurDto();

        utilisateurDto.setId(2);
        utilisateurDto.setEmail("email_dto@test.fr");
        utilisateurDto.setReference("123abc");
        utilisateurDto.setDateInscription("12/04/2021");
        utilisateurDto.setNom("Jean");
        utilisateurDto.setPrenom("Michel");
        utilisateurDto.setEstDesactive(true);
        utilisateurDto.setDateNaissance("15/06/1994");
        utilisateurDto.setAdresse("19 rue Test, 59000, Lille");
        utilisateurDto.setPassword("test");
        utilisateurDto.setCheminAvatar("avatar");

        final var roleDto = new RoleDto();

        roleDto.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDto.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDto.setRole(roleDto);

        final var utilisateurDoMapper = UtilisateurMapper.mapperToDo(utilisateurDto);

        Assertions.assertNotNull(utilisateurDoMapper);

        Assertions.assertEquals(utilisateurDto.getId(), utilisateurDoMapper.getIdUtilisateur());
        Assertions.assertEquals(utilisateurDto.getEmail(), utilisateurDoMapper.getEmail());
        Assertions.assertEquals(utilisateurDto.getReference(), utilisateurDoMapper.getReference());
        Assertions.assertEquals("Mon Apr 12 00:00:00 CEST 2021", utilisateurDoMapper.getDateInscription().toString());
        Assertions.assertEquals(utilisateurDto.getNom(), utilisateurDoMapper.getNom());
        Assertions.assertEquals(utilisateurDto.getPrenom(), utilisateurDoMapper.getPrenom());
        Assertions.assertEquals(utilisateurDto.getEstDesactive(), utilisateurDoMapper.getEstDesactive());
        Assertions.assertEquals(utilisateurDto.getRole().getIdRole(), utilisateurDoMapper.getRole().getIdRole());
        Assertions.assertEquals(utilisateurDto.getRole().getLibelle(), utilisateurDoMapper.getRole().getLibelle());
        Assertions.assertEquals("Wed Jun 15 00:00:00 CEST 1994", utilisateurDoMapper.getDateNaissance().toString());
        Assertions.assertEquals(utilisateurDto.getAdresse(), utilisateurDoMapper.getAdresse());
        Assertions.assertEquals(utilisateurDto.getCheminAvatar(), utilisateurDoMapper.getCheminAvatar());

        Assertions.assertEquals(MDPCrypter.crypterMDPV1(utilisateurDto.getPassword()), utilisateurDoMapper.getMdpHash());
    }

    /**
     * Test de {@link service.utilisateur.mapper.UtilisateurMapper#mapperToDto(UtilisateurDo)}
     */
    @Test
    void testMapToDto() {
        final var utilisateurDo = new UtilisateurDo();

        utilisateurDo.setIdUtilisateur(2);
        utilisateurDo.setEmail("email_do@test.fr");
        utilisateurDo.setReference("456def");
        utilisateurDo.setDateInscription(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        utilisateurDo.setNom("Dupond");
        utilisateurDo.setPrenom("Brice");
        utilisateurDo.setEstDesactive(true);
        utilisateurDo.setDateNaissance(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        utilisateurDo.setAdresse("19 rue Test, 59000, Lille");
        utilisateurDo.setMdpHash("test");
        utilisateurDo.setCheminAvatar("avatar");

        final var roleDo = new RoleDo();

        roleDo.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDo.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo.setRole(roleDo);

        final var utilisateurDtoMapper = UtilisateurMapper.mapperToDto(utilisateurDo);

        Assertions.assertNotNull(utilisateurDtoMapper);

        Assertions.assertEquals(utilisateurDo.getIdUtilisateur(), utilisateurDtoMapper.getId());
        Assertions.assertEquals(utilisateurDo.getEmail(), utilisateurDtoMapper.getEmail());
        Assertions.assertEquals(utilisateurDo.getReference(), utilisateurDtoMapper.getReference());
        Assertions.assertEquals("12/04/2021", utilisateurDtoMapper.getDateInscription());
        Assertions.assertEquals(utilisateurDo.getNom(), utilisateurDtoMapper.getNom());
        Assertions.assertEquals(utilisateurDo.getPrenom(), utilisateurDtoMapper.getPrenom());
        Assertions.assertEquals(utilisateurDo.getEstDesactive(), utilisateurDtoMapper.getEstDesactive());
        Assertions.assertEquals(utilisateurDo.getRole().getIdRole(), utilisateurDtoMapper.getRole().getIdRole());
        Assertions.assertEquals(utilisateurDo.getRole().getLibelle(), utilisateurDtoMapper.getRole().getLibelle());
        Assertions.assertEquals("12/04/2021", utilisateurDtoMapper.getDateNaissance());
        Assertions.assertEquals(utilisateurDo.getAdresse(), utilisateurDtoMapper.getAdresse());
        Assertions.assertEquals(utilisateurDo.getCheminAvatar(), utilisateurDtoMapper.getCheminAvatar());

        Assertions.assertEquals(utilisateurDo.getMdpHash(), utilisateurDtoMapper.getPassword());
    }

    /**
     * Test de {@link service.utilisateur.mapper.UtilisateurMapper#mapperToListDto(java.util.List)}
     */
    @Test
    void testMapToListDto() {
        final List<UtilisateurDo> utilisateurDoList = new ArrayList<>();

        final var utilisateurDo1 = new UtilisateurDo();

        utilisateurDo1.setEmail("email_dto@test.fr");
        utilisateurDo1.setReference("123abc");
        utilisateurDo1.setDateInscription(Date.from(Instant.now()));
        utilisateurDo1.setDateNaissance(Date.from(Instant.now()));
        utilisateurDo1.setNom("Jean");
        utilisateurDo1.setPrenom("Michel");
        utilisateurDo1.setEstDesactive(true);
        utilisateurDo1.setAdresse("19 rue Test, 59000, Lille");

        final var roleDo = new RoleDo();

        roleDo.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDo.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo1.setRole(roleDo);

        final var utilisateurDo2 = new UtilisateurDo();

        utilisateurDo2.setEmail("email_do@test.fr");
        utilisateurDo2.setReference("456def");
        utilisateurDo2.setDateInscription(Date.from(Instant.now()));
        utilisateurDo2.setDateNaissance(Date.from(Instant.now()));
        utilisateurDo2.setNom("Dupond");
        utilisateurDo2.setPrenom("Brice");
        utilisateurDo2.setEstDesactive(true);
        utilisateurDo2.setAdresse("19 rue Test, 59000, Lille");

        final var roleDo2 = new RoleDo();

        roleDo.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDo.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo2.setRole(roleDo2);

        final List<UtilisateurDto> utilisateurDtoList = UtilisateurMapper.mapperToListDto(utilisateurDoList);

        Assertions.assertEquals(utilisateurDoList.size(), utilisateurDtoList.size());
    }

    /**
     * Test de {@link service.utilisateur.mapper.UtilisateurMapper#mapperToConnecteDto(java.util.List)}
     */
    @Test
    void testMapToConnecteDto() {
        final var utilisateurDo = new UtilisateurDo();

        utilisateurDo.setIdUtilisateur(123);
        utilisateurDo.setEmail("email_dto@test.fr");
        utilisateurDo.setReference("123abc");
        utilisateurDo.setDateInscription(Date.from(Instant.now()));
        utilisateurDo.setNom("Jean");
        utilisateurDo.setPrenom("Michel");
        utilisateurDo.setEstDesactive(true);

        final var roleDo = new RoleDo();

        roleDo.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDo.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo.setRole(roleDo);

        final var utilisateurConnecteDto = UtilisateurMapper.mapperToConnecteDto(utilisateurDo);

        Assertions.assertEquals("123", utilisateurConnecteDto.getIdUtilisateur());
        Assertions.assertEquals("Jean", utilisateurConnecteDto.getNom());
        Assertions.assertEquals("Michel", utilisateurConnecteDto.getPrenom());
    }
}
