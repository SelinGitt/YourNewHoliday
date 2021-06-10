/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
@SessionAttributes("utilisateurConnecteDto")
public class ConnecterController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    @InitBinder
    private void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new ConnecterValidator());
    }

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

    //    /**
    //     * Permet de mettre logger un utilisateur en session
    //     *
    //     * @param  utilisateurDto : le {@link UtilisateurDto} à logger
    //     * @return                ModelAndView and l'utilisateur en session et le nom de la jsp
    //     */
    //    @PostMapping
    //    public ModelAndView loggerUtilisateur(final UtilisateurDto utilisateurDto) {
    //
    //        final var modelAndView = new ModelAndView();
    //
    //        modelAndView.getModelMap().addAttribute(UTILISATEUR,
    //                iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword()));
    //
    //        modelAndView.setViewName("connecter");
    //
    //        return modelAndView;
    //    }

    /**
     * Permet de mettre logger un utilisateur en session
     *
     * @param  utilisateurDto : le {@link UtilisateurDto} à logger
     * @param  result         : les résultats du binding
     * @return                ModelAndView and l'utilisateur en session et le nom de la jsp
     */
    @PostMapping
    public ModelAndView loggerUtilisateur(final @Validated @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto,
            final BindingResult result) {

        final var modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("connecter");
            return modelAndView;
        }

        final UtilisateurConnecteDto utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(),
                utilisateurDto.getPassword());

        if (null != utilisateurConnecteDto) {

            //            //appel à une méthode qui a un @ModelAttribute
            //            //methode(UtilisateurConnecteDto) -> retourne UtilisateurConnecteDto

            modelAndView.setViewName("exemple");

        } else {
            result.reject("usr07.erreur.login_failed", "Default Error");
            modelAndView.setViewName("connecter");
        }

        return modelAndView;
    }

    @ModelAttribute("utilisateurConnecteDto")
    private UtilisateurConnecteDto retournerConnecteDto(final UtilisateurConnecteDto utilisateurConnecteDto) {
        return utilisateurConnecteDto;
    }
}
