package presentation.utilisateur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurDto;
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
        return modelAndView;
    }

    /**
     * Permet d'effectuee une recherche
     * 
     * @param  searchType  Le type de recherche, filtre, ou recherche avec input
     * @param  searchInput La valeur de la recherche
     * @return             ModelAndView avec le nom de la jsp et la liste des utilisateurs trie en attribut
     */
    @PostMapping
    public ModelAndView recherche(final @RequestParam(value = "searchType") String searchType,
            final @RequestParam(value = "searchInput") String searchInput) {
        final var modelAndView = new ModelAndView("listerUtilisateur");

        if ("search".equals(searchType)) {
            modelAndView.getModelMap().addAttribute("listeUtilisateur", this.rechercheInput(searchInput));
        }

        return modelAndView;
    }

    private List<UtilisateurDto> rechercheInput(final String searchInput) {
        return null;
    }
}
