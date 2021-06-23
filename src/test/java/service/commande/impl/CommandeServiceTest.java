/**
 * 
 */
package service.commande.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import presentation.commande.dto.CommandeDto;
import service.commande.ICommandeService;
import service.util.DecimalFormatUtils;

/**
 * JUnit pour tester le service de la commande
 *
 * @author Hanan Anghari
 */
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de donn�es avec les bonnes donn�es 
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

    /**
     * Test method for {@link service.commande.impl.CommandeService#chercherCommandeParReference(java.lang.String)}.
     */
    @Test
    void testTrouverCommandeParReference() {
        final CommandeDto commandeDto = commandeService.chercherCommandeParReference("ABC1");
        assertNotNull(commandeDto);
        assertEquals("1", commandeDto.getId());
        assertEquals("ABC1", commandeDto.getReference());
        assertEquals("09/02/2021", commandeDto.getDate());
        final String nombre = DecimalFormatUtils.decimalFormatUtil(1200.00);
        assertEquals(nombre, commandeDto.getPrixTotal());
        assertEquals(2, commandeDto.getListCommandeProduitDto().size());
    }

}
