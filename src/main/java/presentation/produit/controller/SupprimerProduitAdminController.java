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
 * Classe représentant le controller permettant de supprimer un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping("/supprimerProduitAdmin.do")
public class SupprimerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     * 
     * @param  idProduit du produit à supprimer
     * @return           le model et la vue associée
     */
    @GetMapping
    public ModelAndView supprimerProduit(final @RequestParam(value = "idProduit") Integer idProduit) {
        final var modelAndView = new ModelAndView();
        if (iProduitService.deleteProduit(idProduit)) {
            modelAndView.getModelMap().addAttribute("anySuccess", "pdt01.supprimer.success");
        }
        modelAndView.setViewName("redirect:/listerProduitsAdmin.do");
        return modelAndView;
    }
}
