<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 id="titreGestion">
    <spring:message code="usr01.titre" />
</h1>

<form action="creerUtilisateur.do">
         <button type="submit" class="far fa-plus-square"><spring:message code="usr01.creer.nouveau"/></button>
      </form>

<table id="listeUser" aria-describedby="titreGestion">
    <thead>
        <tr>
            <th class="thUSR01"><spring:message code="usr01.th.ref" /></th>

            <th class="thUSR01"><spring:message code="usr01.th.nom" /></th>

            <th class="thUSR01"><spring:message code="usr01.th.date" /></th>

            <th class="thUSR01"><spring:message code="usr01.th.profil" /></th>

            <th class="thUSR01"><spring:message code="usr01.th.actif" /></th>

            <th class="thUSR01"><spring:message code="usr01.th.editer" /></th>

            <th class="thUSR01"><spring:message code="usr01.th.supprimer" /></th>
        </tr>
    </thead>

    <tbody class="bodyUSR01">
        <c:forEach items="${listeUtilisateur}" var="utilisateurDto">
            <tr>
                <td class="bodyUSR01">${utilisateurDto.reference}</td>

                <td class="bodyUSR01">${utilisateurDto.nom}/${utilisateurDto.prenom}</td>

                <td class="bodyUSR01">${utilisateurDto.dateInscription}</td>

                <td class="bodyUSR01">${utilisateurDto.role.libelle}</td>

                <td class="bodyUSR01"><c:choose>
                        <c:when test="${utilisateurDto.estDesactive}">
                            <img alt="" src="img/commun/checkboxVert.jpg"
                                class="checkboxVert imageUSR01">
                        </c:when>
                        <c:otherwise>
                            <img id="imageNonActif" alt="" src="img/commun/checkboxVide.png"
                                class="checkboxVide">
                        </c:otherwise>
                    </c:choose></td>

                <td class="bodyUSR01">
                    <a href="javascript:void()">
                        <img alt="" src="img/commun/editer.png" class="poubelle imageUSR01">
                    </a>
                </td>

                <td class="bodyUSR01">
                    <a href="javascript:void()">
                        <img alt="" src="img/commun/poubelle.jpg" class="editer imageUSR01">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

