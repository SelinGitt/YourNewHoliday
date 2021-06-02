package presentation.utilisateur.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.utilisateur.IUtilisateurService;

/**
 * Controller pour liste les utilisateurs
 *
 * @author Valentin
 */
@Controller
@RequestMapping("/listerUtilisateur.do")
public class ListerUtilisateurController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    /**
     * Permet de récuperer la liste des utilisateurs et d'afficher la jsp
     *
     * @param  request HttpServletRequest
     * @return         Nom de la jsp a charger
     */
    @GetMapping
    public String listerUtilisateurs(final HttpServletRequest request) {
        request.setAttribute("listeUtilisateur", this.iUtilisateurService.findAllUtilisateurs());

        return "listerUtilisateur";
    }
}
