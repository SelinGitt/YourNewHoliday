/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.BeanQuantite;
import presentation.produit.validator.QuantiteValidator;
import service.produit.IProduitService;

/**
 * Classe Controlleur pour ajouter un produit au panier
 *
 * @author Lucas
 */
@Controller
@RequestMapping("/ajouterProduitPanier.do")
public class AjouterProduitPanier {
    @Autowired
    private IProduitService   iProduitService;
    @Autowired
    private QuantiteValidator quantiteValidator;

    /**
     * Permet d'ajouter un produit au panier
     *
     * @param  beanQuantite la quantité de produits à ajouter, stocké dans un bean car impossible d'utiliser directement un
     *                      string
     * @param  panierDto    le panierDto de la session de l'utilisateur
     * @param  result       le résultat de la validation
     * @param  location     page d'origine
     * @return              le modelAndView avec la page de retour qu'on a récupéré dans la requête
     */
    @PostMapping
    public ModelAndView ajouterProduit(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @ModelAttribute("beanQuantite") BeanQuantite beanQuantite, final BindingResult result,
            final @RequestParam("location") String location) {
        final var modelAndView = new ModelAndView();
        if ("lister".equals(location)) {
            modelAndView.setViewName("redirect:listerProduits.do");
        } else
            //si dans la jsp location = "consulter"
            if ("consulter".equals(location)) {
                modelAndView.setViewName("redirect:consulterProduit.do");
                //recuperer l'id de la quantité pour mettre la valeur de l'id en attribut
                modelAndView.getModelMap().addAttribute("idProduit", Integer.valueOf(beanQuantite.getId()));
            } else {
                return new ModelAndView("404.do");
            }
        quantiteValidator.validate(beanQuantite, result);
        if (result.hasErrors()) {
            modelAndView.getModelMap().addAttribute("anyError", "pdt.quantity.notAllowed");
            return modelAndView;
        }
        final var updatePanier = iProduitService.updatePanier(panierDto, beanQuantite);
        if (updatePanier != null) {
            modelAndView.getModelMap().addAttribute("panierDto", updatePanier);
        }
        return modelAndView;
    }

}
