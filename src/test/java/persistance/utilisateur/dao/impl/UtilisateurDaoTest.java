package persistance.utilisateur.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.utilisateur.dao.IUtilisateurDao;
import persistance.utilisateur.entity.RoleDo;
import persistance.utilisateur.entity.UtilisateurDo;

/**
 * JUnit class pour {@link persistance.utilisateur.dao.impl.UtilisateurDao}
 *
 * @author Valentin
 */
// Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de données avec les bonnes données 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
//Nécessaire car les Dao sont en Mandatory
@Transactional(propagation = Propagation.REQUIRED)
class UtilisateurDaoTest {

    @Autowired
    private IUtilisateurDao iUtilisateurDao;

    /**
     * Test method for {@link persistance.commun.dao.impl.AbstractGenericDao#findAll()}.
     */
    @Test
    void testFindAll() {
        // On récupère les données
        final List<UtilisateurDo> listUtilisateur = this.iUtilisateurDao.findAll();
        // On teste la conformitée du nombre de données
        Assertions.assertEquals(7, listUtilisateur.size());

        listUtilisateur.stream().map(UtilisateurDo::getRole).forEach(Assertions::assertNotNull);
    }

    /**
     * Test pour {@link persistance.commun.dao.impl.AbstractGenericDao#create(Object)}.
     */
    @Test
    void testCreate() {
        final UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo.setReference("ABC123");
        utilisateurDo.setEmail("test@test.fr");
        utilisateurDo.setNom("Nom");
        utilisateurDo.setPrenom("Prenom");
        utilisateurDo.setMdpHash("Hash");
        utilisateurDo.setDateInscription(Date.from(Instant.now()));
        utilisateurDo.setDateNaissance(Date.from(Instant.now()));
        utilisateurDo.setEstDesactive(true);
        utilisateurDo.setAdresse("19 rue Test, 59000, Lille");
        utilisateurDo.setCheminAvatar("img/test.png");

        final RoleDo role = new RoleDo();
        role.setIdRole(1);

        utilisateurDo.setRole(role);

        final UtilisateurDo utilisateurCreated = iUtilisateurDao.create(utilisateurDo);

        Assertions.assertNotNull(utilisateurCreated);
        Assertions.assertNotNull(utilisateurCreated.getIdUtilisateur());
    }

    /**
     * Test method for {@link persistance.utilisateur.dao.impl.UtilisateurDao#findByEmail()}.
     */
    @Test
    void testFindByEmail() {
        //On essaie avec une adresse email présente en base de données
        final UtilisateurDo utilisateurDo = iUtilisateurDao.findByEmail("baratheon.robert@hotmail.com");
        assertNotNull(utilisateurDo);
        assertEquals("ClientCLIENT123", utilisateurDo.getReference());
        //On essaie avec une adresse email absente en base de données
        assertNull(iUtilisateurDao.findByEmail("emailNonExistant@hotmail.com"));
    }

    /**
     * Test pour {@link persistance.utilisateur.dao.IUtilisateurDao#recherche(String)}
     */
    @Test
    void testRecherche() {
        final List<UtilisateurDo> utilisateurDo = iUtilisateurDao.recherche("Marsial");

        Assertions.assertNotNull(utilisateurDo);
        Assertions.assertEquals(1, utilisateurDo.size());
        Assertions.assertEquals("Marsial", utilisateurDo.get(0).getNom());
    }

    /**
     * Test method for {@link persistance.utilisateur.dao.impl.UtilisateurDao#deleteUtilisateurById(Integer)}.
     */
    @Test
    void testDeleteUtilisateurById() {
        //Le test se fait avec un utilisateur n'ayant pas de commande rattachée à lui
        //Pour un utilisateur possédant des commandes, cela est géré dans UtilisateurService et non UtilisateurDao

        //On supprime un utilisateur existant en BD
        Assertions.assertTrue(iUtilisateurDao.deleteUtilisateurById(4));
        //On supprime un utilisateur NON existant en BD
        Assertions.assertFalse(iUtilisateurDao.deleteUtilisateurById(20));
    }

    /**
     * Test pour {@link persistance.utilisateur.dao.IUtilisateurDao#rechercheRole(String)}
     */
    @Test
    void testRechercheRole() {
        final List<UtilisateurDo> utilisateurDos = iUtilisateurDao.rechercheRole(1);

        Assertions.assertNotNull(utilisateurDos);
        Assertions.assertEquals(4, utilisateurDos.size());
    }

    /**
     * Test pour {@link persistance.utilisateur.dao.IUtilisateurDao#rechercheNomRole(String, String)}
     */
    @Test
    void testRechercheNomRole() {
        final List<UtilisateurDo> utilisateurDos = iUtilisateurDao.rechercheNomRole("Ma", 3);

        Assertions.assertNotNull(utilisateurDos);
        Assertions.assertEquals(2, utilisateurDos.size());
    }

    /**
     * Test pour {@link persistance.communDao.impl.AbstractGenericDao#update(Object)}
     */
    @Test
    void testUpdate() {
        final UtilisateurDo utilisateurDo = iUtilisateurDao.findById(1);

        utilisateurDo.setEmail("email@update.fr");
        utilisateurDo.setNom("Updated");

        final UtilisateurDo utilisateurDoUpdated = iUtilisateurDao.update(utilisateurDo);

        Assertions.assertNotNull(utilisateurDoUpdated);
        Assertions.assertEquals(utilisateurDo.getEmail(), utilisateurDoUpdated.getEmail());
        Assertions.assertEquals(utilisateurDo.getNom(), utilisateurDoUpdated.getNom());
    }

    /**
     * Test method for {@link persistance.utilisateur.dao.impl.UtilisateurDao#findByReference(String)}.
     */
    @Test
    void testFindByReference() {
        final UtilisateurDo utilisateurDo = iUtilisateurDao.findByReference("Administrateur1");
        assertNotNull(utilisateurDo);
        assertEquals("Marsial", utilisateurDo.getNom());
        assertNull(iUtilisateurDao.findByReference("REFEXISTEPASPARCEQUEJELESAIS"));
    }

    @Test
    void testIsLastAdmin() {
        //Il reste deux admins, on tente avec l'id d'un admin
        Assertions.assertFalse(iUtilisateurDao.isLastAdmin(6));
        //Suppression d'un des deux admins
        iUtilisateurDao.deleteUtilisateurById(7);
        //Il reste un seul admin, on tente avec l'id d'un admin
        Assertions.assertTrue(iUtilisateurDao.isLastAdmin(6));
        //Il reste un seul admin, on tente avec l'id d'un client
        Assertions.assertFalse(iUtilisateurDao.isLastAdmin(3));
    }
}