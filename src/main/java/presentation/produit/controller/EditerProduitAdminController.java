/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.produit.dto.ProduitDto;
import service.produit.IProduitService;

/**
 * Classe représentant le controller pour éditer les produits en vue administrateur
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/editerProduitAdmin.do")
public class EditerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     * 
     * @param  produitDto le produit à éditer
     * @return            la liste de tous les produit dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView editerProduit(final ProduitDto produitDto) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("editerProduitAdmin");
        modelAndView.getModelMap().addAttribute("editerProduitDto", iProduitService.editerProduit(produitDto));
        return modelAndView;
    }
}
