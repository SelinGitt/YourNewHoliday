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

import presentation.produit.controller.PageRedirection;
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
    public ModelAndView consulterProduitAchete(final @RequestParam(value = "idProduit") Integer idProduit,
            final @RequestParam(value = "from", required = false) String location,
            final @RequestParam(value = "paramValue", required = false) String param,
            final @SessionAttribute(value = "utilisateur", required = false) UtilisateurConnecteDto user) {
        // FIXME : debug
        System.out.println("Controleur");
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduitAchete");
        // on récupère le produit acheté.
        final var produitTrouve = iCommandeService.trouverProduitEnVente(idProduit);
        // FIXME : debug
        System.out.println(produitTrouve);
        if (produitTrouve == null) {
            // FIXME : debug
            System.err.println("produit pas trouvé !!");
            return new ModelAndView("redirect:404.do");
        }
        modelAndView.getModelMap().addAttribute("consulterProduitAcheteDto", produitTrouve);
        final var pageOrigine = PageRedirection.findValue(location);
        final var urlToBuild = new StringBuilder();
        urlToBuild.append(pageOrigine.getPageConcrete());
        if (PageRedirection.DETAIL_COMMANDE == pageOrigine) {
            urlToBuild.append("?ref=" + param);
        }
        modelAndView.getModelMap().addAttribute("retour", urlToBuild);
        return modelAndView;
    }

}
