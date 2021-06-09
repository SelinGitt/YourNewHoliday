package service.utilisateur.impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.RoleDo;
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

        final RoleDo role = new RoleDo();

        role.setIdRole(1);
        role.setLibelle("Client");

        userDo.setRole(role);

        Mockito.when(this.dao.findAll()).thenReturn(Collections.singletonList(userDo));
        Assertions.assertEquals(1, this.utilisateurService.findAllUtilisateurs().size());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()}
     */
    @ParameterizedTest
    @CsvSource({"email, password, true", "email, wrong password, false"})
    void testAuthentifyEmailOK(final String email, final String password, final String check) {

        //On crée l'utilisateurDo qu'on récupère en BD
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email");
        utilisateurDo.setMdpHash("password");
        utilisateurDo.setNom("nom");

        Mockito.when(this.dao.findByEmail(email)).thenReturn(utilisateurDo);

        //On tente une authentification 
        final UtilisateurConnecteDto utilisateurConnecteDto = this.utilisateurService.authentify(email, password);

        //L'argument "true" sert à indiquer qu'on attend une authentification réussie
        if (check.equals("true")) {
            Assertions.assertNotNull(utilisateurConnecteDto);
            Assertions.assertEquals("nom", utilisateurConnecteDto.getNom());
        } else {
            Assertions.assertNull(utilisateurConnecteDto);
        }
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()}
     */
    @ParameterizedTest
    @CsvSource({"wrong email, password", "wrong email, wrong password"})
    void testAuthentifyEmailKO(final String email, final String password) {

        //On teste avec un email non valide, findByEmail renvoie ddonc toujours null
        Mockito.when(this.dao.findByEmail(email)).thenReturn(null);

        final UtilisateurConnecteDto utilisateurConnecteDto = this.utilisateurService.authentify(email, password);
        Assertions.assertNull(utilisateurConnecteDto);
    }
}
