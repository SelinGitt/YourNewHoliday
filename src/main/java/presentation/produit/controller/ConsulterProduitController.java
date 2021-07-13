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
 * Classe repr�sentant le controller pour consulter un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/consulterProduit.do")
public class ConsulterProduitController {

    @Autowired
    private IProduitService iProduitService;

    /**
     * Permet de traiter une requ�te de type GET
     * 
     * @param  idProduit du produit � consulter
     * @param  location  page d'origine
     * @param  param     le potentiel param�tre � r�cup�rer
     * @return           le produit � consulter dans le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit,
            final @RequestParam(value = "location", required = false) String location,
            final @RequestParam(value = "paramValue", required = false, defaultValue = "") String param) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");
        modelAndView.getModelMap().addAttribute("consulterProduitDto", iProduitService.trouverProduitEnVente(idProduit));
        selectReturnPage(PageOrigine.findValue(location), param, modelAndView);
        return modelAndView;

    }

    /**
     * Permet de trouver la page de retour en fonction de sa location et de ses param�tres
     *
     * @param pageOrigine  page d'origine
     * @param param        param�tre de requ�te sauvegard� pour le retour
     * @param modelAndView le modelAndView pour enregistrer les attributs
     */
    private void selectReturnPage(final PageOrigine pageOrigine, final String param, final ModelAndView modelAndView) {
        modelAndView.getModelMap().addAttribute("redirection", pageOrigine.getPageConcrete());
        if (PageOrigine.DETAIL_COMMANDE == pageOrigine) {
            modelAndView.getModelMap().addAttribute("typeParam", "ref");
            modelAndView.getModelMap().addAttribute("value", param);
        }
    }
}
