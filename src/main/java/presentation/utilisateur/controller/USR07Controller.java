/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR07
 *
 * @author Damien D.
 */
@Controller
@RequestMapping("/usr07.do")
public class USR07Controller {

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
    public ModelAndView voirUSR07() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("usr07");
        modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de mettre logger un utilisateur en session
     *
     * @param  utilisateurDto : le {@link UtilisateurDto} à logger
     * @param  result         : le résultat du binding
     * @param  session        : session actuelle
     * @return                la page PDT00 avec l'UtilisateurConnecteDto en session
     */
    @PostMapping
    public String loggerUtilisateur(final UtilisateurDto utilisateurDto, final BindingResult result, final HttpSession session) {

        //On authentifie l'utilisateur grâce à ses informations de connexion
        final var utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());
        //On le passe en session
        session.setAttribute(UTILISATEUR, utilisateurConnecteDto);
        //TODO on renvoie la même page pour l'instant, à renvoyer vers PDT00 quand cette vue sera disponible
        return "usr07";
    }
}
