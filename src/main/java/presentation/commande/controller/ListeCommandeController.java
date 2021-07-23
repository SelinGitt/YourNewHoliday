/**
 * 
 */
package presentation.commande.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentation.commande.dto.CommandeDto;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.commande.ICommandeService;

/**
 * Classe représentant le controller pour l'écran CMD_00
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
@Controller
@RequestMapping("/listerCommande.do")
public class ListeCommandeController {

    private final Logger     logger = LoggerFactory.getLogger(ListeCommandeController.class);

    @Autowired
    private ICommandeService iCommandeService;

    /**
     * Permet d'accéder à la page listerCommande do et de l'hydrater
     * 
     * @param  idUtilisateur ID de l'utilisateur si on souhaite recup les commandes via liste user admin
     * @param  session       contient la session de l'utilisateur
     * @return               ModelAndView le modèle qui sera utiliser par la vue
     */
    @GetMapping
    public ModelAndView listerCommande(final @RequestParam(name = "id", required = false, defaultValue = "") String idUtilisateur,
            final HttpSession session) {
        if (idUtilisateur.isEmpty()) {
            final var modelAndView = new ModelAndView();
            final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
            this.logger.debug("lister Commande utilisateur : {} ", utilisateurConnecte.getIdUtilisateur());
            final List<CommandeDto> listCommande = this.iCommandeService
                    .listerCommandesUtilisateur(Integer.valueOf(utilisateurConnecte.getIdUtilisateur()));
            modelAndView.setViewName("listerCommande");
            modelAndView.getModelMap().addAttribute("listCommande", listCommande);
            return modelAndView;
        }

        this.logger.debug("lister Commande utilisateur : {} ", idUtilisateur);
        final List<CommandeDto> listCommande = this.iCommandeService.listerCommandesUtilisateur(Integer.valueOf(idUtilisateur));

        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerCommande");
        modelAndView.getModelMap().addAttribute("listCommande", listCommande);
        return modelAndView;
    }

}
