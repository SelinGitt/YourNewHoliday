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
 * Classe de test de la méthode getPropValues
 *
 * @author NathanR
 */
//Permet de gérer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de déclarer le fichier de conf à utiliser
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
        assertEquals(4, GetPropertyValues.getPropertiesMap().size());
        assertEquals("C:/YNH_Project/external_files/contact/", GetPropertyValues.getPropertiesMap().get("contactRepo"));
        assertEquals("C:/YNH_Project/external_files/mentionsLegales/", GetPropertyValues.getPropertiesMap().get(
                "mentionsLegalesRepo"));
        assertEquals("C:/YNH_Project/external_files/img/produits/", GetPropertyValues.getPropertiesMap().get(
                "imagesProduitsRepo"));
        assertEquals("C:/YNH_Project/external_files/img/utilisateurs/", GetPropertyValues.getPropertiesMap().get(
                "imagesUtilisateursRepo"));
    }

}
