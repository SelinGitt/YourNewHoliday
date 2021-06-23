/**
 * 
 */
package service.util;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Classe utilitaire permettant de récupérer les clés du fichier YNH-application.properties
 *
 * @author NathanR
 */
@Service
public class GetPropertyValues {

    private static final Logger logger = LoggerFactory.getLogger(GetPropertyValues.class);

    /**
     * Constructor
     */
    private GetPropertyValues() {
        // void
    }

    /**
     * Map contennant les chemins d'accès aux répertoires
     */
    public static final Map<String, String> PROPERTIESMAP = new HashMap<>();

    /**
     * Permet d'extraire les données du fichier YNH-application.properties et de les placer dans la map
     */
    public void getPropValues() {
        final var prop = new Properties();
        final var propFileName = "YNH-application.properties";
        try (final var inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("The property file " + propFileName + " not found in the classpath.");
            }
            PROPERTIESMAP.put("contactRepo", prop.getProperty("contactRepo"));
        } catch (final Exception e) {
            logger.error("Le stream du fichier YNH-application.properties a généré une exception : ", e);
        }
    }
}
