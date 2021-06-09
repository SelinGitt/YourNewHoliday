package persistance.utilisateur.dao.impl;

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
//Permet de gérer le JUnit avec Spring
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
        utilisateurDo.setEstActif(true);
        utilisateurDo.setAdresse("19 rue Test, 59000, Lille");

        final RoleDo role = new RoleDo();
        role.setIdRole(1);

        utilisateurDo.setRole(role);

        final UtilisateurDo utilisateurCreated = iUtilisateurDao.create(utilisateurDo);

        Assertions.assertNotNull(utilisateurCreated);
        Assertions.assertNotNull(utilisateurCreated.getIdUtilisateur());
    }
}
