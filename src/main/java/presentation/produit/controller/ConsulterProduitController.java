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
 * Classe repr�sentant le controller pour consulter un produit
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
            final @RequestParam(value = "from") String location, final @RequestParam(value = "paramValue", required = false) String param,
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
        //cr�ation d'une arrayList de Integer
        final List<String> liste = new ArrayList<>();
        //set de l'exposant � 1
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
