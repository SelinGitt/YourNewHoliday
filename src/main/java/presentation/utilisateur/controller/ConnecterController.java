/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR07 pour se Connecter en session
 *
 * @author Damien D.
 */
@Controller
@RequestMapping("/connecter.do")
@SessionAttributes("utilisateur")
public class ConnecterController {

    /**
     * L'utilisateur en session
     */
    public static final String  UTILISATEUR = "utilisateur";

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet d'afficher la vue de login
     * 
     * @return : un model pour le binding et la vue associée
     */
    @GetMapping
    public ModelAndView voirConnecter() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("connecter");
        modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de mettre logger un utilisateur en session
     *
     * @param  utilisateurDto : le {@link UtilisateurDto} à logger
     * @return                ModelAndView and l'utilisateur en session et le nom de la jsp
     */
    @PostMapping
    public ModelAndView loggerUtilisateur(final UtilisateurDto utilisateurDto) {

        final var modelAndView = new ModelAndView();

        //ajout d'un panier vide en session
        modelAndView.getModelMap().addAttribute("panierDto", new PanierDto());

        modelAndView.getModelMap().addAttribute(UTILISATEUR,
                iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword()));

        modelAndView.setViewName("connecter");

        return modelAndView;
    }
}
