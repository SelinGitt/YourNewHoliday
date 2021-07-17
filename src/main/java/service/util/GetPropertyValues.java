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

    /**
     * Map contennant les chemins d'accès aux répertoires
     */
    private static final Map<String, String> PROPERTIESMAP = new HashMap<>();

    private static final Logger              logger        = LoggerFactory.getLogger(GetPropertyValues.class);

    /**
     * Constructor
     */
    private GetPropertyValues() {
        // void
    }

    /**
     * Permet d'extraire les données du fichier YNH-application.properties et de les placer dans la map
     */
    public void getPropValues() {
        // On instancie une Properties
        final var prop = new Properties();
        // On précise le nom du fichier Properties
        final var propFileName = "YNH-application.properties";
        // On crée un stream sur le fichier Properties
        try (final var inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            // Si le stream est null, on lance un FileNotFoundException
            if (inputStream == null) {
                throw new FileNotFoundException("The property file " + propFileName + " not found in the classpath.");
            }
            // On lit le fichier YNH-application.properties
            prop.load(inputStream);
            // On place dans la map chaque couple clé/valeur du fichier properties
            getPropertiesMap().put("contactEncodage", prop.getProperty("contactEncodage"));
            getPropertiesMap().put("contactRepo", prop.getProperty("contactRepo"));
            getPropertiesMap().put("mentionsLegalesEncodage", prop.getProperty("mentionsLegalesEncodage"));
            getPropertiesMap().put("mentionsLegalesRepo", prop.getProperty("mentionsLegalesRepo"));
            getPropertiesMap().put("imagesProduitsRepo", prop.getProperty("imagesProduitsRepo"));
            getPropertiesMap().put("imagesUtilisateursRepo", prop.getProperty("imagesUtilisateursRepo"));
            // On catch les éventuelles exceptions générées par le stream
        } catch (final Exception e) {
            logger.error("Le stream du fichier YNH-application.properties a généré une exception : ", e);
        }
    }

    /**
     * Getter for propertiesmap
     *
     * @return the propertiesmap
     */
    public static Map<String, String> getPropertiesMap() {
        return PROPERTIESMAP;
    }
}
