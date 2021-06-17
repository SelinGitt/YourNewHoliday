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

    @Autowired
    private IUtilisateurService iUtilisateurService;

    @Autowired
    private ConnecterValidator  connecterValidator;

    /**
     * Permet d'afficher la vue de login
     * 
     * @param  session        : HttpSession utilis� uniquement pour clore la session en cours en arrivant sur le controller
     * @param  utilisateurDto : l'utilisateurDto utilis� pour le formulaire
     * @return                : un model pour le binding et la vue associ�e
     */
    @GetMapping
    public ModelAndView voirConnecter(final HttpSession session, final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto) {

        //TODO � retirer quand la d�connexion sera g�r�e
        session.invalidate();

        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("connecter");
        return modelAndView;
    }

    /**
     * Permet de mettre logger un utilisateur en session
     *
     * @param  utilisateurDto : le {@link UtilisateurDto} � logger
     * @param  result         : resultats du binding utilis� pour g�rer les erreurs
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

        final var utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());

        //Si l'utilisateur n'est pas trouv� en BD, et donc null
        if (null == utilisateurConnecteDto) {
            //Ajout d'un attribut utilis� en jsp pour appeler le message pass� en param�tre
            modelAndView.getModelMap().addAttribute("error", "usr07.erreur.login_failed");
            modelAndView.setViewName("connecter");
        } else {
            //On met l'utilisateur connect� en session
            modelAndView.getModelMap().addAttribute("utilisateur", utilisateurConnecteDto);
            //Redirection vers page d'accueil
            modelAndView.setViewName("listerProduits");
        }
        return modelAndView;
    }

    @ModelAttribute("utilisateurDto")
    private UtilisateurDto retournerDto() {
        return new UtilisateurDto();
    }
}
