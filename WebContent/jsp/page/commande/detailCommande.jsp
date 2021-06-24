<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
    <spring:message code="detailCommande.titre.text" />${commande.reference}
</h1>
<div>
    <a href="listerCommande.do">
        <button class="commande-bouton-retour">
            <spring:message code="detailCommande.btn.retour" />
        </button>
    </a>
</div>
<div class="commande-grille commande-container commande-box-sizing commande-overflow-y">
    <div class="commande-produits commande-max-height commande-box-sizing commande-overflow-y">
        <fieldset class="commande-bordure commande-fieldset commande-max-height commande-box-sizing commande-overflow-y">
            <legend class="commande-fieldset-legend">
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div class="commande-grille commande-max-height commande-box-sizing commande-overflow-y">
                <c:forEach items="${commande.listCommandeProduitDto}" var="commandeProduit">
                    <div class="commande-bordure commande-ligne commande-box-sizing">
                        <div
                            class="commande-grille-cellule commande-colonne-1 commande-bordure-right commande-grille commande-image-grille commande-max-height commande-box-sizing">
                            <div class="commande-colonne-1 commande-max-height">
                                <img src="displayImage.do?id=${commandeProduit.produitAcheteDto.idDeLOriginal}&type=pdt"
                                    alt="${commandeProduit.produitAcheteDto.destination}" class="commande-image">
                            </div>
                            <div class="commande-colonne-2 commande-max-height">
                                <div class="commande-bold commande-aligne-text-center commande-box-title">
                                    ${commandeProduit.produitAcheteDto.nom}
                                    <spring:message code="detailCommande.tiret"></spring:message>
                                    ${commandeProduit.produitAcheteDto.reference}
                                </div>
                                <div class="commande-aligne-text-justify commande-box-text">${commandeProduit.produitAcheteDto.description}</div>
                            </div>
                        </div>
                        <div
                            class="commande-grille-cellule commande-colonne-2 commande-bordure-right commande-max-height commande-box-sizing">
                            <div class="commande-bold commande-aligne-text-center commande-box-title">
                                <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                            </div>
                            <div class="commande-aligne-text-right commande-box-text">
                                ${commandeProduit.produitAcheteDto.prixUnitaire}
                                <spring:message code="glb.devise"></spring:message>
                            </div>
                        </div>
                        <div
                            class="commande-grille-cellule commande-colonne-3 commande-bordure-right commande-max-height commande-box-sizing">
                            <div class="commande-bold commande-aligne-text-center commande-box-title">
                                <spring:message code="detailCommande.prd.quantite"></spring:message>
                            </div>
                            <div class="commande-aligne-text-center commande-box-text">${commandeProduit.quantite}</div>
                        </div>
                        <div class="commande-grille-cellule commande-colonne-4 commande-max-height">
                            <div class="commande-bold commande-aligne-text-center commande-box-title">
                                <spring:message code="detailCommande.prd.pTotal"></spring:message>
                            </div>
                            <div class="commande-aligne-text-right commande-box-text">
                                ${commandeProduit.prixTotal}
                                <spring:message code="glb.devise"></spring:message>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </fieldset>
    </div>
    <div class="commande-details commande-max-height">
        <div>
            <fieldset class="commande-bordure commande-fieldset commande-max-height">
                <legend class="commande-fieldset-legend">
                    <spring:message code="detailCommande.adr.livraison"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div>
            <fieldset class="commande-bordure commande-fieldset commande-max-height">
                <legend class="commande-fieldset-legend">
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div></div>
    </div>
</div>