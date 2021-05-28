<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Test de style va être bouger après --%>
<style>
#titreGestion {
	text-align: center;
	color: rgb(134, 213, 242);
}

#listeUser {
	border-collapse: collapse;
	border: 1px solid black;
	overflow-y: scroll;
	width: 100%;
}

th {
	font-weight: lighter;
	border-bottom: 1px solid black;
	padding: 7px 0;
}

tbody, td {
	border-bottom: 1px solid black;
	text-align: center;
	font-weight: bold;
	padding: 9px 0;
}

#image {
	width: 40px;
	height: 40px;
}

#imageNonActif {
	width: 25px;
	height: auto;
}
</style>

<h2 id="titreGestion">
    <spring:message code="usr01.titre" />
</h2>

<table id="listeUser" aria-describedby="titreGestion">
    <thead>
        <tr>
            <th><spring:message code="usr01.th.ref" /></th>

            <th><spring:message code="usr01.th.nom" /></th>

            <th><spring:message code="usr01.th.date" /></th>

            <th><spring:message code="usr01.th.profil" /></th>

            <th><spring:message code="usr01.th.actif" /></th>

            <th><spring:message code="usr01.th.editer" /></th>

            <th><spring:message code="usr01.th.supprimer" /></th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${listeUtilisateur}" var="utilisateurDto">
            <tr>
                <td>${utilisateurDto.reference}</td>

                <td>${utilisateurDto.nom}/${utilisateurDto.prenom}</td>

                <td>${utilisateurDto.dateInscription}</td>

                <td></td>

                <td><c:choose>
                        <c:when test="${utilisateurDto.estActif}">
                            <img id="image" alt="" src="img/utilisateur/listerUtilisateur/checkboxVert.jpg"
                                class="checkboxVert">
                        </c:when>
                        <c:otherwise>
                            <img id="imageNonActif" alt="" src="img/utilisateur/listerUtilisateur/checkboxVide.png"
                                class="checkboxVide">
                        </c:otherwise>
                    </c:choose></td>

                <td><img id="image" alt="" src="img/utilisateur/listerUtilisateur/editer.png" class="poubelle"></td>

                <td><img id="image" alt="" src="img/utilisateur/listerUtilisateur/poubelle.jpg" class="editer"></td>
            </tr>
        </c:forEach>
    </tbody>
</table>