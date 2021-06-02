/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR07
 *
 * @author Administrateur
 */
@Controller
@RequestMapping("/usr07.do")
public class USR_07Controller {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet d'afficher la vue de login
     *
     * @return un model pour le binding et la vue associée
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView voirFormulaire() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usr07");
//        modelAndView.setViewName("exemple");
        modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de mettre logger un utilisateur en session
     *
     * @param utilisateurDto : le {@link UtilisateurDto} à logger
     * @param result : le résultat du binding
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String loggerUtilisateur(final @Validated UtilisateurDto utilisateurDto, final BindingResult result) {
        if (result.hasErrors()) {
            result.rejectValue(null, "usr07.erreur.login_failed", "Default Error");
            return "usr07";
        }
        final UtilisateurConnecteDto utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());
        if (utilisateurConnecteDto == null) {
            result.rejectValue(null, "usr07.erreur.login_failed", "Default Error");
            return "usr07";
        }
        return "redirect:exemple.do";
    }

    /**
     * Getter for iUtilisateurService
     *
     * @return the iUtilisateurService
     */
    public IUtilisateurService getiUtilisateurService() {
        return iUtilisateurService;
    }

    /**
     * Setter for iUtilisateurService
     *
     * @param iUtilisateurService the iUtilisateurService to set
     */
    public void setiUtilisateurService(final IUtilisateurService iUtilisateurService) {
        this.iUtilisateurService = iUtilisateurService;
    }
}
