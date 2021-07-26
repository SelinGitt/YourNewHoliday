<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive text-align-center">${consulterProduitAcheteDto.nom}</h1>
    </div>
    <a href="${retour}"><spring:message code="pdt04.retour"></spring:message></a>
    <div class="display-flex pdt04Flex-container flex-wrap-wrap justify-content-space-around">
        <div>
            <table aria-label="consulterProduit">
                <tr>
                    <th colspan="2" class="pdt04Hebergement">${consulterProduitAcheteDto.hebergement}</th>
                </tr>
                <tr>
                    <td rowspan="5"><img
                        src="displayImage.do?id=${consulterProduitAcheteDto.idDeLOriginal}&type=pdt"
                        alt="${consulterProduitAcheteDto.destination}" class="pdt04Image" /></td>
                </tr>
                <tr>
                    <td><spring:message code="pdt04.reference"></spring:message>
                        ${consulterProduitAcheteDto.reference}</td>
                </tr>
                <tr>
                    <td><spring:message code="pdt04.prix">
                        </spring:message>${consulterProduitAcheteDto.prixUnitaire}&nbsp€</td>
                </tr>
            </table>
            <%-- Contenu commun avec consulterProduit --%>
            <jsp:include page="iconDescriptionService.jsp">
                <jsp:param name="icon" value="consulterProduitAcheté" />
            </jsp:include>
        </div>
        <table aria-label="descriptionProduit">
            <tr>
                <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.description"></spring:message></th>
            </tr>
            <tr>
                <td><textarea maxlength="250" rows="20" cols="60" 
                readonly="readonly" class="pdt04TextArea">                
                ${consulterProduitAcheteDto.description}
                </textarea></td>
            </tr>
        </table>

    </div>
</div>