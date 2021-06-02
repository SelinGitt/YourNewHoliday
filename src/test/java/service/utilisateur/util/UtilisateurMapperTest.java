package service.utilisateur.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.UtilisateurDto;

/**
 * JUnit test pour {@link service.utilisateur.util.UtilisateurMapper}
 *
 * @author Valentin
 */
class UtilisateurMapperTest {

    /**
     * Test de {@link service.utilisateur.util.UtilisateurMapper#mapperToDo(presentation.utilisateur.dto.UtilisateurDto)}
     */
    @Test
    void testMapToDo() {
        final var utilisateurDto = new UtilisateurDto();

        utilisateurDto.setEmail("email_dto@test.fr");
        utilisateurDto.setReference("123abc");
        utilisateurDto.setDateInscription(Date.from(Instant.now()));
        utilisateurDto.setNom("Jean");
        utilisateurDto.setPrenom("Michel");
        utilisateurDto.setEstActif(true);

        final var utilisateurDoMapper = UtilisateurMapper.mapperToDo(utilisateurDto);

        Assertions.assertNotNull(utilisateurDoMapper);

        Assertions.assertEquals(utilisateurDto.getEmail(), utilisateurDoMapper.getEmail());
        Assertions.assertEquals(utilisateurDto.getReference(), utilisateurDoMapper.getReference());
        Assertions.assertEquals(utilisateurDto.getDateInscription(), utilisateurDoMapper.getDateInscription());
        Assertions.assertEquals(utilisateurDto.getNom(), utilisateurDoMapper.getNom());
        Assertions.assertEquals(utilisateurDto.getPrenom(), utilisateurDoMapper.getPrenom());
        Assertions.assertEquals(utilisateurDto.getEstActif(), utilisateurDoMapper.getEstActif());
    }

    /**
     * Test de {@link service.utilisateur.util.UtilisateurMapper#mapperToDto(UtilisateurDo)}
     */
    @Test
    void testMapToDto() {
        final var utilisateurDo = new UtilisateurDo();

        utilisateurDo.setEmail("email_do@test.fr");
        utilisateurDo.setReference("456def");
        utilisateurDo.setDateInscription(Date.from(Instant.now()));
        utilisateurDo.setNom("Dupond");
        utilisateurDo.setPrenom("Brice");
        utilisateurDo.setEstActif(true);

        final var utilisateurDtoMapper = UtilisateurMapper.mapperToDto(utilisateurDo);

        Assertions.assertNotNull(utilisateurDtoMapper);

        Assertions.assertEquals(utilisateurDo.getEmail(), utilisateurDtoMapper.getEmail());
        Assertions.assertEquals(utilisateurDo.getReference(), utilisateurDtoMapper.getReference());
        Assertions.assertEquals(utilisateurDo.getDateInscription(), utilisateurDtoMapper.getDateInscription());
        Assertions.assertEquals(utilisateurDo.getNom(), utilisateurDtoMapper.getNom());
        Assertions.assertEquals(utilisateurDo.getPrenom(), utilisateurDtoMapper.getPrenom());
        Assertions.assertEquals(utilisateurDo.getEstActif(), utilisateurDtoMapper.getEstActif());
    }

    /**
     * Test de {@link service.utilisateur.util.UtilisateurMapper#mapperToListDto(java.util.List)}
     */
    @Test
    void testMapToListDto() {
        final List<UtilisateurDo> utilisateurDoList = new ArrayList<>();

        final var utilisateurDo1 = new UtilisateurDo();

        utilisateurDo1.setEmail("email_dto@test.fr");
        utilisateurDo1.setReference("123abc");
        utilisateurDo1.setDateInscription(Date.from(Instant.now()));
        utilisateurDo1.setNom("Jean");
        utilisateurDo1.setPrenom("Michel");
        utilisateurDo1.setEstActif(true);

        final var utilisateurDo2 = new UtilisateurDo();

        utilisateurDo2.setEmail("email_do@test.fr");
        utilisateurDo2.setReference("456def");
        utilisateurDo2.setDateInscription(Date.from(Instant.now()));
        utilisateurDo2.setNom("Dupond");
        utilisateurDo2.setPrenom("Brice");
        utilisateurDo2.setEstActif(true);

        final List<UtilisateurDto> utilisateurDtoList = UtilisateurMapper.mapperToListDto(utilisateurDoList);

        Assertions.assertEquals(utilisateurDoList.size(), utilisateurDtoList.size());
    }
    
    /**
     * Test de {@link service.utilisateur.util.UtilisateurMapper#mapperToConnecteDto(java.util.List)}
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
        utilisateurDo.setEstActif(true);
        
        final var utilisateurConnecteDto = UtilisateurMapper.mapperToConnecteDto(utilisateurDo);
        
        Assertions.assertEquals("123", utilisateurConnecteDto.getIdUtilisateur());
        Assertions.assertEquals("Jean", utilisateurConnecteDto.getNom());
        Assertions.assertEquals("Michel",  utilisateurConnecteDto.getPrenom());
    }
}
