/**
 * 
 */
package presentation.produit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

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
 * Classe représentant le controller pour consulter un produit
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/consulterProduit.do")
public class ConsulterProduitController {
    private static Map<Integer, String> mapServices = new TreeMap<>();
    static {
        mapServices.put(1, "fa fa-glass");
        mapServices.put(2, "fa fa-bath");
        mapServices.put(4, "fa fa-paw");
        mapServices.put(8, "fa fa-gamepad");
        mapServices.put(16, "fa fa-wifi");
        mapServices.put(32, "fa fa-cutlery");
        mapServices.put(64, "fa fa-wheelchair");
        mapServices.put(128, "fa fa-snowflake-o");
        mapServices.put(256, "fa fa-tv");
    }

    @Autowired
    private IProduitService iProduitService;

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
            final @RequestParam(value = "from") String location, final @RequestParam(value = "paramValue", required = false) String param,
            final @SessionAttribute(value = "utilisateur", required = false) UtilisateurConnecteDto user) {
        final var modelAndView = new ModelAndView();
        modelAndView.setViewName("consulterProduit");

        // Pour définir le role: on test le userConnecté (null ou pas), on mappe ensuite soit le role du userConnecté ou visiteur par défaut
        final UtilisateurRoleEnum role = Optional.ofNullable(user).map(type -> UtilisateurRoleEnum.getRole(type.getRole().getLibelle()))
                .orElse(UtilisateurRoleEnum.VISITEUR);

        // Récupération du role de l'utilisateur connecté (visiteur par défaut)
        final var produitTrouve = iProduitService.consulterProduitWithRole(role, idProduit);

        if (produitTrouve == null) {
            return new ModelAndView("redirect:404.do");
        }
        final int services = Integer.parseInt(produitTrouve.getServices());
        modelAndView.getModelMap().addAttribute("listeServices", genererListeServices(services));
        modelAndView.getModelMap().addAttribute("consulterProduitDto", produitTrouve);
        final var pageOrigine = PageRedirection.findValue(location);
        final var urlToBuild = new StringBuilder();
        urlToBuild.append(pageOrigine.getPageConcrete());
        if (PageRedirection.DETAIL_COMMANDE == pageOrigine) {
            urlToBuild.append("?ref=" + param);
        }
        modelAndView.getModelMap().addAttribute("retour", urlToBuild);
        return modelAndView;

    }

    private List<String> genererListeServices(final Integer number) {
        Integer numberToEdit = number;
        //création d'une arrayList de Integer
        final List<String> liste = new ArrayList<>();
        //set de l'exposant à 1
        int exposant = 1;
        while (numberToEdit != 0) {
            if ((numberToEdit & 1) != 0) {
                liste.add(mapServices.get(exposant));
            }
            numberToEdit >>= 1;
            exposant <<= 1;
        }
        return liste;
    }
}
