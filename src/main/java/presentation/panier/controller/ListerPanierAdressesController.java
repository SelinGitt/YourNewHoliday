/**
 * 
 */
package presentation.panier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.commande.dto.AdressesDto;
import presentation.commande.dto.CommandeAdresseDto;
import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.utilisateur.IUtilisateurService;

/**
 * Classe représentant le controller de listerPanierAdresses
 *
 * @author Alexandre
 */
@Controller
@RequestMapping("/listerPanierAdresses.do")
public class ListerPanierAdressesController {

    @Autowired
    private IUtilisateurService utilisateurService;

    /**
     * Permet d'afficher la JSP listerPanierAdresses et de recuperer les infos d'un utilisateur grace a son id
     * 
     * @param  utilisateurDto : l'utilisateur en session
     * @return                : un modelAndView
     */
    @GetMapping
    public ModelAndView listerAdresses(final @SessionAttribute("utilisateur") UtilisateurConnecteDto utilisateurDto) {
        final var modelAndView = new ModelAndView();

        //on cherche l'utilisateur Connecter grace a l'id
        final var id = Integer.valueOf(utilisateurDto.getIdUtilisateur());
        final var utilisateur = utilisateurService.findUtilisateurById(id);
        if (utilisateur == null) {
            modelAndView.setViewName("redirect:deconnecter.do");
            return modelAndView;
        }
        final var defaultAdresse = new CommandeAdresseDto();
        final var livraisonAdresse = new CommandeAdresseDto();
        final var facturationAdresse = new CommandeAdresseDto();

        //on recupere les informations de l'utilisateur utile pour commande
        defaultAdresse.setAdresse(utilisateur.getAdresse());
        defaultAdresse.setNom(utilisateur.getNom());
        defaultAdresse.setPrenom(utilisateur.getPrenom());

        livraisonAdresse.setAdresse(defaultAdresse.getAdresse());
        livraisonAdresse.setNom(defaultAdresse.getNom());
        livraisonAdresse.setPrenom(defaultAdresse.getPrenom());

        facturationAdresse.setAdresse(defaultAdresse.getAdresse());
        facturationAdresse.setNom(defaultAdresse.getNom());
        facturationAdresse.setPrenom(defaultAdresse.getPrenom());

        final var adresses = new AdressesDto();
        adresses.setDefaultAdresse(defaultAdresse);
        adresses.setCommandeAdresseLivraison(livraisonAdresse);
        adresses.setCommandeAdresseFacturation(facturationAdresse);

        //la livraison et la facturation
        modelAndView.getModelMap().addAttribute("adresses", adresses);
        return modelAndView;
    }

}
