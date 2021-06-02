/**
 * 
 */
package presentation.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.Contact.IFichierContactService;

/**
 * Classe représentant le Controller contact
 *
 * @author Alexandre
 */
@Controller
@RequestMapping("/contact.do")
public class ContactController {

    @Autowired
    private IFichierContactService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     * 
     * @return Le produit dans le model et la vue associée
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView afficherContact() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact");
        modelAndView.getModelMap().addAttribute("fichierHtml", iProduitService.trouverFichierContact());
        return modelAndView;
    }
}
