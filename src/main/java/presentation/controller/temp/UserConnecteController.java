package presentation.controller.temp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Controller temporaire pour mettre des données utilisateur en session <br>
 * A supprimer dès que la page connexion est dispo !
 *
 * @author Valentin/NathanR
 */
@Controller
@RequestMapping("/user_session.do")
public class UserConnecteController {

	/**
	 * Permet de mettre en session un utilisateur client, un admin ou de le supprimer pour vos test
	 *
	 * @param  request Requête actuelle
	 * @return Le ModelAndView de la méthode
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView choixAction(final HttpServletRequest request) {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user_session");
		final String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("create_client")) {
				modelAndView.getModelMap().addAttribute("utilisateur", this.creerUtilisateurClient());
			}
			if (action.equals("create_admin")) {
				modelAndView.getModelMap().addAttribute("utilisateur", this.creerUtilisateurAdmin());
			}
			if (action.equals("supprimer")) {
				modelAndView.getModelMap().remove("utilisateur");
			}
		}
		return modelAndView;
	}

	/**
	 * Methode pour créer un {@link presentation.utilisateur.dto.UtilisateurConnecteDto} Client
	 *
	 * @return UtilisateurConnecteDto créer
	 */
	private UtilisateurConnecteDto creerUtilisateurClient() {
		final var utilisateurConnecteDto = new UtilisateurConnecteDto();

		utilisateurConnecteDto.setIdRole("1");
		utilisateurConnecteDto.setNomRole("Client");
		utilisateurConnecteDto.setIdUtilisateur("3");
		utilisateurConnecteDto.setNbProduitPanier("3");
		utilisateurConnecteDto.setNom("Lanister");
		utilisateurConnecteDto.setPrenom("Cercey");

		return utilisateurConnecteDto;
	}

	/**
	 * Methode pour créer un {@link presentation.utilisateur.dto.UtilisateurConnecteDto} Administrateur
	 *
	 * @return UtilisateurConnecteDto créer
	 */
	private UtilisateurConnecteDto creerUtilisateurAdmin() {
		final var utilisateurConnecteDto = new UtilisateurConnecteDto();

		utilisateurConnecteDto.setIdRole("3");
		utilisateurConnecteDto.setNomRole("Administrateur");
		utilisateurConnecteDto.setIdUtilisateur("7");
		utilisateurConnecteDto.setNbProduitPanier("0");
		utilisateurConnecteDto.setNom("Marly");
		utilisateurConnecteDto.setPrenom("Cyntia");

		return utilisateurConnecteDto;
	}

}
