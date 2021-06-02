<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
    <h1 class="title">
        <spring:message code="pdt00.titre" />
    </h1>
</div>
<br />
<div class=searchBar><input type="search" placeholder="<spring:message code="pdt00.searchbar"/>"><button>OK</button></div>
<div class="container">
    <c:forEach items="${listeProduitDto}" var="produitDto">
        <table class="containerVoyage">
            <tr>
                <th colspan="2"><img
                    src="https://www.voyage-prive.com/s/images/visual/login/backgrounds/2048x1463-maroc.jpg" alt="Maroc"
                    style="max-width: 100%" /></th>
            </tr>
            <tr>
                <td class="name">${produitDto.nom}</td>
                <td class="price">${produitDto.prixUnitaire}€</td>
            </tr>
            <tr>
                <td>${produitDto.reference}</td>
            </tr>
            <tr>
                <td style="display: flex; max-width: 75%">${produitDto.description}</td>
            </tr>
        </table>
    </c:forEach>
</div>
<br />

