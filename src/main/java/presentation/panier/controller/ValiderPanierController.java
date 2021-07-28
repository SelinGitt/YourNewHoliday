/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.commande.dto.AdressesDto;
import presentation.panier.dto.PanierDto;
import presentation.panier.validator.ListerPanierAdressesValidator;
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
    private ListerPanierAdressesValidator panierValidator;

    @Autowired
    private IPanierService                panierService;

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
    public ModelAndView passerPanierACommande(final @SessionAttribute("panierDto") PanierDto panierDto,
            final @SessionAttribute("utilisateur") UtilisateurConnecteDto utilisateur,
            final @ModelAttribute("adresses") AdressesDto adresses, final BindingResult result,
            final RedirectAttributes redirectAttributes) {
        final var modelAndView = new ModelAndView();
        panierValidator.validate(adresses, result);
        //Si le formulaire a des erreurs
        if (result.hasErrors()) {
            //Ajout d'un attribut utilisé en jsp pour appeler le message passé en paramètre
            modelAndView.getModelMap().addAttribute("error", "pan08.erreur.validation_failed");
            modelAndView.setViewName("listerPanierAdresses");
            return modelAndView;
        }
        final var referenceCommandeOuListProduitErreur = this.panierService.validerPanier(panierDto, adresses,
                Integer.parseInt(utilisateur.getIdUtilisateur()));
        if (referenceCommandeOuListProduitErreur == null) {
            modelAndView.setViewName("redirect:deconnecter.do");
            // On détruit la session donc le panier sera vider automatiquement (ici l'utilisateur a été supprimé et est null)
            return modelAndView;
        }
        if (referenceCommandeOuListProduitErreur.getReference() == null) {
            // On passe la liste des Id problématiques en attribut pour les renvoyer au controller suivant
            modelAndView.getModelMap().addAttribute("listIdError", referenceCommandeOuListProduitErreur.getListIdProduitNonConcordant());
            // en cas d'erreur renvoie au panier
            modelAndView.setViewName("redirect:listerPanierProduits.do");
            return modelAndView;
        }
        // On précise au controlleur de détail commande le controlleur origine de la redirection
        modelAndView.getModelMap().addAttribute("flag", "validerPanierCommande");
        // redirige vers la page de détail des commandes
        modelAndView.setViewName("redirect:detailCommande.do?ref=" + referenceCommandeOuListProduitErreur.getReference());
        return modelAndView;
    }
}
