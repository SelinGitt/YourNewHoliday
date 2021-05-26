/**
 * 
 */
package presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe représentant un exemple pour l'affichage d'une page sans style pour l'instant
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Controller
@RequestMapping("/exemple.do")
public class ExempleController {

    /**
     * Permet d'afficher la page d'exemple pour tiles
     *
     * @return String le nom de la définition de l'exemple
     */
    @GetMapping
    public String afficheExemple() {
        return "exemple";
    }
}
