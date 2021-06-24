/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import presentation.panier.dto.PanierDto;
import presentation.temp.RemplirPanier;
import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.validator.ConnecterValidator;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR07 pour se Connecter en session
 *
 * @author Damien D.
 */
@Controller
@RequestMapping({"/connecter.do", "/deconnecter.do"})
@SessionAttributes({"utilisateur", "panierDto"})
public class ConnecterController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    @Autowired
    private ConnecterValidator  connecterValidator;

    /**
     * Permet d'afficher la vue de login
     * 
     * @param  request       la requête HTTP
     * @param  sessionStatus la session
     * @return               : un model pour le binding et la vue associée
     */
    @GetMapping
    public ModelAndView choixDesUrl(final HttpServletRequest request, final SessionStatus sessionStatus) {
        if (request.getRequestURI().contains("/deconnecter.do")) {
            return logout(request, sessionStatus);
        }
        return voirConnecter();
    }

    //TODO methode temporaire pour creer un panier remplis
    private PanierDto creerPanier() {
        //ajout d'un panier vide en session        
        return RemplirPanier.echantillon();
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

        final var utilisateurConnecteDto = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());

        //Si l'utilisateur n'est pas trouvé en BD, et donc null
        if (null == utilisateurConnecteDto) {
            //Ajout d'un attribut utilisé en jsp pour appeler le message passé en paramètre
            modelAndView.getModelMap().addAttribute("error", "usr07.erreur.login_failed");
            modelAndView.setViewName("connecter");
        } else {
            //On met l'utilisateur connecté en session
            modelAndView.getModelMap().addAttribute("utilisateur", utilisateurConnecteDto);

            //TODO ajout d'un panier Remplis en session pour les TESTS
            //remplacer par un panier vide par la suite
            modelAndView.getModelMap().addAttribute("panierDto", creerPanier());

            //Redirection vers page d'accueil
            modelAndView.setViewName("redirect:listerProduits.do");
        }
        return modelAndView;
    }

    /**
     * Permet de se rendre sur connecter avec un nouvelle utilisateur
     *
     * @return ModelAndView la vue et le modèle utiliser par celui ci
     */
    private ModelAndView voirConnecter() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("connecter");
        modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de détruire la session et donc de se déconnecter de l'application
     *
     * @param  request       la requête HTTP
     * @param  sessionStatus la session
     * @return               ModelAndView se rend sur la vue utiliser comme accueil
     */
    private ModelAndView logout(final HttpServletRequest request, final SessionStatus sessionStatus) {
        final HttpSession session = request.getSession();
        if (session != null) {
            sessionStatus.setComplete();
            session.invalidate();
        }
        return new ModelAndView("redirect:/listerProduits.do");
    }
}
