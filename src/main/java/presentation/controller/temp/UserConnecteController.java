package presentation.controller.temp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Controller temporaire pour mettre des données utilisateur en session
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
     * Permet de mettre en session un utilisateur pour vos test
     *
     * @param  session Session actuelle
     * @return         Nom de la jsp a charger
     */
    @GetMapping("/create")
    public String mettreUserEnSession(final HttpSession session) {
        session.setAttribute("utilisateur", this.creerUtilisateur());
        return "user_session";
    }
    
    /**
     * Supprimer l'utilisateur en session
     *
     * @param session Session actuelle
     * @return Nom de la jsp
     */
    @GetMapping("/supprimer")
    public String supprimerUser(final HttpSession session) {
        session.invalidate();
        return "user_session";
    }

    /**
     * Methode pour créer un {@link presentation.utilisateur.dto.UtilisateurConnecteDto}
     *
     * @return UtilisateurConnecteDto créer
     */
    private UtilisateurConnecteDto creerUtilisateur() {
        final var utilisateurConnecteDto = new UtilisateurConnecteDto();

        utilisateurConnecteDto.setIdRole("1");
        utilisateurConnecteDto.setIdUtilisateur("25");
        utilisateurConnecteDto.setNbProduitPanier("3");
        utilisateurConnecteDto.setNom("Dupont");
        utilisateurConnecteDto.setPrenom("Marc");

        return utilisateurConnecteDto;
    }

}
