/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurDto;
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
    private IUtilisateurService service;

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
     * @return                redirection vers connecter.do
     */
    @PostMapping
    public ModelAndView processSubmit(final UtilisateurDto utilisateurDto, final HttpServletRequest request) {
        this.service.createUtilisateur(utilisateurDto);

        if (request.getSession().getAttribute("utilisateur") == null) {
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
            return new ModelAndView("redirect:/connecter.do");
        }

        return new ModelAndView("redirect:/listerUtilisateur.do");
    }
}
