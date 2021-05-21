package presentation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 */

/**
 * Classe  A SUPPRIMER
 *
 * @author Alexandre
 *
 */
@Controller
@RequestMapping("/provisoire.do")
public class ProvisoireController {

    
    /**
     * Permet de traiter une requête de type GET
     * 
     * @return           Le produit dans le model et la vue associée
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView consulterProduit() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Temporaire");
       
        return modelAndView;
    }

    
}
