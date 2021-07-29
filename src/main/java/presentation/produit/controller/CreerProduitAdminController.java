/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    private IProduitService       iProduitService;

    @Autowired
    private ProduitValidatorPDT03 validateur;

    /**
     * Permet de traiter une requête de type GET<br>
     * et de mettre un ProduitDto vide dans la modelMap
     * 
     * @param  cheminImage : chemin de l'image
     * @param  codeError   : code d'erreur
     * @return             le model et la vue associée
     */
    @GetMapping
    public ModelAndView voirFormulaireCreerProduit(final @ModelAttribute(value = "image") String cheminImage,
            final @ModelAttribute("imgError") String codeError) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("creerProduitAdmin");

        final var produit = new ProduitDto();

        // TODO : Amelioration possible par la suite
        produit.setServices(new Boolean[] {false, false, false, false, false, false, false, false, false});

        modelAndView.getModelMap().addAttribute("produitDto", produit);
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
    public ModelAndView creerProduit(final @ModelAttribute("produitDto") ProduitDto produitDto, final BindingResult result,
            final RedirectAttributes redirectAttributes) {

        validateur.validate(produitDto, result);

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
