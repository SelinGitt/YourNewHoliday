/**
 * 
 */
package presentation.produit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentation.produit.dto.ProduitDto;
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
     * @param  code  : String optionnel correspondant à un code erreur à afficher
     * @param  error les potentielles erreurs stockées
     * @return       liste de produits pour le model et la vue associée
     */
    @GetMapping
    public ModelAndView lister(final @ModelAttribute("anySuccess") String code, final @ModelAttribute("anyError") String error) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduits");
        //Si un message est présent, on le met en attribut du modelandview
        if (!code.isBlank()) {
            modelAndView.getModelMap().addAttribute("anySuccess", code);
        }
        if (!error.isBlank()) {
            modelAndView.getModelMap().addAttribute("anyError", error);

        }
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
            final @RequestParam(value = "tri", defaultValue = "0") String tri) {
        final var modelAndView = new ModelAndView("listerProduits");
        final List<ProduitDto> listeProduitsTrouves = this.iProduitService.findFilter(searchTerm, TypeTriAlphanumerique.findValue(tri));

        modelAndView.getModelMap().addAttribute("tri", tri);
        modelAndView.getModelMap().addAttribute("searchTerm", searchTerm);
        modelAndView.getModelMap().addAttribute(LISTE_PRODUIT_DTO, listeProduitsTrouves);
        if (listeProduitsTrouves.isEmpty()) {
            modelAndView.getModelMap().addAttribute("anyError", "pdt00.notexist");
        }

        return modelAndView;
    }
}
