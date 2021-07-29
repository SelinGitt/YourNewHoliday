/**
 * 
 */
package presentation.panier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.panier.dto.PanierDto;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;

/**
 * Class represents controller pour les boutons modifiant la quantité d'une produit du panier
 *
 * @author Steve
 */

@Controller
@RequestMapping("/modifierQuantite.do")
public class ModifierQuantiteController {
    @Autowired
    private IPanierService  panierService;

    @Autowired
    private IProduitService produitService;

    /**
     * Permets de modifier la quantité d'une produit du panier
     *
     * @param  panierDto le panier
     * @param  request   envoyée
     * @param redirectAttributes pour ajouter la liste d'erreur si besoin
     * @return           le model and view
     */
    @GetMapping
    public ModelAndView modifierQuantite(final @SessionAttribute("panierDto") PanierDto panierDto, final HttpServletRequest request,
            final RedirectAttributes redirectAttributes) {
        final var modelAndView = new ModelAndView();
        // quoiqu'il arrive on redirige vers le panier
        modelAndView.setViewName("redirect:listerPanierProduits.do");
        final var id = Integer.valueOf(request.getParameter("idProduit"));
        // test de conformité
        if (!isConforme(id)) {
            final List<Integer> listIdError = new ArrayList<>();
            listIdError.add(id);
            redirectAttributes.addFlashAttribute("listIdError", listIdError);
            return modelAndView;
        }
        panierService.modifierQuantite(panierDto, id, Integer.valueOf(request.getParameter("quantite")));
        return modelAndView;

    }

    private boolean isConforme(final Integer id) {
        final ProduitDto produitEnvente = produitService.trouverProduitEnVente(id);
        if (produitEnvente == null) {
            return false;
        }
        // TODO : controle de la version.
        return true;
    }

}
