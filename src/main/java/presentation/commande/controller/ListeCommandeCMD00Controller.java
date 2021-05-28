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
public class ListeCommandeCMD00Controller {

    private final Logger     logger = LoggerFactory.getLogger(ListeCommandeCMD00Controller.class);

    @Autowired
    private ICommandeService iCommandeService;

    /**
     * Permet d'accéder à la page listerCommande do et de l'hydrater
     *
     * @param  session contient la session de l'utilisateur
     * @return         ModelAndView le modèle qui sera utiliser par la vue
     */
    @GetMapping
    public ModelAndView listerCommande(final HttpSession session) {
        final var modelAndView = new ModelAndView();
        final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        this.logger.debug("lister Commande utilisateur : {} ", String.valueOf(utilisateurConnecte.getIdUtilisateur()));
        final List<CommandeDto> listCommande = this.iCommandeService
                .listerCommandesUtilisateur(Integer.valueOf(utilisateurConnecte.getIdUtilisateur()));
        modelAndView.setViewName("listerCommande");
        modelAndView.getModelMap().addAttribute("listCommande", listCommande);
        return modelAndView;
    }

}
