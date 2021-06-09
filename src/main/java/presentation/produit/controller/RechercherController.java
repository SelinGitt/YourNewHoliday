/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.produit.IProduitService;

/**
 * Controller pour rechercher des produits
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/rechercherProduits.do")
public class RechercherController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requete de type POST
     *
     * @return liste de produits pour le model et la vue associée
     */
    @PostMapping
    public ModelAndView rechercherProduits() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("rechercherProduits");
        modelAndView.getModelMap().addAttribute("listeProduitDto", iProduitService.rechercherProduits());
        return modelAndView;
    }
}
