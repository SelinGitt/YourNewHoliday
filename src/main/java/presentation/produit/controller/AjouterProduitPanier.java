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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
     * @param  beanQuantite       la quantit� de produits � ajouter, stock� dans un bean car impossible d'utiliser
     *                            directement un string
     * @param  request            la requ�te pour r�cup�rer la page d'o� l'on vient (PDT04 ou PDT00)
     * @param  panierDto          le panierDto de la session de l'utilisateur
     * @param  result             le r�sultat de la validation
     * @param  redirectAttributes utilis� pour garder l'attribut apr�s avoir fait une redirection vers la page pr�c�dente
     * @return                    le modelAndView avec la page de retour qu'on a r�cup�r� dans la requ�te
     */
    @PostMapping
    public ModelAndView ajouterProduit(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @ModelAttribute("beanQuantite") BeanQuantite beanQuantite, final HttpServletRequest request, final BindingResult result,
            final RedirectAttributes redirectAttributes) {
        final var modelAndView = new ModelAndView("redirect:" + request.getHeader("Referer"));

        quantiteValidator.validate(beanQuantite, result);
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("anyError", "pdt.quantity.notAllowed");
            return modelAndView;
        }
        final var panierUpdated = panierService.updatePanier(panierDto, Integer.parseInt(beanQuantite.getId()),
                Integer.parseInt(beanQuantite.getQuantite()));

        modelAndView.getModelMap().addAttribute("panierDto", panierUpdated);

        return modelAndView;
    }

}
