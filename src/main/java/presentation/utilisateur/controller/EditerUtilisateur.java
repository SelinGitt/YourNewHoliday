/**
 * 
 */
package presentation.utilisateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import presentation.utilisateur.dto.UtilisateurDto;
import presentation.utilisateur.validator.EditerUtilisateurValidator;
import service.utilisateur.IUtilisateurService;

/**
 * Classe EditerUtilisateur
 *
 * @author Valentin
 */
@Controller
@RequestMapping("/modifierUtilisateur.do")
public class EditerUtilisateur {

    @Autowired
    private IUtilisateurService        iUtilisateurService;

    @Autowired
    private EditerUtilisateurValidator editerUtilisateurValidator;

    /**
     * Permet de recuperer l'utilisateur et d'afficher la jsp
     * 
     * @param  reference Reference a rechercher
     * @param  origin    String la page d'origine (1 pour USR00, 2 pour USR01)
     * @return           ModelAndView avec le nom de la jsp et l'utilisateur en attribut
     */
    @GetMapping
    public ModelAndView modifierUtilisateur(@RequestParam(value = "ref", defaultValue = "") final String reference,
            @RequestParam("origin") final String origin) {

        final var utilisateurDto = this.iUtilisateurService.rechercherReference(reference);

        if (utilisateurDto == null) {
            // Redirection temporaire, il faut par la suite verifier le rang de l'utilisateur connecte
            return new ModelAndView("redirect:/listerUtilisateur.do");
        }

        final var modelAndView = new ModelAndView("modifierUtilisateur");
        //On met la page d'origine en attribut
        modelAndView.getModelMap().addAttribute("origin", origin);
        modelAndView.getModelMap().addAttribute("utilisateurDto", utilisateurDto);

        return modelAndView;
    }

    /**
     * Permet de traiter les requ�tes POST<br>
     * et de mettre a jour un utilisateur
     * 
     * @param  origin         String la page d'origine (1 pour USR00, 2 pour USR01)
     * @param  utilisateurDto l'utilisateur � mettre a jour
     * @param  result         Resultats du binding utilis� pour g�rer les erreurs
     * @param  attribute      Permet de transmettre a travers la redirection
     * @return                redirection vers usr01 ou usr00 en fonction de la page d'origine
     */
    @PostMapping
    public ModelAndView processSubmit(final UtilisateurDto utilisateurDto, @RequestParam("origin") final String origin,
            final BindingResult result, final RedirectAttributes attribute) {
        editerUtilisateurValidator.validate(utilisateurDto, result);

        //Si le formulaire a des erreurs
        if (result.hasErrors()) {
            final var modelAndView = new ModelAndView("modifierUtilisateur");
            modelAndView.getModelMap().addAttribute("error", "usr02.erreur.edit");
            modelAndView.getModelMap().addAttribute("origin", origin);
            return modelAndView;
        }

        // Si utilisateur == null, l'email est deja pris
        if (this.iUtilisateurService.updateUtilisateur(utilisateurDto) == null) {
            result.rejectValue("email", "usr02.erreur.email_taken", "Default Errror");
            final var modelAndView = new ModelAndView("modifierUtilisateur");
            modelAndView.getModelMap().addAttribute("error", "usr02.erreur.edit");
            modelAndView.getModelMap().addAttribute("origin", origin);
            return modelAndView;
        }

        attribute.addFlashAttribute("userSuccess", "usr02.success.update");

        if ("1".equals(origin)) {
            return new ModelAndView("redirect:/consulterUtilisateur.do");
        }
        return new ModelAndView("redirect:/listerUtilisateur.do");
    }
}
