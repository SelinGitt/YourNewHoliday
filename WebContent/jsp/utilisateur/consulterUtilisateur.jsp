<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
    <c:if test="${not empty error}">
        <span class="errorblock"><spring:message code="${error}" /></span>
    </c:if>
</div>
<h1>
    <spring:message code="usr00.titre" />
    - ${fn:toUpperCase(utilisateurDto.role.libelle)}
</h1>

<div class="user00">
    <div class="leftSideUser00">
        <table aria-describedby="ConsulterUtilisateur">
            <tr>
                <th><spring:message code="usr00.consulter.nom" /></th>
                <td>${utilisateurDto.nom}</td>
            </tr>
            <tr>
                <th><spring:message code="usr00.consulter.prenom" /></th>
                <td>${utilisateurDto.prenom}</td>
            </tr>
            <tr>
                <th><spring:message code="usr00.consulter.adresse" /></th>
                <td>${utilisateurDto.adresse}</td>
            </tr>
            <tr>
                <th><spring:message code="usr00.consulter.dateNaissance" /></th>
                <td>${utilisateurDto.dateNaissance}</td>
            </tr>
            <tr>
                <th><spring:message code="usr00.consulter.email" /></th>
                <td>${utilisateurDto.email}</td>
            </tr>
            <tr>
                <th><spring:message code="usr00.consulter.password" /></th>
                <td>**********</td>
            </tr>
        </table>

        <a href="#">Modifier</a> <a href="supprimerUtilisateur.do"
            onclick="return confirm('<spring:message code="usr00.consulter.confirm_deletion" />')">Supprimer</a>

    </div>
    <div class="rightSideUser00">
        <p>Section avatar And co</p>
    </div>
</div>