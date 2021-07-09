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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import presentation.produit.dto.ProduitDto;
import presentation.produit.validator.ProduitValidator;
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
        binder.setValidator(new ProduitValidator());
    }

    /**
     * Permet de traiter une requête de type GET<br>
     * et de mettre un ProduitDto vide dans la modelMap
     *
     * @return le model et la vue associée
     */
    @GetMapping
    public ModelAndView voirFormulaireCreerProduit() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("creerProduitAdmin");
        modelAndView.getModelMap().addAttribute("produitDto", new ProduitDto());
        return modelAndView;
    }

    /**
     * Méthode POST pour la création d'un produit via un formulaire<br>
     * et de creer un nouveau produit
     *
     * @param  produitDto   le produit Dto utilisé pour le binding
     * @param  result       le binding result
     * @param  status       le status de la session
     * @param  modelAndView le model et le nom de la jsp associée
     * @return              vers une creerProduitAdmin.jsp
     */
    @PostMapping
    public ModelAndView creerProduit(final @Validated @ModelAttribute("produitDto") ProduitDto produitDto, final BindingResult result,
            final SessionStatus status, final ModelAndView modelAndView) {

        // Si le formulaire possède des erreurs
        if (result.hasErrors()) {
            modelAndView.setViewName("creerProduitAdmin");
            modelAndView.getModelMap().addAttribute("errorCreationProduit", "pdt03.erreurCreation");
            return modelAndView;
        }

        // Si le produit n'est pas créé (retour null)
        // Ajout de l'attribut "ErrorCreate" utilisé dans la jsp en cas d'erreur de création
        if (iProduitService.creerProduit(produitDto) != null) {
            return new ModelAndView("redirect:/listerProduitsAdmin.do");
        }
        return new ModelAndView("creerProduitAdmin");
    }
}
