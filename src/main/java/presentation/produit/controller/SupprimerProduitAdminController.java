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
 * Classe repr�sentant le controller permettant de supprimer un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping("/supprimerProduitAdmin.do")
public class SupprimerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requ�te de type GET
     * 
     * @param  idProduit du produit � supprimer
     * @return           le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView supprimerProduit(final @RequestParam(value = "idProduit") Integer idProduit) {
        final var modelAndView = new ModelAndView();
        if (iProduitService.deleteProduit(idProduit)) {
            modelAndView.getModelMap().addAttribute("anySuccess", "pdt01.supprimer.success");
        } else {
            modelAndView.getModelMap().addAttribute("anyError", "pdt01.supprimer.error");
        }
        modelAndView.setViewName("forward:/listerProduitsAdmin.do");
        return modelAndView;
    }
}
