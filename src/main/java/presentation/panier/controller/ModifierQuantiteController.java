/**
 * 
 */
package presentation.panier.controller;

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
import service.panier.IPanierService;

/**
 * Class represents controller pour les boutons modifiant la quantit� d'une produit du panier
 *
 * @author Steve
 */

@Controller
@RequestMapping("/modifierQuantite.do")
public class ModifierQuantiteController {

    @Autowired
    private IPanierService panierService;

    /**
     * Permets de modifier la quantit� d'une produit du panier
     *
     * @param  panierDto          le panier
     * @param  request            envoy�e
     * @param  redirectAttributes pour ajouter la liste d'erreur si besoin
     * @return                    le model and view
     */
    @GetMapping
    public ModelAndView modifierQuantite(final @SessionAttribute("panierDto") PanierDto panierDto, final HttpServletRequest request,
            final RedirectAttributes redirectAttributes) {
        final var modelAndView = new ModelAndView();
        // quoiqu'il arrive on redirige vers le panier
        modelAndView.setViewName("redirect:listerPanierProduits.do");
        final var id = Integer.valueOf(request.getParameter("idProduit"));
        final boolean traitementOk = panierService.modifierQuantite(panierDto, id, Integer.valueOf(request.getParameter("quantite")));

        if (!traitementOk) {
            redirectAttributes.addFlashAttribute("listIdError", List.of(id));
        }

        return modelAndView;
    }

}
