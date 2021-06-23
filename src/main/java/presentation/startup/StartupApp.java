/**
 * 
 */
package presentation.startup;

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
public class StartupApp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private GetPropertyValues   getPropertyValues;

    private static final Logger logger = LoggerFactory.getLogger(StartupApp.class);

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        getPropertyValues.getPropValues();
    }

}
