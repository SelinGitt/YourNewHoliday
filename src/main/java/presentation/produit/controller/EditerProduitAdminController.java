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
import presentation.produit.util.ServiceProduitUtil;
import presentation.produit.validator.ProduitValidatorPDT02;
import service.produit.IProduitService;

/**
 * Classe repr�sentant le controller pour �diter les produits en vue administrateur
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/editerProduitAdmin.do")
public class EditerProduitAdminController extends ServiceProduitUtil {

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
     * @param  produitDto         le produit � M�j
     * @param  result             le binding result
     * @param  redirectAttributes le message si l'�dition est ok
     * @return                    redirection vers la liste des produit (admin) sinon vers l'�cran d'�dition
     */
    @PostMapping
    public ModelAndView soumissionFormulaire(final @Validated @ModelAttribute ProduitDto produitDto, final BindingResult result,
            final RedirectAttributes redirectAttributes) {

        produitDto.setServices(this.fillServiceArray(produitDto.getServices()));

        final var modelAndView = new ModelAndView();
        // Si le formulaire poss�de des erreurs : Ajout de l'attribut "errorEdition" utilis� dans la jsp en cas d'erreur d'�dition
        if (result.hasErrors()) {
            modelAndView.setViewName("editerProduitAdmin");
            modelAndView.getModelMap().addAttribute("error", "pdt02.erreurEdition");
            return modelAndView;
        }

        final var response = iProduitService.editerProduit(produitDto);

        // Mise a jour OK
        if (response.getProduit() != null) {
            //Ajout d'un FlashAttribute pour le bandeau de validation sur PDT_01
            redirectAttributes.addFlashAttribute("anySuccess", "pdt02.editionOK");
            return new ModelAndView("redirect:/listerProduitsAdmin.do");
        }

        // Mise a jour KO
        // Code erreur renvoyer par le service
        final var error = response.getError();

        modelAndView.setViewName("editerProduitAdmin");

        switch (error) {
            case "deleted":
                modelAndView.getModelMap().addAttribute("error", "pdt02.erreurEdition.supprimer");
                break;
            case "updated":
                modelAndView.getModelMap().addAttribute("error", "pdt02.erreurEdition.outdated");
                break;
            default:
                result.rejectValue("reference", "pdt02.reference.dejaExistant");
                break;
        }

        return modelAndView;
    }
}
