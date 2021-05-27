package presentation.controller.temp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Controller temporaire pour mettre des données utilisateur en session <br>
 * A supprimer dès que la page connexion est dispo !
 *
 * @author Valentin
 */
@Controller
@RequestMapping("/user_session.do")
public class UserConnecteController {

    /**
     * Affiche la jsp
     *
     * @return nom de la jsp
     */
    @GetMapping
    public String voirJsp() {
        return "user_session";
    }

    /**
     * Permet de mettre en session un utilisateur client pour vos test
     *
     * @param  session Session actuelle
     * @return         Nom de la jsp a charger
     */
    @GetMapping("/create_client")
    public String mettreUserClientEnSession(final HttpSession session) {
        session.setAttribute("utilisateur", this.creerUtilisateurClient());
        return "user_session";
    }

    /**
     * Permet de mettre en session un utilisateur administrateur pour vos test
     *
     * @param  session Session actuelle
     * @return         Nom de la jsp a charger
     */
    @GetMapping("/create_admin")
    public String mettreUserAdminEnSession(final HttpSession session) {
        session.setAttribute("utilisateur", this.creerUtilisateurAdmin());
        return "user_session";
    }

    /**
     * Supprimer l'utilisateur en session
     *
     * @param  session Session actuelle
     * @return         Nom de la jsp
     */
    @GetMapping("/supprimer")
    public String supprimerUser(final HttpSession session) {
        session.removeAttribute("utilisateur");
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
        utilisateurConnecteDto.setIdUtilisateur("25");
        utilisateurConnecteDto.setNbProduitPanier("3");
        utilisateurConnecteDto.setNom("Dupont");
        utilisateurConnecteDto.setPrenom("Marc");

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
        utilisateurConnecteDto.setIdUtilisateur("74");
        utilisateurConnecteDto.setNbProduitPanier("0");
        utilisateurConnecteDto.setNom("Bartide");
        utilisateurConnecteDto.setPrenom("Eric");

        return utilisateurConnecteDto;
    }

}
