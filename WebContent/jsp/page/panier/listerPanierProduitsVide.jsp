<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
<h1>
    <spring:message code="pan00.titre" />
</h1>
<div class="display-flex align-item-center justify-content-center flex-column ">
    <p class="panier-vide-ligne">
        <spring:message code="pan00.paragraphe.panierVide" />
    </p>
    <img src="img/panier/oups.png" alt="image panier vide">
</div>
