<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1>
    <spring:message code="usr00.titre" />
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
    </div>
    <div class="rightSideUser00">
        <p>Section avatar And co</p>
    </div>
    <button onclick="listerProduits.do" type="button">Modifier</button>
    <a href="#">Modifier</a> 
    <a href="supprimerUtilisateur.do">Supprimer</a>
</div>