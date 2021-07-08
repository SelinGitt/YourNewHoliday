/**
 * 
 */
package presentation.produit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.BeanQuantite;
import presentation.produit.validator.QuantiteValidator;
import service.panier.IPanierService;

/**
 * Classe Controlleur pour ajouter un produit au panier
 *
 * @author Lucas
 */
@Controller
@RequestMapping("/ajouterProduitPanier.do")
public class AjouterProduitPanier {

    @Autowired
    private IPanierService    panierService;

    @Autowired
    private QuantiteValidator quantiteValidator;

    /**
     * Permet d'ajouter un produit au panier
     *
     * @param  beanQuantite la quantité de produits à ajouter, stocké dans un bean car impossible d'utiliser directement un
     *                      string
     * @param  request      la requête pour récupérer la page d'où l'on vient (PDT04 ou PDT00)
     * @param  panierDto    le panierDto de la session de l'utilisateur
     * @param  result       le résultat de la validation
     * @return              le modelAndView avec la page de retour qu'on a récupéré dans la requête
     */
    @PostMapping
    public ModelAndView ajouterProduit(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @ModelAttribute("beanQuantite") BeanQuantite beanQuantite, final HttpServletRequest request, final BindingResult result) {
        final var modelAndView = new ModelAndView("redirect:" + request.getHeader("Referer"));
        quantiteValidator.validate(beanQuantite, result);
        if (result.hasErrors()) {
            modelAndView.getModelMap().addAttribute("anyError", "pdt.quantity.notAllowed");
            return modelAndView;
        }
        final Integer idProduit = Integer.parseInt(beanQuantite.getId());
        final Integer quantite = Integer.parseInt(beanQuantite.getQuantite());
        modelAndView.getModelMap().addAttribute("panierDto", panierService.updatePanier(panierDto, idProduit, quantite));

        return modelAndView;
    }

}
