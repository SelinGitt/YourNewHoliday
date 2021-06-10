/**
 * 
 */
package presentation.produit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.produit.dto.ProduitDto;

/**
 * Classe repr�sentant le controller pour creer un produit en tant qu'admin
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/creerProduitAdmin.do")
public class CreerProduitAdminController {

    /**
     * Permet de traiter une requ�te de type GET
     *
     * @return liste de produits pour le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView voirFormulaireCreerProduit() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("creerProduitAdmin");
        modelAndView.getModelMap().addAttribute("produitDto", new ProduitDto());
        return modelAndView;
    }

    /**
     * M�thode POST pour la cr�ation d'un produit via un formulaire
     *
     * @param  produitDto le produit Dto utilis� pour le binding
     * @return            vers une creerProduitAdmin.jsp
     */
    @PostMapping
    public ModelAndView creerProduit(final @ModelAttribute("produitDto") ProduitDto produitDto) {
        return new ModelAndView("creerProduitAdmin");
    }
}
