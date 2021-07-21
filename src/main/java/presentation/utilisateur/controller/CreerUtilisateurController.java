/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.validator.CreerUtilisateurValidator;
import service.utilisateur.IUtilisateurService;
import service.utilisateur.util.UtilisateurRoleEnum;

/**
 * Controller pour création d'un utilisateur
 *
 * @author Selin
 */
@Controller
@RequestMapping("/creerUtilisateur.do")
public class CreerUtilisateurController {

    @Autowired
    private IUtilisateurService       service;

    @Autowired
    private CreerUtilisateurValidator validator;

    /**
     * Permet de traiter les requêtes GET<br>
     * et de mettre un UtilisateurDto vide dans le modèle
     * 
     * @return le Model and View
     */
    @GetMapping
    public ModelAndView afficher() {
        final var modelAndView = new ModelAndView("creerUtilisateur");

        // On creer l'utilisateur ici et lui affecte un role pour avoir une valeur par defaut dans le formulaire
        final var utilisateurDto = new UtilisateurDto();

        final var roleDto = new RoleDto();
        roleDto.setIdRole(UtilisateurRoleEnum.CLIENT.getId());

        utilisateurDto.setRole(roleDto);

        modelAndView.getModelMap().addAttribute("utilisateurDto", utilisateurDto);

        return modelAndView;
    }

    /**
     * Permet de traiter les requêtes POST<br>
     * et de créer un utilisateur
     *
     * @param  utilisateurDto l'utilisateur à créer
     * @param  request        HtppServletRequest pour gerer la redirection vers ConnecterController
     * @param  result         Resultats du binding utilisé pour gérer les erreurs
     * @param  attribute      Permet de transmettre a travers la redirection
     * @return                redirection vers connecter.do
     */
    @PostMapping
    public ModelAndView processSubmit(final UtilisateurDto utilisateurDto, final HttpServletRequest request, final BindingResult result,
            final RedirectAttributes attribute) {
        validator.validate(utilisateurDto, result);

        //Si le formulaire a des erreurs
        if (result.hasErrors()) {
            final var modelAndView = new ModelAndView("creerUtilisateur");
            modelAndView.getModelMap().addAttribute("error", "usr05.erreur.creation");
            return modelAndView;
        }

        // Si utilisateur == null, l'email est deja pris
        if (this.service.createUtilisateur(utilisateurDto) == null) {
            result.rejectValue("email", "usr05.erreur.email_taken", "Default Errror");
            final var modelAndView = new ModelAndView("creerUtilisateur");
            modelAndView.getModelMap().addAttribute("error", "usr05.erreur.creation");
            return modelAndView;
        }

        // Redirection si pas d'utilisateur
        if (request.getSession().getAttribute("utilisateur") == null) {
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
            final var modelAndView = new ModelAndView("redirect:/connecter.do");
            modelAndView.getModelMap().addAttribute("anySuccess", "usr05.success.creation");
            return modelAndView;
        }

        attribute.addFlashAttribute("userSuccess", "usr05.success.creation");

        return new ModelAndView("redirect:/listerUtilisateur.do");
    }
}
