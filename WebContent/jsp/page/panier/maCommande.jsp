<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--  fieldset ma commande : nom, référence, prix unitaire, quantité et prix  --%>
<fieldset class="overflow-auto panier-macommande">
    <legend class="panier-legend">
        <spring:message code="pan00.titre.fieldset.commande" />
    </legend>

    <c:forEach items="${panierDto.mapPanier}" var="entry">
        <%--  nom et référence --%>
        <div>
            <h3>${entry.key.nom}-${entry.key.reference}</h3>
        </div>

        <%--  quantité --%>
        <div class="display-flex justify-content-space-between panier-ligne-quantite">
            <div class="display-flex justify-content-space-between panier-ligne-label">
                <spring:message code="pan00.quantite.bis" />
                <span><spring:message code="pan00.deuxpoints" /></span>
            </div>
            <div class="panier-ligne-quantite-box text-align-center">
                <span>${entry.value.quantite}</span>
            </div>
        </div>

        <%--  prix unitaire --%>
        <div class="display-flex justify-content-space-between panier-ligne-prix-unitaire">
            <div class="display-flex justify-content-space-between panier-ligne-label">
                <spring:message code="pan00.prix.unitaire.bis" />
                <span><spring:message code="pan00.deuxpoints" /></span>
            </div>
            ${entry.key.prixUnitaire}
            <spring:message code="glb.devise" />
        </div>

        <%--  prix  --%>
        <div class="display-flex justify-content-space-between panier-ligne-prix-unitaire">
            <div class="display-flex justify-content-space-between panier-ligne-label">
                <spring:message code="pan00.prix.bis" />
                <span><spring:message code="pan00.deuxpoints" /></span>
            </div>
            <%-- Affichage en dur provisoire pour visualiser l'alignement --%>
            <%-- Cette valeur sera implémentée par la suite dans le panierDto --%>
            <span>${entry.value.prix} <spring:message code="glb.devise" />
            </span>
        </div>
    </c:forEach>
</fieldset>