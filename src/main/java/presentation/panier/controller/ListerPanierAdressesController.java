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
        modelAndView.setViewName("listerPanierAdresses");

        //on cherche l'utilisateur Connecter grace a l'id
        final var id = Integer.valueOf(utilisateurDto.getIdUtilisateur());
        final var utilisateur = utilisateurService.findUtilisateurById(id);
        final var adresse = new CommandeAdresseDto();

        //on recupere les informations de l'utilisateur utile pour commande
        adresse.setAdresse(utilisateur.getAdresse());
        adresse.setNom(utilisateur.getNom());
        adresse.setPrenom(utilisateur.getPrenom());

        //la livraison et la facturation
        modelAndView.getModelMap().addAttribute("CommandeAdresseLivraison", adresse);
        modelAndView.getModelMap().addAttribute("CommandeAdresseFacturation", adresse);
        return modelAndView;
    }

}
