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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.panier.dto.PanierDto;
import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.validator.ConnecterValidator;
import service.util.GetPropertyValues;
import service.util.NumberUtils;
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

    private int                 intervaleParDefault = 20;

    @Autowired
    private IUtilisateurService iUtilisateurService;

    @Autowired
    private ConnecterValidator  connecterValidator;

    /**
     * Permet d'afficher la vue de login
     * 
     * @param  request            la requ�te HTTP
     * @param  sessionStatus      la session
     * @param  code               : String code d'erreur plac� en ModelAttribute
     * @param  redirectAttributes : attributs de redirection
     * @return                    : un model pour le binding et la vue associ�e
     */
    @GetMapping
    public ModelAndView choixDesUrl(final HttpServletRequest request, final SessionStatus sessionStatus,
            final @ModelAttribute("deletionSuccess") String code, final RedirectAttributes redirectAttributes) {
        if (request.getRequestURI().contains("/deconnecter.do")) {
            return logout(request, sessionStatus, code, redirectAttributes);
        }
        return voirConnecter();
    }

    /**
     * Permet de mettre logger un utilisateur en session
     * 
     * @param  session        : la session http
     * @param  utilisateurDto : le {@link UtilisateurDto} � logger
     * @param  result         : resultats du binding utilis� pour g�rer les erreurs
     * @param  modelAndView   : ModelAndView du controller
     * @param  anySuccess     : Message de success
     * @return                : ModelAndView and l'utilisateur en session et le nom de la jsp
     */
    @PostMapping
    public ModelAndView loggerUtilisateur(final HttpSession session, final @ModelAttribute("utilisateurDto") UtilisateurDto utilisateurDto,
            final BindingResult result, final ModelAndView modelAndView, final @ModelAttribute("anySuccess") String anySuccess) {
        connecterValidator.validate(utilisateurDto, result);

        //Si le formulaire a des erreurs
        if (result.hasErrors()) {
            modelAndView.setViewName("connecter");
            //Ajout d'un attribut utilis� en jsp pour appeler le message pass� en param�tre
            modelAndView.getModelMap().addAttribute("error", "usr07.erreur.login_failed");
            return modelAndView;
        }

        //R�cup�ration de l'objet retour de la m�thode authentify (UtilisateurConnecteDto et boolean)
        final var utilisateurServiceAuthReturn = iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword());
        //Le UtilisateurConnecteDto
        final var utilisateurConnecteDto = utilisateurServiceAuthReturn.getUtilisateurConnecteDto();
        //Le boolean
        final var isDesactive = utilisateurServiceAuthReturn.isDesactive();

        //Si l'utilisateur n'est pas trouv� en BD, ou si le compte est d�sactiv�, il est null
        if (null == utilisateurConnecteDto) {
            modelAndView.setViewName("connecter");
            if (isDesactive) {
                //Si l'utilisateur est d�sactiv�
                modelAndView.getModelMap().addAttribute("error", "usr07.erreur.deactivated");
            } else {
                //Ajout d'un attribut utilis� en jsp pour appeler le message pass� en param�tre
                modelAndView.getModelMap().addAttribute("error", "usr07.erreur.login_failed");
            }
        } else {
            //On met l'utilisateur connect� en session
            modelAndView.getModelMap().addAttribute("utilisateur", utilisateurConnecteDto);

            //Ajout d'un panier vide � la session
            modelAndView.getModelMap().addAttribute("panierDto", new PanierDto());

            //intervales en minutes du temps d'inactivit� avant deconnection
            final String intervaleMinutes = GetPropertyValues.getPropertiesMap().get("tempsAvantDeconnection");

            //ajout d'un intervale maximum autoris� avant deconection automatique
            if (NumberUtils.validate(intervaleMinutes)) {
                session.setMaxInactiveInterval(Integer.valueOf(intervaleMinutes) * 60);
            } else {
                session.setMaxInactiveInterval(intervaleParDefault * 60);
            }

            modelAndView.getModelMap().addAttribute("anySuccess", anySuccess);

            //Redirection vers page d'accueil
            modelAndView.setViewName("redirect:/listerProduits.do");
        }
        return modelAndView;
    }

    /**
     * Permet de se rendre sur connecter avec un nouvelle utilisateur
     *
     * @return ModelAndView la vue et le mod�le utiliser par celui ci
     */
    private ModelAndView voirConnecter() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("connecter");
        modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de d�truire la session et donc de se d�connecter de l'application
     *
     * @param  request       la requ�te HTTP
     * @param  sessionStatus la session
     * @return               ModelAndView se rend sur la vue utiliser comme accueil
     */
    private ModelAndView logout(final HttpServletRequest request, final SessionStatus sessionStatus,
            final @ModelAttribute("deletionSuccess") String code, final RedirectAttributes redirectAttributes) {
        final HttpSession session = request.getSession();
        //Si la session n'est pas null, on y met fin
        if (session != null) {
            sessionStatus.setComplete();
            session.invalidate();
        }
        //Si message pr�sent, on le stocke en FlashAttribute de RedirectAttributes 
        if (!code.isBlank()) {
            redirectAttributes.addFlashAttribute("anySuccess", code);
        }
        return new ModelAndView("redirect:/listerProduits.do");
    }
}
