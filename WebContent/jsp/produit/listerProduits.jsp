<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive">
            <spring:message code="pdt00.titre" />
        </h1>
    </div>
    <br />
    <div class="searchBar">
        <form:form action="listerProduits.do" method="POST">
            <input value="${searchTerm}" name="searchInput" class="searchBarInside" type="search"
                placeholder="<spring:message code='pdt00.searchbar'/>">
            <input type="submit" value="<spring:message code="pdt00.recherche.OK"/>" class="searchBarOk" />
        </form:form>
    </div>
    <br />
    <div class="container">
        <c:forEach items="${listeProduitDto}" var="produitDto">
            <table class="containerVoyage" aria-label="Produit">
                <tr>
                    <th colspan="2"><img
                        src="https://www.voyage-prive.com/s/images/visual/login/backgrounds/2048x1463-maroc.jpg"
                        alt="Maroc" class="img" /></th>
                </tr>
                <tr class="lineRow">
                    <td class="name text-responsive">${produitDto.nom}</td>
                    <td class="price text-responsive">${produitDto.prixUnitaire}€</td>
                </tr>
                <tr>
                    <td class="text-responsive">${produitDto.reference}</td>
                </tr>
                <tr>
                    <td class="description text-responsive">${produitDto.description}</td>
                </tr>
            </table>
        </c:forEach>
    </div>
</div>