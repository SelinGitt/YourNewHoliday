/**
 * 
 */
package presentation.startup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import presentation.utilisateur.dto.PossedeDto;
import presentation.utilisateur.dto.RoleDto;
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

        listDroit.forEach(droit -> DROITS.put(droit.getUrl(),
                droit.getPossede().stream().map(PossedeDto::getRoleDto).map(RoleDto::getLibelle).collect(Collectors.toList())));
    }
}
