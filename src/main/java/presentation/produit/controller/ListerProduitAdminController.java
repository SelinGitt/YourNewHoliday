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
     * @param  codeSuccess le code success des pages
     * @param  codeError   le code d'erreur des pages
     * @return             la liste de tous les produit dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView listerAllProduit(final @RequestParam(value = "anySuccess", required = false, defaultValue = "") String codeSuccess,
            final @RequestParam(value = "anyError", required = false, defaultValue = "") String codeError) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerProduitsAdmin");
        //Si un message est présent, on le met en attribut du modelandview
        if (!codeSuccess.isBlank()) {
            modelAndView.getModelMap().addAttribute("anySuccess", codeSuccess);
        }
        if (!codeError.isBlank()) {
            modelAndView.getModelMap().addAttribute("anyError", codeError);

        }
        modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.listerAllProduit());
        modelAndView.getModelMap().addAttribute("tri", 0);
        return modelAndView;
    }

    /**
     * Permet de traiter une requete de type POST
     * 
     * @param  searchInput terme recherché
     * @param  tri         valeur du tri appliqué
     * @return             liste de produits pour le model et la vue associée
     */
    @PostMapping
    public ModelAndView rechercherProduits(
            final @RequestParam(value = "searchInput", required = false, defaultValue = "") String searchInput,
            final @RequestParam(value = "tri", required = false, defaultValue = "") String tri) {
        final var modelAndView = new ModelAndView("listerProduitsAdmin");
        modelAndView.getModelMap().addAttribute("searchTerm", searchInput);
        Boolean boolTri = null;
        if (tri != "") {
            if (tri.equals("0")) {
                boolTri = true;
            }
            if (tri.equals("1")) {
                boolTri = false;
            }
            if (tri.equals("")) {
                boolTri = null;
            }
        }

        if (boolTri != null) {
            if (boolTri) {
                modelAndView.getModelMap().addAttribute("tri", tri);
                modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.filtrerEnVente(searchInput, boolTri));
                return modelAndView;
            }
            modelAndView.getModelMap().addAttribute("tri", tri);
            modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.filtrerEnVente(searchInput, boolTri));
            return modelAndView;
        }
        modelAndView.getModelMap().addAttribute("tri", tri);
        modelAndView.getModelMap().addAttribute("listeAllProduitDto", iProduitService.filtrerEnVente(searchInput, boolTri));
        return modelAndView;
    }
}
