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
// Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de donn�es avec les bonnes donn�es 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
//N�cessaire car les Dao sont en Mandatory
@Transactional(propagation = Propagation.REQUIRED)
class UtilisateurDaoTest {

    @Autowired
    private IUtilisateurDao iUtilisateurDao;

    /**
     * Test method for {@link persistance.commun.dao.impl.AbstractGenericDao#findAll()}.
     */
    @Test
    void testFindAll() {
        // On r�cup�re les donn�es
        final List<UtilisateurDo> listUtilisateur = this.iUtilisateurDao.findAll();
        // On teste la conformit�e du nombre de donn�es
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
        //On essaie avec une adresse email pr�sente en base de donn�es
        final UtilisateurDo utilisateurDo = iUtilisateurDao.findByEmail("baratheon.robert@hotmail.com");
        assertNotNull(utilisateurDo);
        assertEquals("ClientCLIENT123", utilisateurDo.getReference());
        //On essaie avec une adresse email absente en base de donn�es
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
        //Le test se fait avec un utilisateur n'ayant pas de commande rattach�e � lui
        //Pour un utilisateur poss�dant des commandes, cela est g�r� dans UtilisateurService et non UtilisateurDao

        //On supprime un utilisateur existant en BD
        Assertions.assertTrue(iUtilisateurDao.deleteUtilisateurById(4));
        //On supprime un utilisateur NON existant en BD
        Assertions.assertFalse(iUtilisateurDao.deleteUtilisateurById(20));
    }

    /**
     * Test method for {@link persistance.utilisateur.dao.impl.UtilisateurDao#rechercheNombreParRole(Integer)}.
     */
    @Test
    void testRechercheNombreParRole() {
        //recherche des admins (id role 3)
        assertEquals(2, iUtilisateurDao.rechercheNombreParRole(3));
        //recherche des clients (id role 1)
        assertEquals(4, iUtilisateurDao.rechercheNombreParRole(1));
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
}