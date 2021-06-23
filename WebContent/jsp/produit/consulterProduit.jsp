<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive">${consulterProduitDto.nom}</h1>
        <a href="listerProduits.do"><spring:message code="pdt04.retour"></spring:message> </a>
    </div>
    <table>
        <tr>
            <td>${consulterProduitDto.hebergement}
            <td class="description text-responsive">${consulterProduitDto.description}</td>
        </tr>
        <tr><td><img src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt" alt="${consulterProduitDto.destination}"
            class="img" /></td></tr>
        <tr>
            <td>${consulterProduitDto.reference}
        </tr>
        <tr>
            <td><spring:message code="pdt04.prix"></spring:message> ${consulterProduitDto.prixUnitaire} €
        </tr>
        <tr><td><spring:message code="pdt04.services"></spring:message> ${consulterProduitDto.services}</td>
        </tr>
    </table>
</div>