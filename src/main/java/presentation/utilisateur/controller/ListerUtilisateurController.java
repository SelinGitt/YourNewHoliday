package presentation.utilisateur.controller;

import java.util.ArrayList;
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
     * @param  searchType   Le type de recherche, filtre, ou recherche avec input
     * @param  searchInput  La valeur de la recherche
     * @param  searchFilter La valeur du filtre applique
     * @return              ModelAndView avec le nom de la jsp et la liste des utilisateurs trie en attribut
     */
    @PostMapping
    public ModelAndView recherche(final @RequestParam(value = "searchType") String searchType,
            final @RequestParam(value = "searchInput") String searchInput,
            final @RequestParam(value = "searchFilter") String searchFilter) {
        final var modelAndView = new ModelAndView("listerUtilisateur");

        modelAndView.getModelMap().addAttribute("searchTerm", searchInput);
        modelAndView.getModelMap().addAttribute("searchFilter", searchFilter);

        List<UtilisateurDto> listUtilisateur = new ArrayList<>();

        // Si on effectue une recherche par nom et par filtre
        if (!searchInput.isEmpty() && !searchFilter.isEmpty()) {
            listUtilisateur = this.rechercheNomFiltre(searchInput, searchFilter);
        } else {
            // Si on effectue une recherche par nom ou si on selectionne filter a tous et que la recherche par nom n'est pas vide
            if ("search".equals(searchType) || ("filter".equals(searchType) && searchFilter.isEmpty())) {
                listUtilisateur = this.rechercheInput(searchInput);
            }

            // Si on effectue une recherche par filtre et que la recherche par nom est vide sinon ecrase la liste
            if ("filter".equals(searchType) && searchInput.isBlank()) {
                listUtilisateur = this.rechercheFiltre(searchFilter);
            }
        }

        modelAndView.getModelMap().addAttribute("listeUtilisateur", listUtilisateur);

        return modelAndView;
    }

    /**
     * Permet de rechercher un utilisateur avec son nom
     *
     * @param  searchInput Le nom a rechercher
     * @return             List d'UtilisateurDto
     */
    private List<UtilisateurDto> rechercheInput(final String searchInput) {
        return this.iUtilisateurService.rechercherUtilisateur(searchInput);
    }

    /**
     * Permet de recherche des utilisateurs avec leur role
     *
     * @param  searchFilter Filtre role a appliquer
     * @return              List d'UtilisateurDto
     */
    private List<UtilisateurDto> rechercheFiltre(final String searchFilter) {
        if (searchFilter.isBlank()) {
            return this.iUtilisateurService.findAllUtilisateurs();
        }
        return this.iUtilisateurService.rechercherUtilisateurRole(searchFilter);
    }

    /**
     * Permet de rechercher des utilisateurs selon nom et role
     *
     * @param  searchInput  Le nom a rechercher
     * @param  searchFilter Filtre role a appliquer
     * @return              List d'UtilisateurDto
     */
    private List<UtilisateurDto> rechercheNomFiltre(final String searchInput, final String searchFilter) {
        return this.iUtilisateurService.rechercherUtilisateurNomRole(searchInput, searchFilter);
    }
}
