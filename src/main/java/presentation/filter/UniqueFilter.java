/**
 * 
 */
package presentation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentation.utilisateur.controller.ConnecterController;
import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Classe UniqueFilter
 *
 * @author Valentin
 */
@WebFilter(filterName = "UniqueFilter", urlPatterns = "*.do")
public class UniqueFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse resp, final FilterChain chain)
            throws IOException, ServletException {
        final var request = (HttpServletRequest) req;
        final var response = (HttpServletResponse) resp;

        final var user = (UtilisateurConnecteDto) request.getSession().getAttribute(ConnecterController.UTILISATEUR);
        //        final var modelAndView = new ModelAndView();
        //        final var user = (UtilisateurConnecteDto) modelAndView.getModelMap().getAttribute(ConnecterController.UTILISATEUR);

        final var uri = request.getRequestURI().split("/")[2];
        final var map = StartupApp.DROITS.get(uri);

        // Si map null redirection
        if (map == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        // Si user null = visiteur; sinon check rang
        if (user == null) {
            if (map.contains("visiteur")) {
                chain.doFilter(req, resp);
                return;
            }
        } else
            if (map.contains(user.getNomRole())) {
                chain.doFilter(req, resp);
                return;
            }

        response.sendRedirect(request.getContextPath() + "/");
    }

}
