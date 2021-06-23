<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive">${consulterProduitDto.nom}</h1>
        <a href="listerProduits.do"><spring:message code="pdt04.retour"></spring:message> </a>
    </div>
    <table class="tableauPDT04">
        <tr>
            <th colspan="2" class="thPDT04">${consulterProduitDto.hebergement}</th>
            <th class="thPDT04"><spring:message code="pdt04.description"></spring:message> </th>
        </tr>
        <tr>
            <td rowspan="4" class="tdPDT04"><img class="imagePDT04"
                        src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt"
                        alt="${consulterProduitDto.destination}" class="img" /></td>
            <td class="tdPDT04"><spring:message code="pdt04.reference"></spring:message> ${consulterProduitDto.reference}</td>
            <td rowspan="5" class="tdPDT04">${consulterProduitDto.description}</td>
        </tr>
        <tr>
            <td class="tdPDT04"><spring:message code="pdt04.prix"></spring:message>${consulterProduitDto.prixUnitaire} €</td>
        </tr>
        <tr>
            <td class="tdPDT04">bouton + / -</td>
        </tr>
        <tr>
            <td class="tdPDT04">bouton AJOUTER</td>
        </tr>
        <tr>
            <td colspan="2" class="tdPDT04"><spring:message code="pdt04.services"></spring:message></td>
        </tr>
    </table>
</div>