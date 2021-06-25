<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <h1 class="text-align-center">
        <spring:message code="pdt01.titre" />
    </h1>

    <table class="listeProduit" aria-describedby="GestionProduit">
        <thead>
            <tr>
                <th class="thPDT01"><spring:message code="pdt01.th.ref" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.nom" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.icone" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.destination" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.prix" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.enVente" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.editer" /></th>

                <th class="thPDT01"><spring:message code="pdt01.th.supprimer" /></th>
            </tr>
        </thead>

        <tbody class="bodyPDT01">
            <c:forEach items="${listeAllProduitDto}" var="produitDto">
                <tr>
                    <td class="bodyPDT01">${produitDto.reference}</td>

                    <td class="bodyPDT01">${produitDto.nom}</td>

                    <td class="bodyPDT01"><img src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt"
                        alt="${produitDto.nom}" class="iconePDT01" /></td>

                    <td class="bodyPDT01">${produitDto.destination}</td>

                    <td class="bodyPDT01">${produitDto.prixUnitaire}€</td>

                    <td class="bodyPDT01"><c:choose>
                            <c:when test="${produitDto.miseEnVente}">
                                <img alt="" src="img/commun/checkboxVert.jpg" class="checkboxVert imagePDT01">
                            </c:when>
                            <c:otherwise>
                                <img id="imageNonActif" alt="" src="img/commun/checkboxVide.png" />
                            </c:otherwise>
                        </c:choose></td>

                    <td class="bodyPDT01"><a href="javascript:void()"> <img alt="" src="img/commun/editer.png"
                            class="imagePDT01">
                    </a></td>

                    <td class="bodyPDT01"><a href="javascript:void()"> <img alt=""
                            src="img/commun/poubelle.jpg" class="imagePDT01">
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>