/**
 * 
 */
package presentation.contact;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.contact.IFichierContactService;

/**
 * Classe représentant le Controller contact
 *
 * @author Alexandre
 */
@Controller
@RequestMapping("/contact.do")
public class ContactController {

    @Autowired
    private IFichierContactService iContactService;

    /**
     * Permet de passer en attributs la methode trouverFichierContact de iProduitService
     * 
     * @param  locale : on recuperer la locale pour definir le nom du fichier html a charger
     * @return        Le produit dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView afficherContact(final Locale locale) {

        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("contact");
        modelAndView.getModelMap().addAttribute("fichierHtml", iContactService.trouverFichierContact(locale));
        return modelAndView;
    }

}
