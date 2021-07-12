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

import presentation.produit.dto.ProduitDto;
import service.produit.IProduitService;

/**
 * Classe repr�sentant le controller pour �diter les produits en vue administrateur
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/editerProduitAdmin.do")
public class EditerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requ�te de type GET
     * 
     * @param  reference la r�f�rence du produit � �diter
     * @return           le produit modifi� dans le model et la vue associ�e s'il existe <br/>
     *                   sinon redirection vers listerProduitAdmin.do
     */
    @GetMapping
    public ModelAndView editerProduit(@RequestParam(value = "ref", defaultValue = "") final String reference) {

        final var produitDto = iProduitService.trouverParReference(reference);

        if (produitDto == null) {
            return new ModelAndView("redirect:/listerProduitsAdmin.do");
        }
        final var modelAndView = new ModelAndView("editerProduitAdmin");
        modelAndView.getModelMap().addAttribute("produitDto", produitDto);
        return modelAndView;
    }

    /**
     * Permet de traiter la methode POST
     *
     * @param  produitDto le produit � M�j
     * @return            redirection vers listerProduitsAdmin.do
     */
    @PostMapping
    public ModelAndView soumissionFormulaire(final ProduitDto produitDto) {
        iProduitService.editerProduit(produitDto);

        return new ModelAndView("redirect:/listerProduitsAdmin.do");
    }
}
