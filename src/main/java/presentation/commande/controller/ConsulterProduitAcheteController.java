/**
 * 
 */
package presentation.commande.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.produit.IProduitService;

/**
 * Class represents XX
 *
 * @author Steve
 */
@Controller
@RequestMapping(value = "/consulterProduitAchete.do")
public class ConsulterProduitAcheteController {
    @Autowired
    private IProduitService iCommandeService;

    /**
     * Permet de traiter une requête de type GET
     * 
     * @param  idProduit du produit à consulter
     * @param  user      pour recuperer le role de l'utilisateur en session
     * @param  location  page d'origine
     * @param  param     le potentiel paramètre à récupérer
     * @return           le produit à consulter dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit,
            final @RequestParam(value = "from", required = false) String location,
            final @RequestParam(value = "paramValue", required = false) String param,
            final @SessionAttribute(value = "utilisateur", required = false) UtilisateurConnecteDto user) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduitAchete");

        final var produitTrouve = iCommandeService.trouverProduitEnVente(idProduit);

        if (produitTrouve == null) {
            return new ModelAndView("redirect:404.do");
        }

        modelAndView.getModelMap().addAttribute("consulterProduitAcheteDto", produitTrouve);

        return modelAndView;

    }

}
