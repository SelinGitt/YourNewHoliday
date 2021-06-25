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
     * Utilisation d'une constante pour stocker l'attribut
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
        modelAndView.getModelMap().addAttribute("tri", 0);
        modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, iProduitService.listerProduitsEnVente());
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  searchTerm le terme recherché
     * @param  tri        le tri à effectuer
     * @return            liste de produits pour le model et la vue associée
     */
    @PostMapping
    public ModelAndView findFilter(final @RequestParam(value = "searchInput", required = false) String searchTerm,
            final @RequestParam(value = "tri", required = false) String tri) {
        final var modelAndView = new ModelAndView("listerProduits");
        if (!searchTerm.isBlank()) {
            if ("0".equals(tri)) {
                modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, iProduitService.rechercherProduits(searchTerm));
                modelAndView.getModelMap().addAttribute("tri", tri);
                modelAndView.getModelMap().addAttribute("searchTerm", searchTerm);
                return modelAndView;
            }
            modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, iProduitService.listerFiltreTri(TypeTri.checkType(tri), searchTerm));
            modelAndView.getModelMap().addAttribute("tri", tri);
            modelAndView.getModelMap().addAttribute("searchTerm", searchTerm);
            return modelAndView;
        }
        if ("0".equals(tri)) {
            modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, iProduitService.trierListe(TypeTri.checkType(tri)));
            modelAndView.getModelMap().addAttribute("tri", tri);
            modelAndView.getModelMap().addAttribute("searchTerm", searchTerm);
            return modelAndView;

        }
        modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, iProduitService.listerProduitsEnVente());
        return modelAndView;
    }

}
