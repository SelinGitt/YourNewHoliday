/**
 * 
 */
package service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Classe de test de la m�thode getPropValues
 *
 * @author NathanR
 */
//Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class GetPropertyValuesTest {

    @Autowired
    private GetPropertyValues getPropertyValues;

    /**
     * Test method for {@link service.util.GetPropertyValues#getPropValues()}.
     */
    @Test
    void testGetPropValues() {
        getPropertyValues.getPropValues();
        assertEquals(4, GetPropertyValues.getPropertiesmap().size());
        assertEquals("C:/YNH_Project/external_files/contact/", GetPropertyValues.getPropertiesmap().get("contactRepo"));
        assertEquals("C:/YNH_Project/external_files/mentionsLegales/", GetPropertyValues.getPropertiesmap().get("mentionsLegalesRepo"));
        assertEquals("C:/YNH_Project/external_files/img/produits/", GetPropertyValues.getPropertiesmap().get("imagesProduitsRepo"));
        assertEquals("C:/YNH_Project/external_files/img/utilisateurs/", GetPropertyValues.getPropertiesmap().get("imagesUtilisateursRepo"));
    }

}
