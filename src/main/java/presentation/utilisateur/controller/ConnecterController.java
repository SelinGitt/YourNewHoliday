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

import presentation.utilisateur.dto.UtilisateurDto;
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

    //    @InitBinder
    //    private void initBinder(final WebDataBinder webDataBinder) {
    //        webDataBinder.setValidator(new ConnecterValidator());
    //    }

    /**
     * Permet d'afficher la vue de login
     * 
     * @return : un model pour le binding et la vue associ�e
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
     * @param  utilisateurDto : le {@link UtilisateurDto} � logger
     * @return                ModelAndView and l'utilisateur en session et le nom de la jsp
     */
    @PostMapping
    public ModelAndView loggerUtilisateur(final UtilisateurDto utilisateurDto) {

        final var modelAndView = new ModelAndView();

        modelAndView.getModelMap().addAttribute("utilisateurConnecteDto",
                iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword()));

        modelAndView.setViewName("connecter");

        return modelAndView;
    }

    //    /**
    //     * Permet de mettre logger un utilisateur en session
    //     *
    //     * @param  utilisateurDto : le {@link UtilisateurDto} � logger
    //     * @return                ModelAndView and l'utilisateur en session et le nom de la jsp
    //     */
    //    @PostMapping
    //    public ModelAndView loggerUtilisateur(final UtilisateurDto utilisateurDto) {
    //
    //        final var modelAndView = new ModelAndView();
    //
    //        final UtilisateurConnecteDto utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(),
    //                utilisateurDto.getPassword());
    //
    //        if (null != utilisateurConnecteDto) {
    //
    //            //appel � une m�thode qui a un @ModelAttribute
    //            //methode(UtilisateurConnecteDto) -> retourne UtilisateurConnecteDto
    //
    ////            retournerConnecteDto(utilisateurConnecteDto);
    //
    //            modelAndView.getModelMap().addAttribute("utilisateurConnecteDto", utilisateurConnecteDto);
    //
    //            modelAndView.setViewName("exemple");
    //
    //        } else {
    //            modelAndView.setViewName("connecter");
    //        }
    //
    //        return modelAndView;
    //    }

    //    @ModelAttribute("utilisateurConnecteDto")
    //    private UtilisateurConnecteDto retournerConnecteDto(final UtilisateurConnecteDto utilisateurConnecteDto) {
    //        return utilisateurConnecteDto;
    //    }
}
