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
import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.UtilisateurConnecteDto;

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

        Mockito.when(this.dao.findAll()).thenReturn(Collections.singletonList(userDo));
        Assertions.assertEquals(1, this.utilisateurService.findAllUtilisateurs().size());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()}
     */
    @Test
    void testAuthentifyOK() {
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email");
        utilisateurDo.setMdpHash("password");
        utilisateurDo.setNom("nom");

        final String email = "email";
        final String password = "password";

        final UtilisateurConnecteDto utilisateurConnecteDto = new UtilisateurConnecteDto();
        utilisateurConnecteDto.setNom("nom");

        Mockito.when(this.dao.findByEmail("email")).thenReturn(utilisateurDo);

        final UtilisateurConnecteDto user = this.utilisateurService.authentify(email, password);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(utilisateurConnecteDto.getNom(), user.getNom());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()} <br>
     * Email mauvais, password ok
     */
    @Test
    void testAuthentifyKO() {
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email");
        utilisateurDo.setMdpHash("password");
        utilisateurDo.setNom("nom");

        final String email = "wrong email";
        final String password = "password";

        final UtilisateurConnecteDto utilisateurConnecteDto = new UtilisateurConnecteDto();
        utilisateurConnecteDto.setNom("nom");

        Mockito.when(this.dao.findByEmail("email")).thenReturn(utilisateurDo);
        Assertions.assertNull(this.utilisateurService.authentify(email, password));
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()} <br>
     * Email ok, password mauvais
     */
    @Test
    void testAuthentifyKO2() {
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email");
        utilisateurDo.setMdpHash("password mauvais");
        utilisateurDo.setNom("nom");

        final String email = "email";
        final String password = "password";

        final UtilisateurConnecteDto utilisateurConnecteDto = new UtilisateurConnecteDto();
        utilisateurConnecteDto.setNom("nom");

        Mockito.when(this.dao.findByEmail("email")).thenReturn(utilisateurDo);
        Assertions.assertNull(this.utilisateurService.authentify(email, password));
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()} <br>
     * Email mauvais, password mauvais
     */
    @Test
    void testAuthentifyKO3() {
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email mauvais");
        utilisateurDo.setMdpHash("password mauvais");
        utilisateurDo.setNom("nom");

        final String email = "email";
        final String password = "password";

        final UtilisateurConnecteDto utilisateurConnecteDto = new UtilisateurConnecteDto();
        utilisateurConnecteDto.setNom("nom");

        Mockito.when(this.dao.findByEmail("email")).thenReturn(utilisateurDo);
        Assertions.assertNull(this.utilisateurService.authentify(email, password));
    }
}
