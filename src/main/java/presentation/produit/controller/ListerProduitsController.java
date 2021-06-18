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

    /**
     * 
     */
    private static final String LISTE_PRODUIT_DTO = "listeProduitDto";
    @Autowired
    private IProduitService     iProduitService;

    /**
     * Permet de traiter une requête de type GET
     *
     * @return liste de produits pour le model et la vue associée
     */
    @GetMapping
    public ModelAndView lister() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduits");
        modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, iProduitService.listerProduitsEnVente());
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  type       le type de recherche effectuée
     * @param  searchTerm le terme recherché
     * @param  tri        le tri à effectuer
     * @return            liste de produits pour le model et la vue associée
     */
    @PostMapping
    public ModelAndView findFilter(final @RequestParam(value = "type", required = false) String type,
            final @RequestParam(value = "searchInput", required = false) String searchTerm,
            final @RequestParam(value = "tri", required = false) String tri) {
        final var modelAndView = new ModelAndView("listerProduits");
        switch (type) {
            case "tri":
                trierListe(tri, modelAndView);
                break;
            case "search":
                filtrerListe(searchTerm, modelAndView);
                break;
            default:
                return lister();
        }
        return modelAndView;
    }

    /**
     * Permet de filtrer la liste en fonction de sa référence
     *
     * @param searchTerm   le terme à rechercher
     * @param modelAndView le modelAndView
     */
    private ModelAndView filtrerListe(final String searchTerm, final ModelAndView modelAndView) {
        if (!searchTerm.isEmpty()) {
            modelAndView.addObject(LISTE_PRODUIT_DTO, iProduitService.rechercherProduits(searchTerm));
            return modelAndView;
        }
        return modelAndView.addObject(LISTE_PRODUIT_DTO, iProduitService.listerProduitsEnVente());

    }

    /**
     * Permet de trier la liste en fonction de son prix
     *
     * @param tri          la méthode pour trier les
     * @param modelAndView
     */
    private void trierListe(final String tri, final ModelAndView modelAndView) {
        if ("prix_croissant".equals(tri)) {
            modelAndView.addObject(LISTE_PRODUIT_DTO, iProduitService.listerCroissant());
        } else {
            modelAndView.addObject(LISTE_PRODUIT_DTO, iProduitService.listerDecroissant());
        }
    }

    //    /**
    //     * Permet de traiter une requete de type POST
    //     *
    //     * @param  tri ordre de tri
    //     * @return     liste triée
    //     */
    //    @PostMapping
    //    public ModelAndView listerCroissant(final @RequestParam(value = "tri") String tri) {
    //        final var modelAndView = new ModelAndView("listerProduits");
    //        trierListe(tri, modelAndView);
    //        return modelAndView;
}
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
