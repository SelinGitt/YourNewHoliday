<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <c:if test="${not empty anyError}">
        <div class="background-error-block block-message-commun">
            <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${anyError}" /></span>
        </div>
    </c:if>
    <c:if test="${not empty anySuccess}">
        <div class="background-validation-block block-message-commun">
           <span class="fa fa-check"></span>  <span><spring:message code="${anySuccess}" /></span>
        </div>
    </c:if>

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
            <input type="submit" form="tri" value="<spring:message code='pdt.recherche.OK'/>">
        </form:form>
    </div>
    <br />
    <div class="display-flex flex-wrap-wrap justify-content-center">
        <c:forEach items="${listeProduitDto}" var="produitDto">
            <table class="pdt00ContainerVoyage display-inline-flex justify-content-center flex-wrap-wrap"
                aria-label="Produit">
                <tr>
                    <th colspan="2"><a
                        href="consulterProduit.do?idProduit=${produitDto.idProduitOriginal}&from=liste"> 
                        <img src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt"
                            alt="${produitDto.destination}" class="pdt00Img display-flex justify-content-center" />
                    </a></th>
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
                <c:if test="${not empty utilisateur}">
                    <tr class="display-flex">
                        <form:form action="ajouterProduitPanier.do" requestParam="beanQuantite" method="POST">
                            <input type="hidden" name="location" value="lister" />
                            <input type="hidden" name="id" value="${produitDto.idProduitOriginal}" />
                            <td class="display-flex text-responsive">
                                <div class="display-flex">
                                    <%--  bouton - --%>
                                    <a onclick="decrement('${produitDto.idProduitOriginal}')">
                                        <button type="button">-</button>
                                    </a>

                                    <%--  saisie valeur produit  --%>
                                    <input class="pdt00-pan-quantite text-align-center" type="text" readonly="readonly"
                                        id="quantite${produitDto.idProduitOriginal}" name="quantite" value="1" size="1">

                                    <%--  bouton + --%>
                                    <a onclick="increment('${produitDto.idProduitOriginal}')">
                                        <button type="button">+</button>
                                    </a>
                                </div>
                            </td>
                            <td colspan="2" class="pdt00Ajouter text-responsive display-flex justify-content-flex-end">
                                <div>
                                    <button value="submit"
                                        class="background-color-green display-flex 
                                               justify-content-flex-end pdt00Bouton">
                                        <spring:message code="pdt.addCart" />
                                    </button>
                                </div>
                            </td>
                        </form:form>
                    </tr>
                </c:if>
            </table>
        </c:forEach>
    </div>
</div>