package presentation.controller.temp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * L'utilisateur en session
	 */
	public static final String UTILISATEUR = "utilisateur";

	/**
	 * Permet de mettre en session un utilisateur client, un admin ou de le supprimer pour vos test
	 *
	 * @param  request Requête actuelle
	 * @return         Le ModelAndView de la méthode
	 */
	@GetMapping
	public String choixAction(final HttpSession session, final HttpServletRequest request) {
		final String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("create_client")) {
				session.setAttribute(UTILISATEUR, this.creerUtilisateurClient());
			}
			if (action.equals("create_admin")) {
				session.setAttribute(UTILISATEUR, this.creerUtilisateurAdmin());
			}
			if (action.equals("supprimer")) {
				session.removeAttribute(UTILISATEUR);
			}
		}
		return "user_session";
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