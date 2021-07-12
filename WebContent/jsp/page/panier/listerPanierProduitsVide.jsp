<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="background-error-block block-message-commun">
    <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${errorPanVide}" /></span>
</div>

<%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
<h1 class="panier-title">
    <spring:message code="pan00.titre" />
</h1>
<div class="display-flex align-item-center justify-content-center flex-direction-column ">

    <p class="panier-vide-ligne">
        <spring:message code="pan00.paragraphe.panierVide" />
    </p>
    <img src="img/panier/oups.png" alt="image panier vide">
</div>
