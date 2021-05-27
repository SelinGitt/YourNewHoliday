/**
 * 
 */
package presentation.template.header;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller pour l'affichage du header
 *
 * @author NathanR
 */
@Controller
@RequestMapping(value = "/header.do")
public class HeaderController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView afficherHeader() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("header");
        final File logo = new File("WebContent/img/template/header/logoYNH.png");
        modelAndView.getModelMap().addAttribute("logo", logo);
        //        modelAndView.getModelMap().addAttribute("utilisateurConnecteDTO", new utilisateurConnecteDTO());
        return modelAndView;
    }
}
