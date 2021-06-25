<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive">${consulterProduitDto.nom}</h1>
    </div>
    <a href="listerProduits.do"><spring:message code="pdt04.retour"></spring:message></a>
    <div class="display-flex pdt04Flex-container flex-wrap-wrap">
        <div>
            <table class="pdt04Display2">
                <tr>
                    <th colspan="2" class="pdt04Hebergement">${consulterProduitDto.hebergement}</th>
                </tr>
                <tr>
                    <td rowspan="5"><img src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt"
                        alt="${consulterProduitDto.destination}" class="pdt04Image" /></td>
                </tr>
                <tr>
                    <td><spring:message code="pdt04.reference"></spring:message>${consulterProduitDto.reference}</td>
                </tr>
                <tr>
                    <td><spring:message code="pdt04.prix"></spring:message>${consulterProduitDto.prixUnitaire}&nbsp€</td>
                </tr>
                <tr>
                    <td>+/-</td>
                </tr>
                <tr>
                    <td>AJOUTER</td>
                </tr>
            </table>
            <div class="display-flex pdt04IconeServices">
                <div>
                    <table class="pdt04Display2">
                        <tr>
                            <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.services"></spring:message></th>
                        </tr>
                        <tr class="pdt04IconeServices">
                            <td><em class="fa fa-glass"></em></td>
                            <td><em class="fa fa-bath"></em></td>
                            <td><em class="fa fa-paw"></em></td>
                            <td><em class="fa fa-gamepad"></em></td>
                            <td><em class="fa fa-wifi"></em></td>
                            <td><em class="fa fa-cutlery"></em></td>
                            <td><em class="fa fa-wheelchair"></em></td>
                            <td><em class="fa fa-snowflake-o"></em></td>
                            <td><em class="fa fa-tv"></em></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <table class="pdt04Display2">
            <tr>
                <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.description"></spring:message></th>
            </tr>
            <tr>
                <td><textarea maxlength="250" rows="15" cols="50" readonly="readonly" class="pdt04TextArea">${consulterProduitDto.description}</textarea></td>
            </tr>
        </table>

    </div>
</div>
