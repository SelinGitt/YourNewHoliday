/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.panier.dto.PanierDto;
import service.commande.ICommandeService;

/**
 * Controller permettant de valider le panier produits
 *
 * @author NathanR
 */
@Controller
@RequestMapping("/validerPanierProduits.do")
public class ValiderPanierProduitsController {

    @Autowired
    private ICommandeService commandeService;

    /**
     * Permet de passer du premier au second �cran de validation du panier si toutes les conditions sont remplies
     *
     * @param  panierDto          le panier de l'utilisateur
     * @param  utilisateur        l'utilisateur connect�
     * @param  adresses           liste des adresses r�cup�rer du formulaire
     * @param  redirectAttributes permet de rediriger les attributs n�cessaires au controller suivant
     * @return                    le nom de l'�cran vers lequel se diriger
     */
    @GetMapping
    public String passerPanier00APanier08(final @SessionAttribute("panierDto") PanierDto panierDto,
            final RedirectAttributes redirectAttributes) {
        final var listIdError = this.commandeService.verifierProduitsAvecVersion(panierDto.getMapPanier());
        if (listIdError.size() > 0) {
            redirectAttributes.addFlashAttribute("listIdError", listIdError);
            // en cas d'erreur renvoie au panier
            return "redirect:listerPanierProduits.do";
        }
        // redirige vers la page de d�tail des commandes
        return "redirect:listerPanierAdresses.do";
    }
}
