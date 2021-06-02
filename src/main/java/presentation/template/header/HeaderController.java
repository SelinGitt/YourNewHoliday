/**
 * 
 */
package presentation.template.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pour l'affichage du header
 *
 * @author NathanR
 */
@Controller
@RequestMapping(value = "/header.do")
public class HeaderController {

    /**
     * Permet de retourner la JSP à afficher
     *
     * @return : Le nom de la jsp à afficher
     */
    @GetMapping
    public String afficherHeader() {
        return "header";
    }
}
