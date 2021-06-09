package service.utilisateur.impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.RoleDo;
import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.util.UtilisateurMapper;

/**
 * JUnit test classe pour {@link service.utilisateur.impl.UtilisateurService}
 *
 * @author Valentin
 */
class UtilisateurServiceTest {

    @Mock
    private IUtilisateurDao    dao;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test pour {@link service.utilisateur.IUtilisateurService#findAllUtilisateurs()}, retourne liste vide
     */
    @Test
    void testFindAll() {
        Mockito.when(this.dao.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertEquals(0, this.utilisateurService.findAllUtilisateurs().size());
    }

    /**
     * Test pour {@link service.utilisateur.IUtilisateurService#findAllUtilisateurs()}, retourne 1 utilisateur
     */
    @Test
    void testFindAll2() {
        final UtilisateurDo userDo = new UtilisateurDo();

        userDo.setDateInscription(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        userDo.setDateNaissance(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());

        final RoleDo role = new RoleDo();

        role.setIdRole(1);
        role.setLibelle("Client");

        userDo.setRole(role);

        Mockito.when(this.dao.findAll()).thenReturn(Collections.singletonList(userDo));
        Assertions.assertEquals(1, this.utilisateurService.findAllUtilisateurs().size());
    }

    /**
     * Test pour {@link service.utilisateur.IUtilisateurService#createUtilisateur(UtilisateurDto)}
     */
    @Test
    void testCreate() {
        final UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setReference("ABC123");
        utilisateurDto.setEmail("test@test.fr");
        utilisateurDto.setNom("Nom");
        utilisateurDto.setPrenom("Prenom");
        utilisateurDto.setPassword("Hash");
        utilisateurDto.setDateInscription("09/06/2021");
        utilisateurDto.setDateNaissance("09/06/2021");
        utilisateurDto.setEstActif(true);
        utilisateurDto.setAdresse("19 rue Test, 59000, Lille");

        final RoleDto role = new RoleDto();
        role.setIdRole(1);

        utilisateurDto.setRole(role);

        Mockito.when(this.dao.create(Mockito.any(UtilisateurDo.class))).thenReturn(UtilisateurMapper.mapperToDo(utilisateurDto));

        final UtilisateurDto utilisateurCreated = this.utilisateurService.createUtilisateur(utilisateurDto);

        Assertions.assertNotNull(utilisateurCreated);
    }
}
