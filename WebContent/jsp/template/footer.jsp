<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<hr />
<%-- Permet de récupérer la locale en session --%>
<input id="localeCode" type="hidden"
    value='${sessionScope["org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE"]}' />
<%-- conteneur pour le footer --%>
<div class="footer-container">
    <%-- lien de redirection vers la page contact vide pour l'instant "contact.do" quand le controlleur sera créé --%>
    <div>
        <a href="contact.do"> <span class="text-responsive"><spring:message code="glb.footer.lien.con" /></span>
        </a>
    </div>
    <%-- lien de redirection vers la page mentions légales vide pour l'instant 
         "mentions_legales.do" quand le controlleur sera créé --%>
    <div>
        <a href="mentionsLegales.do"> <span class="text-responsive"><spring:message
                    code="glb.footer.lien.mlg" /></span>
        </a>
    </div>
    <%-- langues --%>
    <div>
        <c:set var="currentURLConstruct" scope="request">
            <c:set var="andParameter" scope="request" value="&" />
            <%-- récupère les paramètres de l'url --%>
            <c:set var="queryString" scope="request" value="${requestScope['javax.servlet.forward.query_string']}" />
            <c:set var="queryStringLength" scope="request" value="${fn:length(queryString)}" />
            <c:set var="indexOfLanguage" scope="request" value="${fn:indexOf(queryString, 'language=')}" />
            <%-- reconstruit les paramètres d'url sans language= --%>
            <%-- lorsque l'on a déjà choisit une langue au moins une fois --%>
            <c:choose>
                <c:when test="${indexOfLanguage ge 0}">
                    <c:set var="queryStringBase" scope="request"
                        value="${fn:substring(queryString, 0, indexOfLanguage)}" />
                </c:when>
                <c:otherwise>
                    <c:set var="queryStringBase" scope="request" value="${queryString}" />
                </c:otherwise>
            </c:choose>
            <c:set var="queryStringBaseLength" scope="request" value="${fn:length(queryStringBase)}" />
            <%-- ce choose est utile à cause du bug de f:endsWith qui ne détecte pas --%>
            <%-- le dernier caractère si celui ci est déjà présent avant --%>
            <c:choose>
                <c:when test="${queryStringBaseLength ge 1}">
                    <c:set var="queryLastChar" scope="request"
                        value="${fn:substring(queryStringBase, queryStringBaseLength-1, queryStringBaseLength)}" />
                </c:when>
                <c:otherwise>
                    <c:set var="queryLastChar" scope="request" value="" />
                </c:otherwise>
            </c:choose>
            <%-- reconstruit les paramètres d'url --%>
            <c:choose>
                <c:when test="${fn:endsWith(queryLastChar, andParameter)}">
                    <c:set var="query" scope="request" value="${queryStringBase}" />
                </c:when>
                <c:when test="${queryStringBaseLength ge 1}">
                    <c:set var="query" scope="request" value="${queryStringBase}${andParameter}" />
                </c:when>
                <c:otherwise>
                    <c:set var="query" scope="request" value="" />
                </c:otherwise>
            </c:choose>
            <%-- construction de l'url --%>
            ${requestScope['javax.servlet.forward.request_uri']}?${query}language=
        </c:set>
        <c:set var="currentURL" scope="request" value="${fn:trim(currentURLConstruct)}" />
        <%-- texte indiquant les drapeaux permettant de changer de langue --%>
        <span class="text-responsive"><spring:message code="glb.footer.texte.langue" /></span>
        <%-- image du drapeau français permettant de basculer le site en français. --%>
        <a id="lienLangueFr" href="${currentURL}fr"><img id="FR-button" class="footer-lang footer-responsive"
            src="img/template/footer/france.svg" alt="drapeau français" /></a>
        <%-- image du drapeau anglais permettant de basculer le site en anglais.--%>
        <a id="lienLangueEn" href="${currentURL}en"><img id="EN-button" class="footer-lang footer-responsive"
            src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" /></a>
    </div>
</div>
<script type="text/javascript" src="js/footer/langues.js"></script>
<script>
	//appelle la function ce trouvant dans global.js 
	//permet de modifier le titre de la page(pour l'internationalisation)
	//et de suprimer les paragraphes contenant les properties avec les titres des pages
	modifierTitre(document);
	selectLG();
</script>