/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.produit.IProduitService;

/**
 * Classe représentant le controller pour lister les produits
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = {"/lister.do", "/"})
public class ListerController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     *
     * @return liste de produits pour le model et la vue associée
     */
    @GetMapping
    public ModelAndView lister() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduits");
        modelAndView.getModelMap().addAttribute("listeProduitDto", iProduitService.listerProduitsEnVente());
        return modelAndView;
    }
}
