<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div>
        <c:if test="${not empty userSuccess}">
            <div class="background-validation-block block-message-commun">
                <span class="fa fa-check"></span> <span class="user01-message"><spring:message
                        code="${userSuccess}" /></span>
            </div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="background-error-block block-message-commun">
                <span class="fa fa-exclamation"></span><span><spring:message code="${error}" /></span>
            </div>
        </c:if>
    </div>

    <h1 id="titreGestion" class="text-align-center">
        <spring:message code="usr01.titre" />
    </h1>
    <div class="user01-searchMenu display-flex">
        <div>
            <form:form action="listerUtilisateur.do" method="POST">
                <input type="hidden" name="searchFilter" value="${searchFilter}" />

                <input value="${searchTerm}" name="searchInput" class="searchBarInside" type="search"
                    placeholder="<spring:message code='usr01.searchbar'/>">

                <input type="submit" value="<spring:message code="usr01.recherche.OK"/>" class="searchBarOk" />
            </form:form>
        </div>

        <div class="user01-filter-bar">
            <form:form action="listerUtilisateur.do" method="POST">
                <input type="hidden" name="searchInput" value="${searchTerm}" />

                <select name="searchFilter" id="filterBar">
                    <%-- Tous --%>
                    <option value="0"><spring:message code="usr01.filter." /></option>
                    <%-- Client // value correspondant au rôle dans la BD --%>
                    <option value="2"><spring:message code="usr01.filter.2" /></option>
                    <%-- Admin // value correspondant au rôle dans la BD --%>
                    <option value="3"><spring:message code="usr01.filter.3" /></option>
                </select>

                <script>
                     document.getElementById("filterBar").options[${searchFilter}-1].selected = true;
                </script>

                <input type="submit" value="<spring:message code="usr01.recherche.OK"/>" class="searchBarOk" />
            </form:form>
        </div>

        <div class="user01AddUser">
            <a href="creerUtilisateur.do">
                <button type="button" class="user01-newUserBouton">
                    <span class="fa fa-plus-square-o" aria-hidden="true"></span>
                    <spring:message code="usr01.creer.nouveau" />
                </button>
            </a>
        </div>
    </div>

    <table class="user01-lister" aria-describedby="titreGestion">
        <thead>
            <tr>
                <th class="user01-colonne"><spring:message code="usr01.th.ref" /></th>

                <th class="user01-colonne"><spring:message code="usr01.th.nom" /></th>

                <th class="user01-colonne"><spring:message code="usr01.th.date" /></th>

                <th class="user01-colonne"><spring:message code="usr01.th.profil" /></th>

                <th class="user01-colonne"><spring:message code="usr01.th.actif" /></th>

                <th class="user01-colonne"><spring:message code="usr01.th.editer" /></th>

                <th class="user01-colonne"><spring:message code="usr01.th.supprimer" /></th>
            </tr>
        </thead>

        <tbody class="user01-body">
            <c:forEach items="${listeUtilisateur}" var="utilisateurDto">
                <tr>
                    <td class="user01-body">${utilisateurDto.reference}</td>

                    <td class="user01-body">${utilisateurDto.nom}/${utilisateurDto.prenom}</td>

                    <td class="user01-body">${utilisateurDto.dateInscription}</td>

                    <td class="user01-body">${utilisateurDto.role.libelle}</td>

                    <td class="user01-body"><c:choose>
                            <c:when test="${utilisateurDto.estDesactive}">
                                <img class="user01-imageNonActive 
                                checkboxVide" alt=""
                                    src="img/commun/checkboxVide.png">
                            </c:when>
                            <c:otherwise>
                                <img alt="" src="img/commun/checkboxVert.jpg" class="checkboxVert user01-image">
                            </c:otherwise>
                        </c:choose></td>

                    <td class="user01-body"><a
                        href="modifierUtilisateur.do?origin=2&ref=${utilisateurDto.reference}"> <img alt=""
                            src="img/commun/editer.png" class="poubelle user01-image">
                    </a></td>

                    <td class="user01-body"><a
                        href="supprimerUtilisateur.do?origin=2&ref=${utilisateurDto.reference}"
                        onclick="return confirm('<spring:message code="usr01.consulter.confirmer_suppression" />')">
                            <img alt="" src="img/commun/poubelle.jpg" class="editer user01-image">
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>