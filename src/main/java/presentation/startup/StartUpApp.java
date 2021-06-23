/**
 * 
 */
package presentation.startup;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import service.util.GetPropertyValues;

/**
 * Classe StartUpApp
 *
 * @author NathanR
 */
@Component
public class StartUpApp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private GetPropertyValues   getPropertyValues;

    private static final Logger logger = LoggerFactory.getLogger(StartUpApp.class);

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        try {
            getPropertyValues.getPropValues();
        } catch (final IOException exception) {
            logger.error("Le chargement du fichier YNH-application.properties a généré une erreur : ", exception);
        }
    }

}
