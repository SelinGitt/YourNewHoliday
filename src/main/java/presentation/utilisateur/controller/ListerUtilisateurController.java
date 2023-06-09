package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
     * Permet de recuperer la liste des utilisateurs et d'afficher la jsp
     *
     * @return ModelAndView avec le nom de la jsp et la liste des utilisateurs en attribut
     */
    @GetMapping
    public ModelAndView listerUtilisateurs() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("listerUtilisateur");
        modelAndView.getModelMap().addAttribute("listeUtilisateur", this.iUtilisateurService.findAllUtilisateurs());
        // Permet d'eviter une erreur js sur le premier chargement de la page
        modelAndView.getModelMap().addAttribute("searchFilter", 0);
        return modelAndView;
    }

    /**
     * Permet d'effectuee une recherche
     * 
     * @param  searchInput  La valeur de la recherche
     * @param  searchFilter La valeur du filtre applique
     * @return              ModelAndView avec le nom de la jsp et la liste des utilisateurs trie en attribut
     */
    @PostMapping
    public ModelAndView recherche(final @RequestParam(value = "searchInput") String searchInput,
            final @RequestParam(value = "searchFilter") String searchFilter) {

        final var modelAndView = new ModelAndView("listerUtilisateur");

        modelAndView.getModelMap().addAttribute("searchTerm", searchInput);
        modelAndView.getModelMap().addAttribute("searchFilter", searchFilter);

        // Il ne sera jamais null car on l'initialise dans la methode listeUtilisateur
        final var idRole = Integer.parseInt(searchFilter);

        modelAndView.getModelMap().addAttribute("listeUtilisateur", this.iUtilisateurService.rechercherUtilisateur(searchInput, idRole));

        return modelAndView;
    }
}
