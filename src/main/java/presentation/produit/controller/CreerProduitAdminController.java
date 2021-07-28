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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.produit.dto.ProduitDto;
import presentation.produit.validator.ProduitValidatorPDT03;
import service.produit.IProduitService;

/**
 * Classe représentant le controller pour creer un produit en tant qu'admin
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/creerProduitAdmin.do")
public class CreerProduitAdminController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de binder le produitValidator
     *
     * @param binder binder de type ProduitValidator
     */
    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.setValidator(new ProduitValidatorPDT03());
    }

    /**
     * Permet de traiter une requête de type GET<br>
     * et de mettre un ProduitDto vide dans la modelMap
     * 
     * @param  cheminImage le chemin de image à appliquer
     * @return             le model et la vue associée
     */
    @GetMapping
    public ModelAndView voirFormulaireCreerProduit(final @ModelAttribute(value = "image") String cheminImage) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("creerProduitAdmin");
        if (cheminImage != null) {
            modelAndView.getModelMap().addAttribute("image", cheminImage);
        }
        modelAndView.getModelMap().addAttribute("produitDto", new ProduitDto());
        return modelAndView;
    }

    /**
     * Méthode POST pour la création d'un produit via un formulaire<br>
     * et de creer un nouveau produit
     *
     * @param  produitDto         le produit Dto utilisé pour le binding
     * @param  result             le binding result
     * @param  redirectAttributes le message si la création est OK
     * @return                    vers une creerProduitAdmin.jsp
     */
    @PostMapping
    public ModelAndView creerProduit(final @Validated @ModelAttribute("produitDto") ProduitDto produitDto, final BindingResult result,
            final RedirectAttributes redirectAttributes) {
        final var modelAndView = new ModelAndView();
        // Si le formulaire possède des erreurs : Ajout de l'attribut "errorCreationProduit" utilisé dans la jsp en cas d'erreur de création
        if (result.hasErrors()) {
            modelAndView.setViewName("creerProduitAdmin");
            modelAndView.getModelMap().addAttribute("error", "pdt03.erreurCreation");
            return modelAndView;
        }

        if (iProduitService.creerProduit(produitDto) != null) {
            //Ajout d'un FlashAttribute pour le bandeau de validation sur PDT_01
            redirectAttributes.addFlashAttribute("anySuccess", "pdt03.creationOK");
            return new ModelAndView("redirect:/listerProduitsAdmin.do");
        }
        result.rejectValue("reference", "pdt03.reference.dejaExistant");
        modelAndView.setViewName("creerProduitAdmin");
        return modelAndView;
    }
}
