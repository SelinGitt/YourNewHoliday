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
import service.commande.ICommandeService;

/**
 * Class represents XX
 *
 * @author Steve
 */
@Controller
@RequestMapping(value = "/consulterProduitAchete.do")
public class ConsulterProduitAcheteController {
    @Autowired
    private ICommandeService iCommandeService;

    /**
     * Permet de traiter une requ�te de type GET
     * 
     * @param  idProduit id produit
     * @param  version   du produit
     * @param  user      pour recuperer le role de l'utilisateur en session
     * @param  location  page d'origine
     * @param  param     le potentiel param�tre � r�cup�rer
     * @return           le produit � consulter dans le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView consulterProduitAchete(final @RequestParam(value = "idProduit") String idProduit,
            final @RequestParam(value = "version") String version, final @RequestParam(value = "from", required = false) String location,
            final @RequestParam(value = "paramValue", required = false) String param,
            final @SessionAttribute(value = "utilisateur", required = false) UtilisateurConnecteDto user) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");
        final var produitAchete = iCommandeService.findProduitAchete(idProduit, version);
        if (produitAchete == null) {
            return new ModelAndView("redirect:404.do");
        }
        modelAndView.getModelMap().addAttribute("consulterProduitDto", produitAchete);
        final var pageOrigine = PageRedirection.findValue(location);
        final var urlToBuild = new StringBuilder();
        urlToBuild.append(pageOrigine.getPageConcrete());
        if (PageRedirection.DETAIL_COMMANDE == pageOrigine) {
            urlToBuild.append("?ref=" + param);
        }
        modelAndView.getModelMap().addAttribute("retour", urlToBuild);
        modelAndView.getModelMap().addAttribute("achetable", false);
        return modelAndView;
    }

}
