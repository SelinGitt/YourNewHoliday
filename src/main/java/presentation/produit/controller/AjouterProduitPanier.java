/**
 * 
 */
package presentation.produit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
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
    private IPanierService panierService;

    /**
     * Permet d'ajouter un produit au panier
     *
     * @param  idProduit l'id du produit à ajouter au panier
     * @param  quantite  la quantité de produits à ajouter
     * @param  request   la requête pour récupérer la page d'où l'on vient (PDT04 ou PDT00)
     * @return           le modelAndView avec la page de retour qu'on a récupéré dans la requête
     */
    @PostMapping
    public ModelAndView ajouterProduit(final @RequestParam("id") String idProduit, final @RequestParam("quantite") String quantite,
            final HttpServletRequest request) {
        final var modelAndView = new ModelAndView("redirect:" + request.getHeader("Referer"));
        if (!quantite.matches("[1-9][0-9]*") || Integer.parseInt(quantite) >= 100) {
            modelAndView.getModelMap().addAttribute("anyError", "pdt.quantity.notAllowed");
            return modelAndView;
        }
        final var panierDto = (PanierDto) request.getSession().getAttribute("panierDto");
        final var panierUpdated = panierService.updatePanier(panierDto, Integer.parseInt(idProduit), Integer.parseInt(quantite));
        modelAndView.getModelMap().addAttribute("panierDto", panierUpdated);
        return modelAndView;
    }
}
