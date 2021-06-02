/**
 * 
 */
package presentation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import presentation.validator.USR07Validator;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR07
 *
 * @author Administrateur
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

    @InitBinder
    private void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new USR07Validator());
    }

    /**
     * Permet d'afficher la vue de login
     * 
     * @param  session : session actuelle
     * @return         : un model pour le binding et la vue associée
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView voirUSR07(final HttpSession session) {
        final ModelAndView modelAndView = new ModelAndView();
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
    @RequestMapping(method = RequestMethod.POST)
    public String loggerUtilisateur(final @Validated UtilisateurDto utilisateurDto, final BindingResult result, final HttpSession session) {

        if (result.hasErrors()) {
            result.rejectValue(null, "usr07.erreur.login_failed", "Default Error");
            return "usr07";
        }
        final UtilisateurConnecteDto utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(),
                utilisateurDto.getPassword());
        if (utilisateurConnecteDto == null) {
            result.rejectValue(null, "usr07.erreur.login_failed", "Default Error");
            return "usr07";
        }
        session.setAttribute(UTILISATEUR, utilisateurConnecteDto);
        return "usr07";
    }
}
