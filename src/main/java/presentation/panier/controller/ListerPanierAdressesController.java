/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Classe représentant le controller de listerPanierAdresses
 *
 * @author Alexandre
 */
@Controller
@RequestMapping("/listerPanierAdresses.do")
public class ListerPanierAdressesController {

    @Autowired
    private IUtilisateurService utilisateurService;

    /**
     * Permet d'afficher la JSP listerPanierAdresses
     * 
     * @param  utilisateurDto :
     * @return                : le nom de la JSP
     */
    @GetMapping
    public ModelAndView listerAdresses(final @SessionAttribute("utilisateur") UtilisateurConnecteDto utilisateurDto) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerPanierAdresses");
        final var id = Integer.valueOf(utilisateurDto.getIdUtilisateur());
        final UtilisateurDto utilisateur = utilisateurService.findUtilisateurById(id);
        modelAndView.getModelMap().addAttribute("utilisateurDto", utilisateur);
        return modelAndView;
    }

}
