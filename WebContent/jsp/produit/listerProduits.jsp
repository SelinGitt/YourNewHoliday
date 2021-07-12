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
            <input value="${searchTerm}" name="searchInput" class="pdtSearchBarInside" type="search"
                placeholder="<spring:message code='pdt00.searchbar'/>">
            <input type="submit" value="<spring:message code="pdt.recherche.OK"/>" class="pdtSearchBarOk" />
        </form:form>
    </div>
    <br />
    <div class="display-flex flex-wrap-wrap justify-content-center">
        <c:forEach items="${listeProduitDto}" var="produitDto">
            <table class="pdt00ContainerVoyage display-inline-flex justify-content-center flex-wrap-wrap"
                aria-label="Produit">
                <tr>
                    <th colspan="2"><a href="consulterProduit.do?idProduit=${produitDto.idProduitOriginal}"> <img
                            src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt"
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
                                        class="background-color-green display-flex justify-content-flex-end pdt00Bouton">
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