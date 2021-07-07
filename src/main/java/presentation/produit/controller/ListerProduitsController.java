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
 * Classe repr�sentant le controller pour lister les produits
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = {"/listerProduits.do", "/"})
public class ListerProduitsController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requ�te de type GET
     * 
     * @param  code : String optionnel correspondant � un code erreur � afficher
     * @return      liste de produits pour le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView lister(final @ModelAttribute("deletionSuccess") String code) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduits");
        //Si un message est pr�sent, on le met en attribut du modelandview
        if (!code.isBlank()) {
            modelAndView.getModelMap().addAttribute("anySuccess", code);
        }
        modelAndView.getModelMap().addAttribute("listeProduitDto", iProduitService.listerProduitsEnVente());
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  searchInput terme recherch�
     * @return             liste de produits pour le model et la vue associ�e
     */
    @PostMapping
    public ModelAndView rechercherProduits(final @RequestParam(value = "searchInput") String searchInput) {
        final var modelAndView = new ModelAndView("listerProduits");
        modelAndView.getModelMap().addAttribute("searchTerm", searchInput);
        if (searchInput.isEmpty()) {
            modelAndView.getModelMap().addAttribute("listeProduitDto", iProduitService.listerProduitsEnVente());
        } else {
            final List<ProduitDto> rechercherProduits = iProduitService.rechercherProduits(searchInput);
            if (rechercherProduits.isEmpty()) {
                modelAndView.getModelMap().addAttribute("anyError", "pdt00.notexist");
            }
            modelAndView.getModelMap().addAttribute("listeProduitDto", rechercherProduits);
        }

        return modelAndView;
    }
}
