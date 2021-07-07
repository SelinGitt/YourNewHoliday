<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div>
        <c:if test="${not empty deletionSuccess}">
            <span><spring:message code="${deletionSuccess}" /></span>
        </c:if>
    </div>

    <div>
        <h1 class="title title-responsive text-align-center">
            <spring:message code="pdt00.titre" />
        </h1>
    </div>
    <br />
    <div class="searchBar display-flex justify-content-flex-end align-content-flex-end align-items-flex-end">
        <form:form action="listerProduits.do" method="POST">
            <input type="hidden" name="tri" value="${tri}" />
            <input value="${searchTerm}" name="searchInput" class="pdtSearchBarInside" type="search"
                placeholder="<spring:message code='pdt00.searchbar'/>">
            <input type="submit" value="<spring:message code="pdt.recherche.OK"/>" class="pdtSearchBarOk" />
        </form:form>
        <form:form action="listerProduits.do" method="POST" id="tri">
            <input type="hidden" name="searchInput" value="${searchTerm}" />
            <select id="triSelect" name="tri">
                <option disabled><spring:message code="pdt00.tri.default" /></option>
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
        <br />
        <div class="display-flex flex-wrap-wrap justify-content-center">
            <c:forEach items="${listeProduitDto}" var="produitDto">
                <table class="pdt00ContainerVoyage display-inline-flex justify-content-center flex-wrap-wrap"
                    aria-label="Produit">
                    <tr>
                        <th colspan="2"><img src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt"
                            alt="${produitDto.destination}" class="pdt00Img display-flex justify-content-center" /></th>
                    </tr>
                    <tr class="display-flex">
                        <td class="display-flex text-responsive">${produitDto.nom}</td>
                        <td class="pdt00Price text-responsive display-flex justify-content-flex-end">
                            ${produitDto.prixUnitaire} €</td>
                    </tr>
                    <tr>
                        <td class="text-responsive">${produitDto.reference}</td>
                    </tr>
                    <tr>
                        <td class="pdt00Description display-flex text-responsive">${produitDto.description}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
    </div>
</div>