/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.produit.IProduitService;

/**
 * Classe représentant le controller pour lister les produits en vue administrateur
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/listerProduitsAdmin.do")
public class ListerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     *
     * @return la liste de tous les produit dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView listerAllProduit() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduitsAdmin");
        modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.listerAllProduit());
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  searchInput terme recherché
     * @return             liste de produits pour le model et la vue associée
     */
    @PostMapping
    public ModelAndView rechercherProduits(final @RequestParam(value = "searchInput") String searchInput) {
        final var modelAndView = new ModelAndView("listerProduitsAdmin");
        modelAndView.getModelMap().addAttribute("searchTerm", searchInput);
        if (searchInput.isEmpty()) {
            modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.listerAllProduit());
        } else {
            modelAndView.getModelMap().addAttribute("listeAllProduitDto",
                    iProduitService.rechercherAllProduits(searchInput));
        }
        return modelAndView;
    }
}
