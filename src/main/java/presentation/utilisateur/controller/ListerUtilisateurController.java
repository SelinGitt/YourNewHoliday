package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.utilisateur.IUtilisateurService;

/**
 * Controller pour liste les utilisateurs
 *
 * @author Valentin
 */
@Controller
@RequestMapping("/listerUtilisateur.do")
public class ListerUtilisateurController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet de recuperer la liste des utilisateurs et d'afficher la jsp
     *
     * @return Nom de la jsp a charger
     */
    @GetMapping
    public ModelAndView listerUtilisateurs() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerUtilisateur");
        modelAndView.getModelMap().addAttribute("listeUtilisateur", this.iUtilisateurService.findAllUtilisateurs());
        return modelAndView;
    }
}
