package service.utilisateur.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
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

    private static final UtilisateurDto utilisateurDto = new UtilisateurDto();
    private static final UtilisateurDo  utilisateurDo  = new UtilisateurDo();

    @BeforeClass
    void initUtilisateurs() {
        this.initDto();
    }

    /**
     * Permet d'initialiser un UtilisateurDto
     */
    void initDto() {
        utilisateurDto.setEmail("email_dto@test.fr");
        utilisateurDto.setReference("123abc");
        utilisateurDto.setDateInscription(null);
        utilisateurDto.setNom("Jean");
        utilisateurDto.setPrenom("Michel");
        utilisateurDto.setEstActif(true);
    }

    /**
     * Permet d'initialiser un UtilisaterDo
     */
    void initDo() {
        utilisateurDo.setEmail("email_do@test.fr");
        utilisateurDo.setReference("456def");
        utilisateurDo.setDateInscription(null);
        utilisateurDo.setNom("Dupond");
        utilisateurDo.setPrenom("Brice");
        utilisateurDo.setEstActif(true);
    }

    /**
     * Test de {@link service.utilisateur.util.UtilisateurMapper#mapperToDo(presentation.utilisateur.dto.UtilisateurDto)}
     */
    @Test
    void testMapToDo() {
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

        for (int i = 0; i < 5; i++) {
            utilisateurDoList.add(utilisateurDo);
        }

        final List<UtilisateurDto> utilisateurDtoList = UtilisateurMapper.mapperToListDto(utilisateurDoList);

        for (final UtilisateurDto utilisateurDtoMapper : utilisateurDtoList) {
            Assertions.assertNotNull(utilisateurDtoMapper);

            Assertions.assertEquals(utilisateurDo.getEmail(), utilisateurDtoMapper.getEmail());
            Assertions.assertEquals(utilisateurDo.getReference(), utilisateurDtoMapper.getReference());
            Assertions.assertEquals(utilisateurDo.getDateInscription(), utilisateurDtoMapper.getDateInscription());
            Assertions.assertEquals(utilisateurDo.getNom(), utilisateurDtoMapper.getNom());
            Assertions.assertEquals(utilisateurDo.getPrenom(), utilisateurDtoMapper.getPrenom());
            Assertions.assertEquals(utilisateurDo.getEstActif(), utilisateurDtoMapper.getEstActif());
        }

    }
}
