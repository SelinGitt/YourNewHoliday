/**
 * 
 */
package presentation.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import presentation.utilisateur.dto.DroitDto;
import service.utilisateur.IDroitService;

/**
 * Classe StartupApp
 *
 * @author Valentin
 */
@Component
public class StartupApp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IDroitService                         droitService;

    /**
     * Map qui contient url + droits
     */
    public static final Map<String, List<String>> mapDroit = new HashMap<>();

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final var listDroit = this.droitService.findAll();

        //        listDroit.stream().map(DroitDo::getUrl).forEach(Assertions::assertNotNull);

        for (final DroitDto droit : listDroit) {
            mapDroit.put(droit.getUrl(), this.droitService.findRole(droit));
        }
    }
}
