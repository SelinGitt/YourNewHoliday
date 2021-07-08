<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="conteneur-ascenseur">
    <h1 class="text-align-center">
        <spring:message code="pdt01.titre" />
    </h1>
    <div class="searchBar display-flex pdt01Search align-content-flex-end ">
        <form:form action="listerProduitsAdmin.do" method="POST">
            <input value="${searchTerm}" name="searchInput" class="pdtSearchBarInside" type="search"
                placeholder="<spring:message code='pdt01.searchbar'/>">
            <input type="submit" value="<spring:message code="pdt.recherche.OK"/>" class="pdtSearchBarOk" />
        </form:form>
    </div>
    <br>
    <table class="pdtListeProduit" aria-describedby="GestionProduit">
        <thead>
            <tr>
                <th class="pdt01"><spring:message code="pdt01.th.ref" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.nom" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.icone" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.destination" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.prix" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.enVente" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.editer" /></th>

                <th class="pdt01"><spring:message code="pdt01.th.supprimer" /></th>
            </tr>
        </thead>
        <tbody class="pdt01Body">
            <c:forEach items="${listeAllProduitDto}" var="produitDto">
                <tr>
                    <td class="pdt01Body">${produitDto.reference}</td>

                    <td class="pdt01Body">${produitDto.nom}</td>

                    <td class="pdt01Body"><img src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt"
                        alt="${produitDto.nom}" class="pdt01Icone" /></td>

                    <td class="pdt01Body">${produitDto.destination}</td>

                    <td class="pdt01Body">${produitDto.prixUnitaire}€</td>

                    <td class="pdt01Body"><c:choose>
                            <c:when test="${produitDto.miseEnVente}">
                                <img alt="" src="img/commun/checkboxVert.jpg" class="pdt01Image">
                            </c:when>
                            <c:otherwise>
                                <img class="pdt01Image" alt="" src="img/commun/checkboxVide.png" />
                            </c:otherwise>
                        </c:choose></td>
                    <td class="pdt01Body"><a href="javascript:void()"><img alt="" src="img/commun/editer.png"
                            class="pdt01Image"> </a></td>
                    <td class="pdt01Body"><a
                        href="supprimerProduitAdmin.do?idProduit=${produitDto.idProduitOriginal}"
                        onclick="return confirm('<spring:message code="pdt01.confirmDelete" />')"><img alt=""
                            src="img/commun/poubelle.jpg" class="pdt01Image"></a></td>
                    <td class="pdt01Body"><a href="editerProduitAdmin.do?ref=${produitDto.reference}"> <img
                            alt="" src="img/commun/editer.png" class="pdt01Image">
                    </a></td>
                    <td class="pdt01Body"><a href="javascript:void()"> <img alt=""
                            src="img/commun/poubelle.jpg" class="pdt01Image">
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>