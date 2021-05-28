<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
    <h1 class="title">
        <spring:message code="pdt00.titre" />
    </h1>
</div>
<br />
<table>
    <tbody>
        <c:forEach items="${listeProduitDto}" var="produitDto">
            <tr>
                <td>${produitDto.nom}</td>
                <td>${produitDto.miseEnVente}</td>
                <td>${produitDto.prixUnitaire}</td>
            <tr>
                <td>${produitDto.reference}</td>
            <tr>
                <td>${produitDto.description}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br />

