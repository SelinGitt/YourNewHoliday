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
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR07 pour se Connecter en session
 *
 * @author Damien D.
 */
@Controller
@RequestMapping("/connecter.do")
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
     * @param  result         : le r�sultat du binding
     * @param  session        : session actuelle
     * @return                la page PDT00 avec l'UtilisateurConnecteDto en session
     */
    @PostMapping
    public String loggerUtilisateur(final UtilisateurDto utilisateurDto, final BindingResult result, final HttpSession session) {

        //On authentifie l'utilisateur gr�ce � ses informations de connexion
        final var utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());
        //On le passe en session
        session.setAttribute(UTILISATEUR, utilisateurConnecteDto);
        //TODO on renvoie la m�me page pour l'instant, � renvoyer vers PDT00 quand cette vue sera disponible
        return "connecter";
    }

    @ModelAttribute("utilisateurConnecteDto")
    private UtilisateurConnecteDto utilisateurConnecte(final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto) {
        final var utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());
        return utilisateurConnecteDto;
    }
}
