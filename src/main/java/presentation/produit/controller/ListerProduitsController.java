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
 * Classe représentant le controller pour lister les produits
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = {"/listerProduits.do", "/"})
public class ListerProduitsController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     *
     * @return liste de produits pour le model et la vue associée
     */
    @GetMapping
    public ModelAndView lister() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduits");
        modelAndView.getModelMap().addAttribute("listeProduitDto", iProduitService.listerProduitsEnVente());
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  searchInput terme recherché
     * @return             liste de produits pour le model et la vue associée
     */
//    @PostMapping
//    public ModelAndView rechercherProduits(final @RequestParam(value = "searchInput") String searchInput) {
//        final var modelAndView = new ModelAndView("listerProduits");
//        modelAndView.addObject("searchTerm", searchInput);
//        if (searchInput.isEmpty()) {
//            return new ModelAndView("redirect:/");
//        }
//        modelAndView.addObject("listeProduitDto", iProduitService.rechercherProduits(searchInput));
//        return modelAndView;
//    }

    /**
     * Permet de traiter une requete de type POST
     *
     * @param  prix_croissant ordre de tri
     * @return                liste triée
     */
    @PostMapping
    public ModelAndView listerCroissant(final @RequestParam(value = "prix_croissant") String prix_croissant) {
        final var modelAndView = new ModelAndView("listerProduits");
        modelAndView.addObject("prix_croissant", prix_croissant);
        modelAndView.addObject("prix_croissant", iProduitService.listerCroissant());
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     *
     * @param  prix_decroissant ordre de tri
     * @return                  liste triée
     */
//    @PostMapping
//    public ModelAndView listerDecroissant(final @RequestParam(value = "prix_decroissant") String prix_decroissant) {
//        final var modelAndView = new ModelAndView("listerProduits");
//        modelAndView.addObject("prix_decroissant", prix_decroissant);
//        modelAndView.addObject("prix_decroissant", iProduitService.listerDecroissant());
//        return modelAndView;
//    }
}
