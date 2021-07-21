/**
 * 
 */
package presentation.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.produit.IProduitService;

/**
 * Classe représentant le controller pour consulter un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/consulterProduit.do")
public class ConsulterProduitController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requête de type GET
     * 
     * @param  idProduit du produit à consulter
     * @param  location  page d'origine
     * @param  param     le potentiel paramètre à récupérer
     * @return           le produit à consulter dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit,
            final @RequestParam(value = "from") String location, final @RequestParam(value = "paramValue", required = false) String param) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");
        modelAndView.getModelMap().addAttribute("consulterProduitDto", iProduitService.trouverProduitEnVente(idProduit));
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
