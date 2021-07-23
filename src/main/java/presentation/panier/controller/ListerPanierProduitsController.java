/**
 * 
 */
package presentation.panier.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import service.panier.IPanierService;

/**
 * Class represents PanierProduitsController
 *
 * @author Steve
 */
@Controller
@RequestMapping("/listerPanierProduits.do")
public class ListerPanierProduitsController {

    @Autowired
    private IPanierService panierService;

    /**
     * Permet d'afficher la page PanierProduits
     * 
     * @param  panierDto : panierDto vide
     * @return           le nom de la définition pour PanierProduits
     */
    @GetMapping
    public ModelAndView displayPanierProduits(final @SessionAttribute("panierDto") PanierDto panierDto, final HttpSession session,
            final @ModelAttribute("listIdError") String listIdError) {
        final var modelAndView = new ModelAndView();
        // on met à jour le prix total, la remise et le prix après remise du panier
        panierService.actualiserPrix(panierDto);
        // si le panier recuperé est vide
        if (panierDto.getMapPanier().isEmpty()) {
            modelAndView.setViewName("pan_00_vide");
            modelAndView.getModelMap().addAttribute("errorPanVide", "pan00.erreur.vide");
        } else {
            modelAndView.getModelMap().addAttribute("listIdError", listIdError);
            modelAndView.setViewName("pan_00");
        }
        return modelAndView;
    }

    //    @GetMapping
    //    public ModelAndView detaillerCommande(final @RequestParam(name = "ref", required = true, defaultValue = "") String reference,
    //            final HttpSession session, final @ModelAttribute("flag") String from) {
    //        final var modelAndView = new ModelAndView();
    //        final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
    //        this.logger.debug("detailler la commande {} de l'utilisateur : {} ", reference, utilisateurConnecte.getIdUtilisateur());
    //        final var commandeDto = this.iCommandeService.chercherCommandeParReference(reference);
    //        modelAndView.setViewName("detailCommande");
    //        modelAndView.getModelMap().addAttribute("commande", commandeDto);
    //        modelAndView.getModelMap().addAttribute("remise", commandeDto.getRemise());
    //        // S'il s'agit d'une redirection depuis validerPanierCommande
    //        // on affiche le message de confirmation de la validation de la commande
    //        // rq : les échecs de validation sont tarité par PAN_00       
    //        if ("validerPanierCommande".equals(from)) {
    //            modelAndView.getModelMap().addAttribute("confirmationMesssage", "PAN_08.message.Confirmation");
    //        }
    //        return modelAndView;
    //    }

}
