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
import service.utilisateur.mapper.UtilisateurMapper;
import service.utilisateur.util.UtilisateurRoleEnum;

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
        Mockito.when(this.dao.findAllTriAlpha()).thenReturn(Collections.emptyList());
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

        role.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        role.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        userDo.setRole(role);

        Mockito.when(this.dao.findAllTriAlpha()).thenReturn(Collections.singletonList(userDo));
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
        role.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        role.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDto.setRole(role);

        Mockito.when(this.dao.create(Mockito.any(UtilisateurDo.class))).thenReturn(UtilisateurMapper.mapperToDo(utilisateurDto));

        final UtilisateurDto utilisateurCreated = this.utilisateurService.createUtilisateur(utilisateurDto);

        Assertions.assertNotNull(utilisateurCreated);

        Mockito.when(this.dao.findByEmail(utilisateurDto.getEmail())).thenReturn(new UtilisateurDo());

        Assertions.assertNull(this.utilisateurService.createUtilisateur(utilisateurDto));
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#authentify()}
     */
    @ParameterizedTest
    @CsvSource({"email, password, true, false", "email, wrong password, false, false", "email, password, false, true"})
    void testAuthentifyEmailOK(final String email, final String password, final String check, final boolean isDesactive) {

        //On crée l'utilisateurDo qu'on récupère en BD
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setEmail("email");
        utilisateurDo.setEstDesactive(isDesactive);
        //Correspond au hash de "password"
        utilisateurDo.setMdpHash("B0FBB24B2497D66890D0BBF15034768B8BD7557E094D512A52AD0F0C58FA0AB8");
        utilisateurDo.setNom("nom");

        final RoleDo roleDo = new RoleDo();
        roleDo.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDo.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo.setRole(roleDo);

        Mockito.when(this.dao.findByEmail(email)).thenReturn(utilisateurDo);

        //On tente une authentification 
        final UtilisateurServiceAuthReturn utilisateurServiceAuthReturn = this.utilisateurService.authentify(email, password);
        final var utilisateurConnecteDto = utilisateurServiceAuthReturn.getUtilisateurConnecteDto();
        final var isDesactiveConnecteDto = utilisateurServiceAuthReturn.isDesactive();

        //L'argument "true" sert à indiquer qu'on attend une authentification réussie
        if (check.equals("true")) {
            Assertions.assertNotNull(utilisateurConnecteDto);
            Assertions.assertEquals("nom", utilisateurConnecteDto.getNom());
            Assertions.assertFalse(isDesactiveConnecteDto);
        } else {
            if (isDesactive) {
                Assertions.assertNull(utilisateurConnecteDto);
                Assertions.assertTrue(isDesactiveConnecteDto);
            } else {
                Assertions.assertNull(utilisateurConnecteDto);
                Assertions.assertFalse(isDesactiveConnecteDto);
            }
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

        final UtilisateurServiceAuthReturn utilisateurServiceAuthReturn = this.utilisateurService.authentify(email, password);
        final UtilisateurConnecteDto utilisateurConnecteDto = utilisateurServiceAuthReturn.getUtilisateurConnecteDto();
        final boolean isDesactive = utilisateurServiceAuthReturn.isDesactive();

        Assertions.assertNull(utilisateurConnecteDto);
        Assertions.assertFalse(isDesactive);
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#rechercherUtilisateurNom(String)}
     */
    @Test
    void testRecherche() {
        Mockito.when(this.dao.recherche("Toto")).thenReturn(Collections.emptyList());

        final List<UtilisateurDto> response = this.utilisateurService.rechercherUtilisateur("Toto", 0);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.size());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#rechercherUtilisateurRole(String)}
     */
    @Test
    void testRechercheRole() {
        Mockito.when(this.dao.rechercheRole(UtilisateurRoleEnum.CLIENT.getId())).thenReturn(Collections.emptyList());

        final List<UtilisateurDto> response = this.utilisateurService.rechercherUtilisateur("", UtilisateurRoleEnum.CLIENT.getId());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.size());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#rechercherUtilisateurNomRole(String, String)}
     */
    @Test
    void testRechercheNomRole() {
        Mockito.when(this.dao.rechercheNomRole("Toto", UtilisateurRoleEnum.CLIENT.getId())).thenReturn(Collections.emptyList());

        final List<UtilisateurDto> response = this.utilisateurService.rechercherUtilisateur("Toto", UtilisateurRoleEnum.CLIENT.getId());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.size());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#updateUtilisateur(UtilisateurDto)}
     */
    @Test
    void testUpdate() {
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
        role.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        role.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDto.setRole(role);

        Mockito.when(this.dao.update(Mockito.any(UtilisateurDo.class))).thenReturn(UtilisateurMapper.mapperToDo(utilisateurDto));

        final UtilisateurDto utilisateurDtoUpdated = this.utilisateurService.updateUtilisateur(utilisateurDto);

        Assertions.assertNotNull(utilisateurDtoUpdated);
    }

    /**
     * Test sans changement de mot de passe
     */
    @Test
    void testUpdateOK() {
        final UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(1);
        utilisateurDto.setReference("ABC123");
        utilisateurDto.setEmail("test@test.fr");
        utilisateurDto.setNom("Nom");
        utilisateurDto.setPrenom("Prenom");
        utilisateurDto.setPassword("");
        utilisateurDto.setDateInscription("09/06/2021");
        utilisateurDto.setDateNaissance("09/06/2021");
        utilisateurDto.setEstDesactive(true);
        utilisateurDto.setAdresse("19 rue Test, 59000, Lille");

        final RoleDto role = new RoleDto();
        role.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        role.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDto.setRole(role);

        final UtilisateurDo userDo = new UtilisateurDo();
        userDo.setMdpHash("azeaze");

        Mockito.when(this.dao.update(Mockito.any(UtilisateurDo.class))).thenReturn(UtilisateurMapper.mapperToDo(utilisateurDto));
        Mockito.when(this.dao.findById(utilisateurDto.getId())).thenReturn(userDo);

        final UtilisateurDto utilisateurDtoUpdated = this.utilisateurService.updateUtilisateur(utilisateurDto);

        Assertions.assertNotNull(utilisateurDtoUpdated);
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#updateUtilisateur(UtilisateurDto)}
     */
    @Test
    void testUpdateKO() {
        final UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(1);
        utilisateurDto.setEmail("test@test.fr");

        final UtilisateurDo utilisateurDoReturn = new UtilisateurDo();
        utilisateurDoReturn.setIdUtilisateur(2);
        utilisateurDoReturn.setEmail("test@test.fr");

        Mockito.when(this.dao.findByEmail("test@test.fr")).thenReturn(utilisateurDoReturn);

        final UtilisateurDto utilisateurDtoUpdated = this.utilisateurService.updateUtilisateur(utilisateurDto);

        Assertions.assertNull(utilisateurDtoUpdated);
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#findByReference(String)}
     */
    @Test
    void testFindByReference() {
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setReference("ABC123");
        utilisateurDo.setEmail("test@test.fr");
        utilisateurDo.setNom("Nom");
        utilisateurDo.setPrenom("Prenom");
        utilisateurDo.setMdpHash("Hash");
        utilisateurDo.setDateInscription(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        utilisateurDo.setDateNaissance(new GregorianCalendar(2021, Calendar.APRIL, 12, 11, 30, 51).getTime());
        utilisateurDo.setEstDesactive(true);
        utilisateurDo.setAdresse("19 rue Test, 59000, Lille");

        final RoleDo role = new RoleDo();
        role.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        role.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo.setRole(role);

        Mockito.when(this.dao.findByReference("Ref")).thenReturn(utilisateurDo);
        Mockito.when(this.dao.findByReference("RefKO")).thenReturn(null);

        Assertions.assertNotNull(this.utilisateurService.rechercherReference("Ref"));

        Assertions.assertNull(this.utilisateurService.rechercherReference("RefKO"));
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#findUtilisateurById(Integer)}
     */
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

        roleDo.setIdRole(UtilisateurRoleEnum.CLIENT.getId());
        roleDo.setLibelle(UtilisateurRoleEnum.CLIENT.getLibelle());

        utilisateurDo.setRole(roleDo);

        Mockito.when(this.dao.findById(UtilisateurRoleEnum.CLIENT.getId())).thenReturn(utilisateurDo);
        Mockito.when(this.dao.findById(10)).thenReturn(null);

        final UtilisateurDto utilisateurDto = this.utilisateurService.findUtilisateurById(UtilisateurRoleEnum.CLIENT.getId());

        Assertions.assertNotNull(utilisateurDto);
        Assertions.assertEquals("email_do@test.fr", utilisateurDto.getEmail());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef1() {
        //Suppression d'un admin qui se supprime lui-même depuis la liste (USR_01)

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(7);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Administrateur")).thenReturn(utilisateurDo);
        //Dernier admin -> false 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(false);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Administrateur", "2");
        Assertions.assertTrue(result.isSameUserFromList());
        Assertions.assertTrue(result.isSucceeded());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef2() {
        //Suppression d'un admin qui se supprime lui-même depuis la liste (USR_01) en étant le dernier admin

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(7);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Administrateur")).thenReturn(utilisateurDo);
        //Dernier admin -> true 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(true);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Administrateur", "2");
        Assertions.assertTrue(result.isSameUserFromList());
        Assertions.assertFalse(result.isSucceeded());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef3() {
        //Suppression d'un admin depuis la liste (USR_01)

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(6);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Administrateur")).thenReturn(utilisateurDo);
        //Dernier admin -> false 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(false);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Administrateur", "2");
        Assertions.assertFalse(result.isSameUserFromList());
        Assertions.assertTrue(result.isSucceeded());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef4() {
        //Suppression d'un client depuis la liste (USR_01)

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(7);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Client")).thenReturn(utilisateurDo);
        //Dernier admin -> false 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(false);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Client", "2");
        Assertions.assertTrue(result.isSameUserFromList());
        Assertions.assertTrue(result.isSucceeded());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef5() {
        //Suppression d'un admin depuis la consultation de son profil (USR_00)

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(7);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Administrateur")).thenReturn(utilisateurDo);
        //Dernier admin -> false 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(false);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Administrateur", "1");
        Assertions.assertFalse(result.isSameUserFromList());
        Assertions.assertTrue(result.isSucceeded());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef6() {
        //Suppression d'un admin depuis la consultation de son profil (USR_00) en étant le dernier admin

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(7);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Administrateur")).thenReturn(utilisateurDo);
        //Dernier admin -> true 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(true);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Administrateur", "1");
        Assertions.assertFalse(result.isSameUserFromList());
        Assertions.assertFalse(result.isSucceeded());
    }

    /**
     * Test pour {@link service.utilisateur.impl.UtilisateurService#deleteUtilisateurById(Integer, String, String)}
     */
    @Test
    void testDeleteUtilisateurByRef7() {
        //Suppression d'un client depuis la consultation de son profil (USR_00)

        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setIdUtilisateur(5);
        final Integer idCurrentUtilisateur = 7;

        Mockito.when(this.dao.findByReference("Client")).thenReturn(utilisateurDo);
        //Dernier admin -> false 
        Mockito.when(this.dao.isLastAdmin(utilisateurDo.getIdUtilisateur())).thenReturn(false);

        final UtilisateurServiceReturn result = this.utilisateurService.deleteUtilisateurByRef(idCurrentUtilisateur, "Client", "1");
        Assertions.assertFalse(result.isSameUserFromList());
        Assertions.assertTrue(result.isSucceeded());
    }
}
