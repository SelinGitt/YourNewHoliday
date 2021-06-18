/**
 * 
 */
package presentation.startup;

import java.io.IOException;

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
    private GetPropertyValues getPropertyValues;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        try {
            getPropertyValues.getPropValues();
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

}
