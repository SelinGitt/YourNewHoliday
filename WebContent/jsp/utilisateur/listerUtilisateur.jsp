<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/style.css">
<h2 id="titreGestion">
    <spring:message code="usr01.titre" />
</h2>

<table id="listeUser" aria-describedby="titreGestion">
    <thead>
        <tr>
            <th id="thUSR01"><spring:message code="usr01.th.ref" /></th>

            <th id="thUSR01"><spring:message code="usr01.th.nom" /></th>

            <th id="thUSR01"><spring:message code="usr01.th.date" /></th>

            <th id="thUSR01"><spring:message code="usr01.th.profil" /></th>

            <th id="thUSR01"><spring:message code="usr01.th.actif" /></th>

            <th id="thUSR01"><spring:message code="usr01.th.editer" /></th>

            <th id="thUSR01"><spring:message code="usr01.th.supprimer" /></th>
        </tr>
    </thead>

    <tbody id="bodyUSR01">
        <c:forEach items="${listeUtilisateur}" var="utilisateurDto">
            <tr>
                <td id="bodyUSR01">${utilisateurDto.reference}</td>

                <td id="bodyUSR01">${utilisateurDto.nom}/${utilisateurDto.prenom}</td>

                <td id="bodyUSR01">${utilisateurDto.dateInscription}</td>

                <td id="bodyUSR01"></td>

                <td id="bodyUSR01"><c:choose>
                        <c:when test="${utilisateurDto.estActif}">
                            <img id="imageUSR01" alt="" src="img/utilisateur/listerUtilisateur/checkboxVert.jpg"
                                class="checkboxVert">
                        </c:when>
                        <c:otherwise>
                            <img id="imageNonActif" alt="" src="img/utilisateur/listerUtilisateur/checkboxVide.png"
                                class="checkboxVide">
                        </c:otherwise>
                    </c:choose></td>

                <td id="bodyUSR01"><img id="imageUSR01" alt="" src="img/utilisateur/listerUtilisateur/editer.png" class="poubelle"></td>

                <td id="bodyUSR01"><img id="imageUSR01" alt="" src="img/utilisateur/listerUtilisateur/poubelle.jpg" class="editer"></td>
            </tr>
        </c:forEach>
    </tbody>
</table>