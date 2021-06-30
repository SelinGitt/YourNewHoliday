/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller de la vue USR00 pour consulter un profil Utilisateur
 *
 * @author Damien D.
 */
@Controller
@RequestMapping("/consulterUtilisateur.do")
public class ConsulterUtilisateurController {

    //    private static final Logger logger = LoggerFactory.getLogger(ConsulterUtilisateurController.class);

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet de traiter les requêtes en GET affiche la page de consultation de profil Utilisateur
     * 
     * @param  request            : la requête HTTP
     * @param  session            : la session en cours
     * @param  redirectAttributes : attributs de redirection
     * @return                    un modelAndView
     */
    @GetMapping
    public ModelAndView consulterUtilisateur(final HttpServletRequest request, final HttpSession session,
            final RedirectAttributes redirectAttributes) {
        final UtilisateurConnecteDto utilisateurConnecte = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        final var utilisateurDto = recupererUtilisateurDto(utilisateurConnecte);
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterUtilisateur");
        modelAndView.getModelMap().addAttribute("utilisateurDto", utilisateurDto);
        return modelAndView;
    }

    private UtilisateurDto recupererUtilisateurDto(final UtilisateurConnecteDto utilisateurConnecteDto) {
        final var id = Integer.valueOf(utilisateurConnecteDto.getIdUtilisateur());
        return iUtilisateurService.findUtilisateurById(id);
    }
}
