/**
 * 
 */
package service.commande.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import service.commande.ICommandeService;

/**
 * JUnit pour tester le service de la commande
 *
 * @author Hanan Anghari
 */
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de données avec les bonnes données 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
class CommandeServiceTest {

    @Autowired
    private ICommandeService commandeService;

    /**
     * Test method for {@link service.commande.impl.CommandeService}
     */
    @Test
    void testAutowired() {
        assertNotNull(commandeService);
    }

    /**
     * Test method for {@link service.commande.impl.CommandeService#listerCommandesUtilisateur(java.lang.Integer)}.
     */
    @Test
    void testListerCommandesUtilisateur() {

        assertEquals(2, commandeService.listerCommandesUtilisateur(2).size());
    }

}
