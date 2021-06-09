<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="panierProd">
    <h1>
        <%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
        <spring:message code="pan00.titre" />
    </h1>
    <ul>
        <li>Nom : ${utilisateur.nom}</li>
        <li>Prenom : ${utilisateur.prenom}</li>
        <li>Nombre de produit dans le panier : ${utilisateur.panierDto.nombreDeReferences}</li>
    </ul>




</div>

