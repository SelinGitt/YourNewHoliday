/**
 * 
 */
package presentation.controller.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.produit.IProduitService;

/**
 * Classe controller qui charge la JSP d'exemple d'affichage d'image depuis la BD
 *
 * @author Lucas
 */
@Controller
@RequestMapping("/AfficherImageTemp.do")
public class ControllerAfficherImage {
    @Autowired
    private IProduitService produitService;

    /**
     * Methode get pour lancer la page
     *
     * @return le modelAndView contenant la vue et la liste de produits
     */
    @GetMapping
    public ModelAndView index() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("showImage");
        modelAndView.getModelMap().addAttribute("ListeProduits", produitService.listerProduitsEnVente());
        return modelAndView;
    }
}
