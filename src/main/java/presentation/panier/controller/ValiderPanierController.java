/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import presentation.panier.dto.PanierDto;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.panier.IPanierService;

/**
 * Classe représentant le Controlleur pour Valider le panier
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Controller
@RequestMapping("/validerPanier.do")
public class ValiderPanierController {

    @Autowired
    private IPanierService panierService;

    /**
     * Permet de passer un Panier à commande si toutes les conditions sont remplies
     *
     * @param  panierDto   le panier de l'utilisateur
     * @param  utilisateur l'utilisateur connecté
     * @return             String l'url vers lequel on doit se rendre
     */
    @GetMapping
    public String passerPanierACommande(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @SessionAttribute("utilisateur") UtilisateurConnecteDto utilisateur) {
        final var listProduitErreur = this.panierService.validerPanier(panierDto, Integer.parseInt(utilisateur.getIdUtilisateur()));
        if (listProduitErreur == null) {
            // On détruit la session donc le panier sera vider automatiquement
            return "redirect:deconnecter.do";
        }
        if (listProduitErreur.getReference() != null) {
            return "forward:detailCommande.do?ref=" + listProduitErreur.getReference();
        }
        // en cas d'erreur renvoie au panier
        return "redirect:listerPanierProduits.do";
    }
}
