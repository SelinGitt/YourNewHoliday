/**
 * 
 */
package presentation.produit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.produit.IProduitService;
import service.utilisateur.util.UtilisateurRoleEnum;

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
     * @param  session   pour recuperer le role de l'utilisateur en session
     * @param  location  page d'origine
     * @param  param     le potentiel paramètre à récupérer
     * @return           le produit à consulter dans le model et la vue associée
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit, final HttpSession session,
            final @RequestParam(value = "from") String location, final @RequestParam(value = "paramValue", required = false) String param) {
        final var user = (UtilisateurConnecteDto) session.getAttribute("utilisateur");
        final var modelAndView = new ModelAndView();
        int id = UtilisateurRoleEnum.VISITEUR.getId();
        modelAndView.setViewName("consulterProduit");

        if (user != null) {
            id = user.getRole().getId();
        }
        switch (id) {
            case 1:
            case 2:
                if (iProduitService.trouverProduitEnVente(idProduit) != null) {
                    extracted(idProduit, modelAndView, id);
                    return modelAndView;
                }
                return new ModelAndView("redirect:/404.do");
            case 3:
                if (iProduitService.trouverProduitById(idProduit) != null) {
                    extracted(idProduit, modelAndView, id);
                    return modelAndView;
                }
                return new ModelAndView("redirect:/404.do");
            default:
                break;
        }

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

    /**
     * Permet d'ajouter un attribut au model and view
     *
     * @param idProduit    id du produit à consulter
     * @param modelAndView model et vue associée
     * @param id           id du role utilisateur
     */
    public void extracted(final Integer idProduit, final ModelAndView modelAndView, final int id) {
        modelAndView.getModelMap().addAttribute("consulterProduitDto", iProduitService.choixConsulterProduit(id, idProduit));
    }

}
