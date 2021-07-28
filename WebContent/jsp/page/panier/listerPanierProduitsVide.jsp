<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.pan_00_vide" />
</p>

<div class="background-error-block block-message-commun">
    <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${errorPanVide}" /></span>
</div>
<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="header.connexion" />
</p>
<%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
<h1 class="panier-title">
    <spring:message code="pan00.titre" />
</h1>
<div class="display-flex align-item-center justify-content-center flex-direction-column ">
    <p class="panier-vide-ligne">
        <spring:message code="pan00.paragraphe.panierVide" />
    </p>
    <a href="listerProduits.do"> <img class="panier-vide-img" src="img/panier/oups.png" alt="image panier vide">
    </a>
</div>
<script>
	document.title = document.getElementById('titrePage').textContent;
	document.getElementById('titrePage').remove();
</script>