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

<<<<<<< HEAD
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.utilisateur.IUtilisateurService;
=======
import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.UtilisateurDo;
>>>>>>> develop

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
     * Test pour {@link service.utilisateur.impl.UtilisateurService#findByEmail()}
     */
    @Test
    void testFindByEmail() {
        //Test avec un email présent en base de données
        Assertions.assertEquals("ClientCLIENT123", iUtilisateurService.findByEmail("baratheon.robert@hotmail.com").getReference());
        //Test avec un email absent en base de données
        Assertions.assertNull(iUtilisateurService.findByEmail("emailNonExistant@hotmail.com"));
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()}
     */
    @Test
    void testAuthentify() {
        final UtilisateurConnecteDto utilisateurConnecteDto1 = iUtilisateurService.authentify("baratheon.robert@hotmail.com",
                "TestConnexionNonEncoreHashe");
        Assertions.assertNotNull(utilisateurConnecteDto1);
        final UtilisateurConnecteDto utilisateurConnecteDto2 = iUtilisateurService.authentify("emailAbsent@hotmail.com",
                "TestConnexionNonEncoreHashe");
        Assertions.assertNull(utilisateurConnecteDto2);
        final UtilisateurConnecteDto utilisateurConnecteDto3 = iUtilisateurService.authentify("baratheon.robert@hotmail.com",
                "Mauvais Mot de passe");
        Assertions.assertNull(utilisateurConnecteDto3);

    }
}
