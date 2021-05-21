/**
 * 
 */
package connectionDB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * JUnit pour tester la connection à la base de données
 *
 * @author Administrateur
 */
//Permet de gérer le JUnit avec Spring 
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
@ContextConfiguration("/META-INF/spring/applicationContext.xml")
@Transactional(propagation = Propagation.REQUIRED)
class ConnectionDBTest {

    @Autowired
    private BasicDataSource basicDataSource;

    @PersistenceContext(unitName = "puYnh")
    private EntityManager   entityManager;

    /**
     * Test de récupération de la datasource
     */
    @Test
    void testTesterDataSource() {
        assertNotNull(basicDataSource);
        assertEquals("jdbc:mysql://localhost:3306/bdynh?serverTimezone=UTC", basicDataSource.getUrl());
        assertEquals("com.mysql.cj.jdbc.Driver", basicDataSource.getDriverClassName());
        assertEquals("root", basicDataSource.getUsername());
        assertEquals("", basicDataSource.getPassword());
    }

    /**
     * Test de connexion à la base de données
     */
    @Test
    void testTesterConnexion() {
        final Query query = entityManager.createNativeQuery("select 1 from dual");
        assertEquals(BigInteger.valueOf(1), query.getSingleResult());
    }
}
