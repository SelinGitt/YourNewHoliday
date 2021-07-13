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
 * Classe représentant le controller pour consulter un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/consulterProduit.do")
public class ConsulterProduitController {

    /**
     * 
     */
    private static final String REDIRECTION_PARAM_NAME = "redir";
    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     * 
     * @param  idProduit du produit à consulter
     * @param  location  page d'origine
     * @param  param     : test
     * @return           le produit à consulter dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit,
            final @RequestParam("location") String location,
            final @RequestParam(value = "paramValue", required = false, defaultValue = "") String param) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");
        modelAndView.getModelMap().addAttribute("consulterProduitDto", iProduitService.trouverProduitEnVente(idProduit));
        switch (location) {
            case "listerProduits":
                modelAndView.getModelMap().addAttribute(REDIRECTION_PARAM_NAME, "listerProduits.do");
                break;
            case "listerProduitsAdmin":
                modelAndView.getModelMap().addAttribute(REDIRECTION_PARAM_NAME, "listerProduitsAdmin.do");
                break;
            case "detail":
                modelAndView.getModelMap().addAttribute(REDIRECTION_PARAM_NAME, "detailCommande.do");
                modelAndView.getModelMap().addAttribute("typeParam", "ref");
                modelAndView.getModelMap().addAttribute("value", param);
                break;
            case "panier":
                modelAndView.getModelMap().addAttribute(REDIRECTION_PARAM_NAME, "listerPanierProduits.do");
                break;
            default:
                modelAndView.getModelMap().addAttribute(REDIRECTION_PARAM_NAME, "listeProduits.do");
        }
        return modelAndView;

    }
}
