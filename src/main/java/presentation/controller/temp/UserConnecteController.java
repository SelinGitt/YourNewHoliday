package presentation.controller.temp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Controller temporaire pour mettre des donn�es utilisateur en session <br>
 * A supprimer d�s que la page connexion est dispo !
 *
 * @author Valentin/NathanR
 */
@Controller
@RequestMapping("/user_session.do")
public class UserConnecteController {

	/**
	 * Permet de mettre en session un utilisateur client, un admin ou de le supprimer pour vos test
	 *
	 * @param  request Requ�te actuelle
	 * @return Le ModelAndView de la m�thode
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
	 * Methode pour cr�er un {@link presentation.utilisateur.dto.UtilisateurConnecteDto} Client
	 *
	 * @return UtilisateurConnecteDto cr�er
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
	 * Methode pour cr�er un {@link presentation.utilisateur.dto.UtilisateurConnecteDto} Administrateur
	 *
	 * @return UtilisateurConnecteDto cr�er
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
