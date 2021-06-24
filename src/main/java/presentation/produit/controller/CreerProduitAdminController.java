/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.produit.dto.ProduitDto;
import service.produit.IProduitService;

/**
 * Classe représentant le controller pour creer un produit en tant qu'admin
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/creerProduitAdmin.do")
public class CreerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET<br/>
     * et de mettre un ProduitDto vide dans la modelMap
     *
     * @return le model et la vue associée
     */
    @GetMapping
    public ModelAndView voirFormulaireCreerProduit() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("creerProduitAdmin");
        modelAndView.getModelMap().addAttribute("produitDto", new ProduitDto());
        return modelAndView;
    }

    /**
     * Méthode POST pour la création d'un produit via un formulaire<br/>
     * et de creer un nouveau produit
     *
     * @param  produitDto le produit Dto utilisé pour le binding
     * @return            vers une creerProduitAdmin.jsp
     */
    @PostMapping
    public ModelAndView creerProduit(final @ModelAttribute("produitDto") ProduitDto produitDto) {
        if (iProduitService.creerProduit(produitDto) != null) {
            return new ModelAndView("redirect:/listerProduitsAdmin.do");
        }
        return new ModelAndView("creerProduitAdmin");
    }
}
