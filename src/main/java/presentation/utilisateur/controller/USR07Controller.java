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
     * @param  utilisateurDto : utilisateurDto utilis� par la vue pour authentifier
     * @return                : un model pour le binding et la vue associ�e
     */
    @GetMapping
    public ModelAndView voirUSR07(final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("usr07");
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
        return "usr07";
    }

    @ModelAttribute("utilisateurDto")
    private UtilisateurDto utilisateur() {
        final var utilisateurDto = new UtilisateurDto();
        return utilisateurDto;
    }

    @ModelAttribute("utilisateurConnecteDto")
    private UtilisateurConnecteDto utilisateurConnecte(final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto) {
        final var utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());
        return utilisateurConnecteDto;
    }
}
