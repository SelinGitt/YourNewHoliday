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
import service.utilisateur.util.UtilisateurRoleEnum;

/**
 * Classe DroitAccesFilter
 *
 * @author Valentin
 */
@WebFilter(filterName = "DroitAccesFilter", urlPatterns = "*.do")
public class DroitAccesFilter implements Filter {

    private static final String INIT_QUERY      = "?";
    private static final String QUERY_SEPARATOR = "&";
    private static final String LANGUAGE        = "language";
    private static final String URL_LANGUAGE    = "urlLanguage";

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
        final var listRole = StartupApp.getDroits().get(uri);

        // Si listRole null redirection, le lien n'existe pas donc 404
        if (listRole == null) {
            response.sendRedirect(request.getContextPath() + "/404.do");
            return;
        }

        final var user = (UtilisateurConnecteDto) request.getSession().getAttribute("utilisateur");

        // Si user null = visiteur; sinon check rang
        if (user == null) {
            if (listRole.contains(UtilisateurRoleEnum.VISITEUR.getLibelle())) {
                this.constructQueryForLanguage(request);
                chain.doFilter(req, resp);
                return;
            }
        } else {
            if (listRole.contains(user.getRole().getLibelle())) {
                this.constructQueryForLanguage(request);
                chain.doFilter(req, resp);
                return;
            }
        }

        response.sendRedirect(request.getContextPath() + "/404.do");
    }

    private void constructQueryForLanguage(final HttpServletRequest request) {
        final var uri = request.getRequestURI();
        final var queryBase = request.getQueryString();
        if (request.getParameter(LANGUAGE) == null) {
            request.setAttribute(URL_LANGUAGE, this.constructQuery(uri, queryBase));
        } else {
            request.setAttribute(URL_LANGUAGE, this.constructQuery(uri, this.cutQuery(queryBase)));
        }
    }

    private String constructQuery(final String uri, final String query) {
        final var uriStart = uri + INIT_QUERY;
        if (query == null) {
            return uriStart;
        }
        return uriStart + query + QUERY_SEPARATOR;
    }

    private String cutQuery(final String query) {
        final var queryWithoutLanguage = query.substring(0, query.indexOf(LANGUAGE));
        if (queryWithoutLanguage.isEmpty()) {
            return null;
        }
        return queryWithoutLanguage.substring(0, queryWithoutLanguage.length() - 1);
    }

}
