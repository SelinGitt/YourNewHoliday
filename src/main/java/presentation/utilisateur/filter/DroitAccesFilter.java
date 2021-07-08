/**
 * 
 */
package presentation.utilisateur.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentation.startup.StartupApp;
import presentation.utilisateur.dto.UtilisateurConnecteDto;

/**
 * Classe DroitAccesFilter
 *
 * @author Valentin
 */
@WebFilter(filterName = "DroitAccesFilter", urlPatterns = "*.do")
public class DroitAccesFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse resp, final FilterChain chain)
            throws IOException, ServletException {
        final var request = (HttpServletRequest) req;

        final var uri = request.getRequestURI().split("/")[2];

        // On ne veux pas filtrer la page 404.do
        if ("404.do".equals(uri)) {
            chain.doFilter(req, resp);
            return;
        }

        final var response = (HttpServletResponse) resp;
        final var listRole = StartupApp.DROITS.get(uri);

        // Si listRole null redirection, le lien n'existe pas donc 404
        if (listRole == null) {
            response.sendRedirect(request.getContextPath() + "/404.do");
            return;
        }

        final var user = (UtilisateurConnecteDto) request.getSession().getAttribute("utilisateur");

        // Si user null = visiteur; sinon check rang
        if (user == null) {
            if (listRole.contains("Visiteur")) {
                chain.doFilter(req, resp);
                return;
            }
        } else {
            if (listRole.contains(user.getRole().getLibelle())) {
                chain.doFilter(req, resp);
                return;
            }
        }

        response.sendRedirect(request.getContextPath() + "/404.do");
    }

}
