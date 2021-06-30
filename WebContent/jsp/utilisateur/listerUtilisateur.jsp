<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 id="titreGestion">
    <spring:message code="usr01.titre" />
</h1>

<div class="conteneur-ascenseur">
    <div class="user01-searchMenu display-flex">
        <div class="usr01searchBar">
            <form:form action="listerUtilisateur.do" method="POST">
                <input value="${searchTerm}" name="searchInput" class="searchBarInside" type="search"
                    placeholder="<spring:message code='usr01.searchbar'/>">
                <input type="hidden" name="searchType" value="search" />
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
                                <img alt="" src="img/commun/checkboxVert.jpg" class="checkboxVert user01-image">
                            </c:when>
                            <c:otherwise>
                                <img class="user01-imageNonActive" alt="" src="img/commun/checkboxVide.png" class="checkboxVide">
                            </c:otherwise>
                        </c:choose></td>

                    <td class="user01-body"><a href="javascript:void()"> <img alt="" src="img/commun/editer.png"
                            class="poubelle user01-image">
                    </a></td>

                    <td class="user01-body"><a href="javascript:void()"> <img alt=""
                            src="img/commun/poubelle.jpg" class="editer user01-image">
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>