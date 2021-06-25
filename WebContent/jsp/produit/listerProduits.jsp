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
            <input type="hidden" name="tri" value="${tri}" />
            <input value="${searchTerm}" name="searchInput" class="searchBarInside" type="search"
                placeholder="<spring:message code='pdt00.searchbar'/>">
            <input type="submit" value="<spring:message code='pdt00.recherche.OK'/>" class="searchBarOk" />
        </form:form>
        <form:form action="listerProduits.do" method="POST" id="tri">
            <input type="hidden" name="searchInput" value="${searchTerm}" />
            <select id="triSelect" name="tri">
                <option disabled value="0"><spring:message code="pdt00.tri.default"/></option>
                <option value="1"><spring:message code="pdt00.tri.asc"></spring:message></option>
                <option value="2"><spring:message code="pdt00.tri.desc"></spring:message></option>
            </select>
            <script>
            		document.getElementById("triSelect").options[${tri}].selected=true;          	
            </script>
            <input type="submit" form="tri" value="<spring:message code='pdt00.recherche.OK'/>">
        </form:form>
    </div>
    <div class="container">
        <c:forEach items="${listeProduitDto}" var="produitDto">
            <table class="containerVoyage" aria-label="Produit">
                <tr>
                    <th colspan="2"><img src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt"
                        alt="${produitDto.destination}" class="img" /></th>
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