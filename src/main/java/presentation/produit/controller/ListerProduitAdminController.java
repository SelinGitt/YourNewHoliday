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
 * Classe repr�sentant le controller pour lister les produits en vue administrateur
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/listerProduitsAdmin.do")
public class ListerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requ�te de type GET
     *
     * @return la liste de tous les produit dans le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView listerAllProduit() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduitsAdmin");
        modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.listerAllProduit());
        modelAndView.getModelMap().addAttribute("tri", 0);
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  searchInput terme recherch�
     * @param  tri         valeur du tri appliqu�
     * @return             liste de produits pour le model et la vue associ�e
     */
    @PostMapping
    public ModelAndView rechercherProduits(final @RequestParam(value = "searchInput", required = false) String searchInput,
            final @RequestParam(value = "tri", defaultValue = "0") String tri) {
        final var modelAndView = new ModelAndView("listerProduitsAdmin");
        modelAndView.getModelMap().addAttribute("searchTerm", searchInput);
        modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.rechercherAllProduits(searchInput));
        modelAndView.getModelMap().addAttribute("tri", tri);
        modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.filtrerEnVente(tri));
        return modelAndView;
    }
}
