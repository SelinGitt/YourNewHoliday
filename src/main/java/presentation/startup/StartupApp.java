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

import presentation.utilisateur.dto.RoleDto;
import service.util.GetPropertyValues;
import service.utilisateur.IDroitService;

/**
 * Classe StartupApp
 *
 * @author Valentin/NathanR
 */
@Component
public class StartupApp implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * Map qui contient url + droits
     */
    public static final Map<String, List<String>> DROITS = new HashMap<>();

    @Autowired
    private IDroitService                         droitService;

    @Autowired
    private GetPropertyValues                     getPropertyValues;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        getPropertyValues.getPropValues();
        final var listDroit = this.droitService.findAll();

        listDroit.forEach(
                droit -> DROITS.put(droit.getUrl(), droit.getRole().stream().map(RoleDto::getLibelle).collect(Collectors.toList())));
    }

}
