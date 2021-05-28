<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
    <h1 class="title">
        <spring:message code="pdt00.titre" />
    </h1>
</div>
<br />
<div class="container">

    <c:forEach items="${listeProduitDto}" var="produitDto">
        <table class="containerVoyage">
            <tr>
                <td class="image"><img src="https://www.publicdomainpictures.net/pictures/320000/velka/background-image.png" /></td>
            </tr>
            <tr>
                <td>${produitDto.nom}</td>
                <td>${produitDto.prixUnitaire}</td>
            </tr>
            <tr>
                <td>${produitDto.reference}</td>
            </tr>
            <tr>
                <td>${produitDto.description}</td>
            </tr>
        </table>

    </c:forEach>
</div>
<br />

