<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
    <spring:message code="detailCommande.titre.text" />${commande.reference}
</h1>
<div>
    <a href="listerCommande.do">
        <button class="cmd-bouton-retour">
            <spring:message code="detailCommande.btn.retour" />
        </button>
    </a>
</div>
<div class="cmd-grid cmd-container cmd-box-sizing cmd-overflow">
    <div class="cmd-produits cmd-max-height cmd-box-sizing cmd-overflow">
        <fieldset class="cmd-bordure cmd-fieldset cmd-max-height cmd-box-sizing cmd-overflow">
            <legend class="cmd-fieldset-legend">
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div class="cmd-grid cmd-max-height cmd-box-sizing cmd-overflow">
                <c:forEach items="${commande.listCommandeProduitDto}" var="commandeProduit">
                    <div class="cmd-bordure cmd-ligne cmd-box-sizing">
                        <div
                            class="cmd-grid-cel cmd-colonne-1 cmd-bordure-right cmd-grid cmd-image-grid cmd-max-height cmd-box-sizing">
                            <div class="cmd-colonne-1 cmd-max-height">
                                <img src="displayImage.do?id=${commandeProduit.produitAcheteDto.idDeLOriginal}&type=pdt"
                                    alt="${commandeProduit.produitAcheteDto.destination}" class="cmd-image">
                            </div>
                            <div class="cmd-colonne-2 cmd-max-height">
                                <div class="cmd-bold cmd-aligne-text-center cmd-box-title">
                                    ${commandeProduit.produitAcheteDto.nom}
                                    <spring:message code="detailCommande.tiret"></spring:message>
                                    ${commandeProduit.produitAcheteDto.reference}
                                </div>
                                <div class="cmd-aligne-text-justify cmd-box-text">${commandeProduit.produitAcheteDto.description}</div>
                            </div>
                        </div>
                        <div
                            class="cmd-grid-cellule cmd-colonne-2 cmd-bordure-right cmd-max-height cmd-box-sizing">
                            <div class="cmd-bold cmd-aligne-text-center cmd-box-title">
                                <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                            </div>
                            <div class="cmd-aligne-text-right cmd-box-text">
                                ${commandeProduit.produitAcheteDto.prixUnitaire}
                                <spring:message code="glb.devise"></spring:message>
                            </div>
                        </div>
                        <div
                            class="cmd-grid-cel cmd-colonne-3 cmd-bordure-right cmd-max-height cmd-box-sizing">
                            <div class="cmd-bold cmd-aligne-text-center cmd-box-title">
                                <spring:message code="detailCommande.prd.quantite"></spring:message>
                            </div>
                            <div class="cmd-aligne-text-center cmd-box-text">${commandeProduit.quantite}</div>
                        </div>
                        <div class="cmd-grid-cel cmd-colonne-4 cmd-max-height">
                            <div class="cmd-bold cmd-aligne-text-center cmd-box-title">
                                <spring:message code="detailCommande.prd.pTotal"></spring:message>
                            </div>
                            <div class="cmd-aligne-text-right cmd-box-text">
                                ${commandeProduit.prixTotal}
                                <spring:message code="glb.devise"></spring:message>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </fieldset>
    </div>
    <div class="cmd-details cmd-max-height cmd-box-sizing">
        <div class="cmd-divise-3-hauteur cmd-box-sizing">
            <fieldset class="cmd-bordure cmd-fieldset cmd-max-height cmd-box-sizing">
                <legend class="cmd-fieldset-legend">
                    <spring:message code="detailCommande.adr.livraison"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div class="cmd-divise-3-hauteur cmd-box-sizing">
            <fieldset class="cmd-bordure cmd-fieldset cmd-max-height cmd-box-sizing">
                <legend class="cmd-fieldset-legend">
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div class="cmd-divise-3-hauteur cmd-box-sizing"></div>
    </div>
</div>