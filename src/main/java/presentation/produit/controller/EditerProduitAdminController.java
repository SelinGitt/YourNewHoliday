/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.produit.dto.ProduitDto;
import presentation.produit.validator.ProduitValidatorPDT02;
import service.produit.IProduitService;

/**
 * Classe représentant le controller pour éditer les produits en vue administrateur
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/editerProduitAdmin.do")
public class EditerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de binder le produitValidator
     *
     * @param binder binder de type ProduitValidator
     */
    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.setValidator(new ProduitValidatorPDT02());
    }

    /**
     * Permet de traiter une requête de type GET
     * 
     * @param  reference la référence du produit à éditer
     * @return           le produit modifié dans le model et la vue associée s'il existe <br/>
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
     * @param  produitDto         le produit à Màj
     * @param  result             le binding result
     * @param  redirectAttributes le message si l'édition est ok
     * @return                    redirection vers la liste des produit (admin) sinon vers l'écran d'édition
     */
    @PostMapping
    public ModelAndView soumissionFormulaire(final @Validated @ModelAttribute ProduitDto produitDto, final BindingResult result,
            final RedirectAttributes redirectAttributes) {

        final var services = produitDto.getServices();
        // TODO : Amelioration possible par la suite
        final var newServices = new Boolean[] {false, false, false, false, false, false, false, false, false};

        for (var i = 0; i < services.length; i++) {
            if (services[i] != null) {
                newServices[i] = true;
            }
        }

        produitDto.setServices(newServices);

        final var modelAndView = new ModelAndView();
        // Si le formulaire possède des erreurs : Ajout de l'attribut "errorEdition" utilisé dans la jsp en cas d'erreur d'édition
        if (result.hasErrors()) {
            modelAndView.setViewName("editerProduitAdmin");
            modelAndView.getModelMap().addAttribute("error", "pdt02.erreurEdition");
            return modelAndView;
        }

        final var response = iProduitService.editerProduit(produitDto);

        if (response.getProduit() != null) {
            //Ajout d'un FlashAttribute pour le bandeau de validation sur PDT_01
            redirectAttributes.addFlashAttribute("anySuccess", "pdt02.editionOK");
            return new ModelAndView("redirect:/listerProduitsAdmin.do");
        }

        if ("reference".equals(response.getError())) {
            result.rejectValue("reference", "pdt02.reference.dejaExistant");
            modelAndView.setViewName("editerProduitAdmin");
            return modelAndView;
        }

        modelAndView.getModelMap().addAttribute("error", "pdt02.erreurEdition");
        modelAndView.setViewName("editerProduitAdmin");
        return modelAndView;
    }
}
