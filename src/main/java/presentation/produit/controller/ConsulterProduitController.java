/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.produit.IProduitService;

/**
 * Classe repr�sentant le controller pour consulter un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/consulterProduit.do")
public class ConsulterProduitController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requ�te de type GET
     * 
     * @param  idProduit du produit � consulter
     * @return           le produit � consulter dans le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");
        modelAndView.getModelMap().addAttribute("consulterProduitDto", iProduitService.trouverProduitEnVente(idProduit));
        return modelAndView;
    }
}
