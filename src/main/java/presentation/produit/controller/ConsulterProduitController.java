/**
 * 
 */
package presentation.produit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import presentation.utilisateur.dto.UtilisateurConnecteDto;
import service.produit.IProduitService;
import service.utilisateur.util.UtilisateurRoleEnum;

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
     * @param  user      pour recuperer le role de l'utilisateur en session
     * @param  location  page d'origine
     * @param  param     le potentiel param�tre � r�cup�rer
     * @return           le produit � consulter dans le model et la vue associ�e
     */
    @GetMapping
    public ModelAndView consulterProduit(final @RequestParam(value = "idProduit") Integer idProduit,
            final @RequestParam(value = "from", required = false) String location,
            final @RequestParam(value = "paramValue", required = false) String param,
            final @SessionAttribute(value = "utilisateur", required = false) UtilisateurConnecteDto user) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");

        // Pour d�finir le role: on test le userConnect� (null ou pas), on mappe ensuite soit le role du userConnect� ou visiteur par d�faut
        final UtilisateurRoleEnum role = Optional.ofNullable(user).map(type -> UtilisateurRoleEnum.getRole(type.getRole().getLibelle()))
                .orElse(UtilisateurRoleEnum.VISITEUR);

        // R�cup�ration du role de l'utilisateur connect� (visiteur par d�faut)
        final var produitTrouve = iProduitService.consulterProduitWithRole(role, idProduit);

        if (produitTrouve == null) {
            return new ModelAndView("redirect:404.do");
        }
        modelAndView.getModelMap().addAttribute("consulterProduitDto", produitTrouve);
        final var pageOrigine = PageRedirection.findValue(location);
        final var urlToBuild = new StringBuilder();
        urlToBuild.append(pageOrigine.getPageConcrete());
        if (PageRedirection.DETAIL_COMMANDE == pageOrigine) {
            urlToBuild.append("?ref=" + param);
        }
        modelAndView.getModelMap().addAttribute("retour", urlToBuild);
        modelAndView.getModelMap().addAttribute("achetable", role != UtilisateurRoleEnum.VISITEUR);
        return modelAndView;

    }

}
