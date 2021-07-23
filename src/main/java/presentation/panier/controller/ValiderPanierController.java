/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.commande.dto.AdressesDto;
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
     * @param  panierDto          le panier de l'utilisateur
     * @param  utilisateur        l'utilisateur connecté
     * @param  adresses           liste des adresses récupérer du formulaire
     * @param  redirectAttributes signalement de redirection au controlleur ciblé
     * @return                    String l'url vers lequel on doit se rendre
     */
    @PostMapping
    public String passerPanierACommande(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @SessionAttribute("utilisateur") UtilisateurConnecteDto utilisateur,
            final @ModelAttribute("adresses") AdressesDto adresses, final RedirectAttributes redirectAttributes) {
        final var referenceCommandeOuListProduitErreur = this.panierService.validerPanier(panierDto, adresses,
                Integer.parseInt(utilisateur.getIdUtilisateur()));
        if (referenceCommandeOuListProduitErreur == null) {
            // On détruit la session donc le panier sera vider automatiquement (ici l'utilisateur a été supprimé et est null)
            return "redirect:deconnecter.do";
        }
        if (referenceCommandeOuListProduitErreur.getReference() == null) {
            // en cas d'erreur renvoie au panier
            return "redirect:listerPanierProduits.do";
        }
        // On précise au controlleur de détail commande le controlleur origine de la redirection
        redirectAttributes.addFlashAttribute("flag", "validerPanierCommande");
        // redirige vers la page de détail des commandes
        return "redirect:detailCommande.do?ref=" + referenceCommandeOuListProduitErreur.getReference();
    }
}
