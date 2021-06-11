/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.validator.ConnecterValidator;
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

    @Autowired
    private ConnecterValidator  connecterValidator;

    /**
     * Permet d'afficher la vue de login
     * 
     * @param  session        : HttpSession utilisé uniquement pour clore la session en cours en arrivant sur le controller
     * @param  utilisateurDto : l'utilisateurDto utilisé pour le formulaire
     * @return                : un model pour le binding et la vue associée
     */
    @GetMapping
    public ModelAndView voirConnecter(final HttpSession session, final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto) {

        //TODO à retirer quand la déconnexion sera gérée
        session.invalidate();

        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("connecter");
        return modelAndView;
    }

    /**
     * Permet de mettre logger un utilisateur en session
     *
     * @param  utilisateurDto : le {@link UtilisateurDto} à logger
     * @param  result         : resultats du binding utilisé pour gérer les erreurs
     * @param  modelAndView   : ModelAndView du controller
     * @return                : ModelAndView and l'utilisateur en session et le nom de la jsp
     */
    @PostMapping
    public ModelAndView loggerUtilisateur(final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto, final BindingResult result,
            final ModelAndView modelAndView) {

        connecterValidator.validate(utilisateurDto, result);

        //Si le formulaire a des erreurs
        if (result.hasErrors()) {
            modelAndView.setViewName("connecter");
            return modelAndView;
        }

        final UtilisateurConnecteDto utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(),
                utilisateurDto.getPassword());

        //Si l'utilisateur est trouvé en BD et renvoyé
        if (null != utilisateurConnecteDto) {
            modelAndView.getModelMap().addAttribute("utilisateur", utilisateurConnecteDto);
            //TODO rediriger vers la page d'accueil au lieu d' "exemple.do"
            modelAndView.setViewName("exemple");
        } else {
            //Si l'utilisateur n'est pas trouvé en BD, et donc null
            //Ajout d'un attribut utilisé en jsp pour appeler le message passé en paramètre
            modelAndView.getModelMap().addAttribute("error", "usr07.erreur.login_failed");
            modelAndView.setViewName("connecter");
        }
        return modelAndView;
    }

    @ModelAttribute("utilisateurDto")
    private UtilisateurDto retournerDto() {
        final UtilisateurDto utilisateurDto = new UtilisateurDto();
        return utilisateurDto;
    }
}
