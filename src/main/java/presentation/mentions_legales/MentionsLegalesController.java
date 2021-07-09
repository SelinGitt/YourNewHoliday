/**
 * 
 */
package presentation.mentions_legales;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.mentions_legales.IFichierMentionsLegalesService;

/**
 * Classe représentant le Controller Mentions Legales
 *
 * @author NathanR
 */
@Controller
@RequestMapping("/mentionsLegales.do")
public class MentionsLegalesController {

    @Autowired
    private IFichierMentionsLegalesService iFichierMentionsLegalesService;

    /**
     * Permet de passer en attributs la methode trouverFichierContact de iProduitService
     * 
     * @param  locale : on recuperer la locale pour definir le nom du fichier html a charger
     * @return        Le produit dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView afficherContact(final Locale locale) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("mentionsLegales");
        modelAndView.getModelMap().addAttribute("fichierCGV", iFichierMentionsLegalesService.chargerFichierCGV(locale));
        modelAndView.getModelMap().addAttribute("fichierCGU", iFichierMentionsLegalesService.chargerFichierCGU(locale));
        return modelAndView;
    }

}
