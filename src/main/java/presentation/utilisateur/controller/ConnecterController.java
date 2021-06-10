/**
 * 
 */
package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
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
@SessionAttributes("utilisateur")
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
     * @return                ModelAndView and l'utilisateur en session et le nom de la jsp
     */
    @PostMapping
    public ModelAndView loggerUtilisateur(final UtilisateurDto utilisateurDto) {

        final var modelAndView = new ModelAndView();

        modelAndView.getModelMap().addAttribute(UTILISATEUR,
                iUtilisateurService.authentify(utilisateurDto.getEmail(), utilisateurDto.getPassword()));

        modelAndView.setViewName("connecter");

        return modelAndView;
    }
    
    /**
     * Permet de retirer l'utilisateur en session 
     *  
     * @param request la requ�te 
     * @param sessionStatus le sessionStatus
     * @return un redirect ver listerProduits.do
     */
    @GetMapping(value = "/logout")
    public String logout(final HttpServletRequest request, final SessionStatus sessionStatus) {
		final HttpSession session = request.getSession();
		if (session != null) {
			sessionStatus.setComplete();
			session.invalidate();
		}
		return "redirect:/listerProduits.do";
    }
}
