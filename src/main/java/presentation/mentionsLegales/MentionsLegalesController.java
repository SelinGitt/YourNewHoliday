/**
 * 
 */
package presentation.mentionsLegales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.mentionsLegales.IFichierMentionsLegalesService;

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
     * @return Le produit dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView afficherContact() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("mentionsLegales");
        modelAndView.getModelMap().addAttribute("fichierCGV", iFichierMentionsLegalesService.trouverFichierCGV());
        modelAndView.getModelMap().addAttribute("fichierCGU", iFichierMentionsLegalesService.trouverFichierCGU());
        return modelAndView;
    }

}
