/**
 * 
 */
package presentation.utilisateur.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.RoleDto;
import presentation.utilisateur.dto.UtilisateurDto;
import service.utilisateur.IUtilisateurService;

/**
 * Controller pour création d'un utilisateur
 *
 * @author Selin
 */
@Controller
@RequestMapping("/creerUtilisateur.do")
public class CreerUtilisateurController {

    private static final Logger logger = LoggerFactory.getLogger(CreerUtilisateurController.class);

    @Autowired
    private IUtilisateurService service;

    /**
     * Permet de traiter les requêtes GET<br/>
     * et de mettre un UtilisateurDto vide dans le modèle
     * 
     * @return le Model and View
     */
    @GetMapping
    public ModelAndView afficher() {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("creerUtilisateur");
        modelAndView.getModelMap().addAttribute("utilisateurDto", new UtilisateurDto());
        return modelAndView;
    }

    /**
     * Permet de traiter les requêtes POST<br/>
     * et de créer un utilisateur
     *
     * @param  utilisateurDto l'utilisateur à créer
     * @return                lien vers la jsp
     */
    @PostMapping
    public ModelAndView processSubmit(final UtilisateurDto utilisateurDto) {
        final var roleDto = new RoleDto();
        roleDto.setIdRole(1);

        utilisateurDto.setRole(roleDto);

        utilisateurDto.setDateInscription(Date.from(Instant.now()).toString());

        utilisateurDto.setEstActif(true);

        // TODO : Temporaire avec le generateReference
        try {
            utilisateurDto.setReference(this.generateReference());
        } catch (final NoSuchAlgorithmException exception) {
            logger.warn(exception.getMessage(), exception);
        }

        this.service.createUtilisateur(utilisateurDto);

        return new ModelAndView("redirect:/");
    }

    /**
     * Permet de generer une reference <br>
     * Ceci est temporaire
     *
     * @return                          Reference creer
     * @throws NoSuchAlgorithmException
     */
    private String generateReference() throws NoSuchAlgorithmException {
        // create a string of all characters
        final var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        final var sb = new StringBuilder();

        // create an object of Random class
        final var random = SecureRandom.getInstanceStrong();

        for (var i = 0; i < 7; i++) {

            // generate random index number
            final var index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            final var randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
