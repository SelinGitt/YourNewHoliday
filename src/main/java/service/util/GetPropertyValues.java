/**
 * 
 */
package service.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Classe utilitaire permettant de récupérer les clés du fichier YNH-application.properties
 *
 * @author NathanR
 */
public class GetPropertyValues {

    /**
     * Map contennant les chemins d'accès aux répertoires
     */
    public static final Map<String, String> PROPERTIESMAP = null;

    /**
     * Permet d'extraire les données du fichier YNH-application.properties et de les placer dans la map
     *
     * @throws IOException
     */
    public void getPropValues() throws IOException {
        final Properties prop = new Properties();
        final String propFileName = "YNH-application.properties";
        try (final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("The property file " + propFileName + " not found in the classpath.");
            }
            PROPERTIESMAP.put("contactRepo", prop.getProperty("contactRepo"));
            PROPERTIESMAP.put("produitsImagesRepo", prop.getProperty("produitsImagesRepo"));
        } catch (

        final Exception e) {

            System.out.println("Exception: " + e);
        }
    }
}
