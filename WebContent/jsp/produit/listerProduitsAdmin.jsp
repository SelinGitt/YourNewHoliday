<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.listerProduitsAdmin" />
</p>

<c:if test="${not empty anyError}">
    <div class="background-error-block block-message-commun">
        <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${anyError}" /></span>
    </div>
</c:if>
<c:if test="${not empty anySuccess}">
    <div class="background-validation-block block-message-commun">
        <span class="fa fa-check"></span> <span><spring:message code="${anySuccess}" /></span>
    </div>
</c:if>
<h1 class="text-align-center">
    <spring:message code="pdt01.titre" />
</h1>

<div class="display-flex align-items-flex-end">
    <div class="searchBar display-flex pdt01Search align-content-flex-end ">
        <form:form action="listerProduitsAdmin.do" method="POST">
            <input type="hidden" name="tri" value="${tri}" />
            <input value="${searchTerm}" name="searchInput" class="pdtSearchBarInside" type="search"
                placeholder="<spring:message code='pdt01.searchbar'/>">
            <input type="submit" value="<spring:message code="pdt.recherche.OK"/>" class="pdtSearchBarOk" />
        </form:form>
    </div>
    <div class="pdt01-searchBarSpace">
        <form:form action="listerProduitsAdmin.do" method="POST">
            <input type="hidden" name="searchInput" value="${searchTerm}" />
            <input type="hidden" name="miseEnVente" value="${produitDto.miseEnVente}" />
            <select id="triSelect" name="tri">
                <option selected value=""><spring:message code="pdt01.tri.tous"></spring:message></option>
                <option value="1"><spring:message code="pdt01.tri.enVente"></spring:message></option>
                <option value="2"><spring:message code="pdt01.tri.horsVente"></spring:message></option>
            </select>
            <script>
                     document.getElementById("triSelect").options[${tri}].selected=true;
				</script>
            <input type="submit" value="<spring:message code='pdt.recherche.OK'/>">
        </form:form>
    </div>
    <div class="pdt01AddProduit">
        <a href="creerProduitAdmin.do">
            <button type="button" class="bouton-sans-impact-BD">
                <span class="fa fa-plus-square-o" aria-hidden="true"></span>
                <spring:message code="pdt01.creer.nouveau" />
            </button>
        </a>
    </div>
</div>
<div class="pdt01-conteneur-ascenseur">

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
                    <td class="pdt01Body"><a
                        href="consulterProduit.do?idProduit=${produitDto.idProduitOriginal}&from=listeAdmin">
                            ${produitDto.reference}</a></td>

                    <td class="pdt01Body">${produitDto.nom}</td>

                    <td class="pdt01Body"><a
                        href="consulterProduit.do?idProduit=${produitDto.idProduitOriginal}&from=listeAdmin"> <img
                            src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt" alt="${produitDto.nom}"
                            class="pdt01Icone" />
                    </a></td>

                    <td class="pdt01Body">${produitDto.destination}</td>

                    <td class="pdt01Body">${produitDto.prixUnitaire}&nbsp€</td>

                    <td class="pdt01Body"><c:choose>
                            <c:when test="${produitDto.miseEnVente}">
                                <img alt="" src="img/commun/checkboxVert.jpg" class="pdt01Image">
                            </c:when>
                            <c:otherwise>
                                <img alt="" src="img/commun/checkboxVide.png" class="pdt01ImageNonActive" />
                            </c:otherwise>
                        </c:choose></td>
                    <td class="pdt01Body"><a href="editerProduitAdmin.do?ref=${produitDto.reference}"> <img
                            alt="" src="img/commun/editer.png" class="pdt01Image">
                    </a></td>
                    <td class="pdt01Body"><a
                        href="supprimerProduitAdmin.do?idProduit=${produitDto.idProduitOriginal}"
                        onclick="return confirm('<spring:message code="pdt01.confirmDelete" />')"> <img alt=""
                            src="img/commun/poubelle.jpg" class="pdt01Image">
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>