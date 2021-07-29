/**
 * 
 */
package presentation.commande.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
     * Permet de traiter une requête de type GET
     * 
     * @param  idProduit id produit
     * @param  version   du produit
     * @param  location  page d'origine
     * @param  param     le potentiel paramètre à récupérer
     * @return           le produit à consulter dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView consulterProduitAchete(final @RequestParam(value = "idProduit") String idProduit,
            final @RequestParam(value = "version") String version, final @RequestParam(value = "paramValue") String param) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");
        final var produitAchete = iCommandeService.findProduitAchete(idProduit, version);
        if (produitAchete == null) {
            return new ModelAndView("redirect:404.do");
        }
        modelAndView.getModelMap().addAttribute("consulterProduitDto", produitAchete);
        final var urlRetour = new String("detailCommande.do?ref=" + param);
        modelAndView.getModelMap().addAttribute("retour", urlRetour);
        modelAndView.getModelMap().addAttribute("isAchetable", false);
        return modelAndView;
    }

}
