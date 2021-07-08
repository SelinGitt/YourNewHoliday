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
import service.utilisateur.IUtilisateurService;

/**
 * Classe représentant le Controlleur pour Valider le panier
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Controller
@RequestMapping("/validerPanier.do")
public class ValiderPanierController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    @Autowired
    private IPanierService      panierService;

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
        System.out.println("utilisateur : " + utilisateur);
        System.out.println("panier : " + panierDto);
        if (this.iUtilisateurService.findUtilisateurById(Integer.parseInt(utilisateur.getIdUtilisateur())) == null) {
            // On détruit la session donc le panier sera vider automatiquement
            return "redirect:deconnecter.do";
        }
        return "forward:detailCommande.do?ref=ABC3";
    }
}
