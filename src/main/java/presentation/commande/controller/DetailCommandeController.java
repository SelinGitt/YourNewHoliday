/**
 * 
 */
package presentation.commande.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.commande.ICommandeService;

/**
 * Classe repr�sentant le controller d'acc�s � la page CMD_04
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Controller
@RequestMapping("/detailCommande.do")
public class DetailCommandeController {

    private final Logger     logger = LoggerFactory.getLogger(DetailCommandeController.class);

    @Autowired
    private ICommandeService iCommandeService;

    /**
     * Permet d'acc�der � la page detailCommande.do (�cran CMD_04) et de l'hydrater
     *
     * @param  reference la r�f�rence de la commande � chercher
     * @param  session   contient la session de l'utilisateur
     * @param  from      signale si ce controlleur a �t� appel� par un autre
     * @return           ModelAndView le mod�le qui sera utiliser par la vue
     */
    @GetMapping
    public ModelAndView detaillerCommande(final @RequestParam(name = "ref", required = true, defaultValue = "") String reference,
            final HttpSession session, final @ModelAttribute("flag") String from) {
        final var modelAndView = new ModelAndView();
        final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        this.logger.debug("detailler la commande {} de l'utilisateur : {} ", reference, utilisateurConnecte.getIdUtilisateur());
        final var commandeDto = this.iCommandeService.chercherCommandeParReference(reference);
        modelAndView.setViewName("detailCommande");
        modelAndView.getModelMap().addAttribute("commande", commandeDto);
        modelAndView.getModelMap().addAttribute("remise", commandeDto.getRemise());
        // S'il s'agit d'une redirection depuis validerPanierCommande 
        // on affiche le message de confirmation de la validation de la commande
        // rq : les �checs de validation sont tarit� par PAN_00        
        if ("validerPanierCommande".equals(from)) {
            modelAndView.getModelMap().addAttribute("confirmationMesssage", "PAN_08.message.Confirmation");
            modelAndView.getModelMap().addAttribute("retour", "listerProduits.do");
        } else {
            modelAndView.getModelMap().addAttribute("retour", "listerCommande.do");
        }
        return modelAndView;
    }

}
