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
                <th colspan="2"><img
                    src="https://s1.1zoom.me/b3053/688/Morocco_Mosque_Coast_Ocean_Casablanca_Mesquita_de_565803_1920x1080.jpg"
                    alt="Maroc" style="max-width: 100%" /></th>
            </tr>
            <tr>
                <td class="name">${produitDto.nom}</td>
                <td class="price">${produitDto.prixUnitaire}</td>
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

