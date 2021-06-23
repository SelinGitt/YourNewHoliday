<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive">${consulterProduitDto.nom}</h1>
        <a href="listerProduits.do"><spring:message code="pdt04.retour"></spring:message> </a>
    </div>
    <table style="width: 100%" class="consulterProduit">
        <tr>
            <th class="tableauPdt04" colspan="2">${consulterProduitDto.hebergement}
            <th class="description text-responsive tableauPdt04"><spring:message code="pdt04.description"></spring:message><br>${consulterProduitDto.description}</th>
        </tr>
        <tr>
            <td class="tableauPdt04"><img class="imagePDT04"
                src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt"
                alt="${consulterProduitDto.destination}" width="30%" /> 
                <td> <spring:message code="pdt04.reference"></spring:message> ${consulterProduitDto.reference}</td>
        </tr>
    </table>
    <table>
        <tr>
            <th><spring:message code="pdt04.services"></spring:message> ${consulterProduitDto.services}</th>
        </tr>
    </table>
</div>