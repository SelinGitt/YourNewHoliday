/**
 * 
 */
package presentation.panier.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import service.panier.IPanierService;

/**
 * Classe représentant le controller pour modifier le panier
 *
 * @author NathanR
 */
@Controller
@RequestMapping(value = "panier.do")
public class PanierModifController {

    @Autowired
    private IPanierService iPanierService;

    @GetMapping
    public ModelAndView modifier(final HttpSession session, final HttpServletRequest request) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("panier");
        final PanierDto panier = (PanierDto) session.getAttribute("panier");
        final String idProduit = request.getParameter("idProduit");
        final String quantite = request.getParameter("quantite");
        iPanierService.updatePanier(panier, Integer.valueOf(idProduit), Integer.valueOf(quantite));
        return modelAndView;
    }
}
