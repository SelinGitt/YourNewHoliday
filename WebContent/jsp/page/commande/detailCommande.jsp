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
<div class="commande-grille commande-container">
    <div class="commande-produits">
        <fieldset class="commande-bordure commande-fieldset commande-max-height">
            <legend class="commande-fieldset-legend">
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div class="commande-grille commande-max-height">
                <c:forEach items="${commande.listCommandeProduitDto}" var="commandeProduit">
                    <div class="commande-bordure commande-ligne">
                        <div
                            class="commande-grille-cellule commande-colonne-1 commande-bordure-right commande-grille commande-image-grille commande-max-height">
                            <div class="commande-colonne-1 commande-max-height">
                                <img src="displayImage.do?id=${commandeProduit.produitAcheteDto.idDeLOriginal}&type=pdt"
                                    alt="${commandeProduit.produitAcheteDto.destination}" class="commande-image">
                            </div>
                            <div class="commande-colonne-2 commande-max-height">
                                <p class="commande-bold commande-aligne-text-center">
                                    ${commandeProduit.produitAcheteDto.nom}
                                    <spring:message code="detailCommande.tiret"></spring:message>
                                    ${commandeProduit.produitAcheteDto.reference}
                                </p>
                                <p class="commande-aligne-text-justify">${commandeProduit.produitAcheteDto.description}</p>
                            </div>
                        </div>
                        <div class="commande-grille-cellule commande-colonne-2 commande-bordure-right">
                            <p class="commande-bold commande-aligne-text-center">
                                <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                            </p>
                            <p class="commande-aligne-text-right">
                                ${commandeProduit.produitAcheteDto.prixUnitaire}
                                <spring:message code="glb.devise"></spring:message>
                            </p>
                        </div>
                        <div class="commande-grille-cellule commande-colonne-3 commande-bordure-right">
                            <p class="commande-bold commande-aligne-text-center">
                                <spring:message code="detailCommande.prd.quantite"></spring:message>
                            </p>
                            <p class="commande-aligne-text-center">${commandeProduit.quantite}</p>
                        </div>
                        <div class="commande-grille-cellule commande-colonne-4">
                            <p class="commande-bold commande-aligne-text-center">
                                <spring:message code="detailCommande.prd.pTotal"></spring:message>
                            </p>
                            <p class="commande-aligne-text-right">
                                ${commandeProduit.prixTotal}
                                <spring:message code="glb.devise"></spring:message>
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </fieldset>
    </div>
    <div class="commande-details">
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