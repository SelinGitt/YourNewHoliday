<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive">${consulterProduitDto.nom}</h1>
        <a href="listerProduits.do"><spring:message code="pdt04.retour"></spring:message></a>
    </div>
    <div class="flex-container">
        <div>
            <table>
                <tr>
                    <th colspan="2">${consulterProduitDto.hebergement}</th>
                </tr>
                <tr>
                    <td rowspan="5"><img src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt"
                        alt="${consulterProduitDto.destination}" class="img" /></td>
                </tr>
                <tr>
                    <td>${consulterProduitDto.reference}</td>
                </tr>
                <tr>
                    <td>${consulterProduitDto.prixUnitaire}</td>
                </tr>
                <tr>
                    <td>+/-</td>
                </tr>
                <tr>
                    <td>AJOUTER</td>
                </tr>
            </table>
        </div>

        <div>
            <table>
                <tr>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>${consulterProduitDto.description}</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="flex-container">
        <div>
            <table>
                <tr>
                    <th>Services</th>
                </tr>
                <tr>
                    <td>${consulterProduitDto.services}</td>
                </tr>
            </table>
        </div>
    </div>
</div>