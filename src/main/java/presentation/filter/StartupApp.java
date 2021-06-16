/**
 * 
 */
package presentation.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import presentation.utilisateur.dto.DroitDto;
import presentation.utilisateur.dto.PossedeDto;
import service.utilisateur.IDroitService;

/**
 * Classe StartupApp
 *
 * @author Valentin
 */
@Component
public class StartupApp implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * Map qui contient url + droits
     */
    public static final Map<String, List<String>> DROITS = new HashMap<>();

    @Autowired
    private IDroitService                         droitService;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final var listDroit = this.droitService.findAll();

        //        listDroit.stream().map(DroitDo::getUrl).forEach(Assertions::assertNotNull);

        for (final DroitDto droit : listDroit) {
            final List<String> listRole = new ArrayList<>();

            for (final PossedeDto possede : droit.getPossede()) {
                listRole.add(possede.getRoleDto().getLibelle());
            }

            DROITS.put(droit.getUrl(), listRole);
        }
    }
}
