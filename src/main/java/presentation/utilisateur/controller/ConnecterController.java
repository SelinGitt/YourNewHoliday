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
@RequestMapping({"/connecter.do", "/deconnecter.do"})
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
	 * @param  request
	 * @param  sessionStatus
	 * @return               : un model pour le binding et la vue associée
	 */
	@GetMapping
	public ModelAndView choixDesUrl(final HttpServletRequest request, final SessionStatus sessionStatus) {
		if (request.getRequestURI().contains("/deconnecter.do")) {
			return logout(request, sessionStatus);
		}
		return voirConnecter();

	}

	/**
	 * Permet de mettre logger un utilisateur en session
	 *
	 * @param  utilisateurDto : le {@link UtilisateurDto} à logger
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

	private ModelAndView voirConnecter() {
		final var modelAndView = new ModelAndView();
		modelAndView.setViewName("connecter");
		modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
		return modelAndView;
	}

	private ModelAndView logout(final HttpServletRequest request, final SessionStatus sessionStatus) {
		final HttpSession session = request.getSession();
		if (session != null) {
			sessionStatus.setComplete();
			session.invalidate();
		}
		final var modelAndView = new ModelAndView("redirect:/listerProduits.do");
		return modelAndView;
	}
}
