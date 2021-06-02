/**
 * 
 */
package presentation.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * @param  modelMap : le modelmap qui renvoie l'attribut
     * @return          Le produit dans le model et la vue associée
     */
    @RequestMapping(method = RequestMethod.GET)
    public String afficherContact(final ModelMap modelMap) {
        //passe en attribut la string contenant le html de la methode trouverFichierContact
        modelMap.addAttribute("fichierHtml", iProduitService.trouverFichierContact());
        return "contact";
    }
}
