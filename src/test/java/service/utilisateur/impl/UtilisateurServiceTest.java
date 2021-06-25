package service.utilisateur.impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.commande.dao.ICommandeDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.RoleDo;
import persistance.utilisateur.entity.UtilisateurDo;
import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
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

    @Mock
    private ICommandeDao       commandeDao;

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
        utilisateurDto.setEstDesactive(true);
        utilisateurDto.setAdresse("19 rue Test, 59000, Lille");

        final RoleDto role = new RoleDto();
        role.setIdRole(1);

        utilisateurDto.setRole(role);

        Mockito.when(this.dao.create(Mockito.any(UtilisateurDo.class))).thenReturn(UtilisateurMapper.mapperToDo(utilisateurDto));

        final UtilisateurDto utilisateurCreated = this.utilisateurService.createUtilisateur(utilisateurDto);

        Assertions.assertNotNull(utilisateurCreated);
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()}
     */
    @ParameterizedTest
    @CsvSource({"email, password, true", "email, wrong password, false"})
    void testAuthentifyEmailOK(final String email, final String password, final String check) {

        //On cr�e l'utilisateurDo qu'on r�cup�re en BD
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email");
        //Correspond au hash de "password"
        utilisateurDo.setMdpHash("B0FBB24B2497D66890D0BBF15034768B8BD7557E094D512A52AD0F0C58FA0AB8");
        utilisateurDo.setNom("nom");

        final RoleDo roleDo = new RoleDo();
        roleDo.setIdRole(1);
        roleDo.setLibelle("libelle");

        utilisateurDo.setRole(roleDo);

        Mockito.when(this.dao.findByEmail(email)).thenReturn(utilisateurDo);

        //On tente une authentification 
        final UtilisateurConnecteDto utilisateurConnecteDto = this.utilisateurService.authentify(email, password);

        //L'argument "true" sert � indiquer qu'on attend une authentification r�ussie
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

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#rechercherUtilisateur(String)}
     */
    @Test
    void testRecherche() {
        Mockito.when(this.dao.recherche("Toto")).thenReturn(Collections.emptyList());

        final List<UtilisateurDto> response = this.utilisateurService.rechercherUtilisateur("Toto");

        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.size());
    }

    @Test
    void testFindUtilisateurById() {
        final var utilisateurDo = new UtilisateurDo();

        utilisateurDo.setEmail("email_do@test.fr");
        utilisateurDo.setReference("456def");
        utilisateurDo.setDateInscription(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        utilisateurDo.setNom("Dupond");
        utilisateurDo.setPrenom("Brice");
        utilisateurDo.setEstDesactive(true);
        utilisateurDo.setDateNaissance(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        utilisateurDo.setAdresse("19 rue Test, 59000, Lille");
        utilisateurDo.setMdpHash("test");

        final var roleDo = new RoleDo();

        roleDo.setIdRole(1);
        roleDo.setLibelle("client");

        utilisateurDo.setRole(roleDo);

        Mockito.when(this.dao.findById(1)).thenReturn(utilisateurDo);
        Mockito.when(this.dao.findById(10)).thenReturn(null);

        final UtilisateurDto utilisateurDto = this.utilisateurService.findUtilisateurById(1);

        Assertions.assertNotNull(utilisateurDto);
        Assertions.assertEquals("email_do@test.fr", utilisateurDto.getEmail());
    }

    @Test
    void testDeleteUtilisateurById() {

        //On retourne une Liste de 2 UtilisateursDto �tant admins
        Mockito.when(this.dao.rechercheNombreParRole(3)).thenReturn(2);

        //Au moins un admin restant si suppression -> true 
        Assertions.assertTrue(this.utilisateurService.deleteUtilisateurById(2, 3));

        //On retire un admin de la liste, liste de taille 1
        Mockito.when(this.dao.rechercheNombreParRole(3)).thenReturn(1);

        //Dernier admin, suppression impossible -> false 
        Assertions.assertFalse(this.utilisateurService.deleteUtilisateurById(2, 3));

        //M�me test mais en supprimant un id=1 (client) -> true
        Assertions.assertTrue(this.utilisateurService.deleteUtilisateurById(2, 1));

    }
}
