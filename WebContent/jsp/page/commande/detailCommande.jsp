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
    <div class="cmd-produits cmd-height cmd-box-sizing cmd-overflow">
        <fieldset class="cmd-border cmd-fieldset cmd-height cmd-box-sizing cmd-overflow">
            <legend class="cmd-fieldset-legend">
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div class="cmd-grid cmd-height cmd-box-sizing cmd-overflow">
                <c:forEach items="${commande.listCommandeProduitDto}" var="cmdProduit">
                    <div class="cmd-border cmd-ligne cmd-box-sizing">
                        <div
                            class="cmd-grid-cel cmd-col-1 cmd-border-right cmd-grid cmd-img-grid cmd-height cmd-box-sizing">
                            <div class="cmd-col-1 cmd-height">
                                <img src="displayImage.do?id=${cmdProduit.produitAcheteDto.idDeLOriginal}&type=pdt"
                                    alt="${cmdProduit.produitAcheteDto.destination}" class="cmd-image">
                            </div>
                            <div class="cmd-col-2 cmd-height">
                                <div class="cmd-bold cmd-text-align-center cmd-box-title">
                                    ${cmdProduit.produitAcheteDto.nom}
                                    <spring:message code="detailCommande.tiret"></spring:message>
                                    ${cmdProduit.produitAcheteDto.reference}
                                </div>
                                <div class="cmd-text-align-justify cmd-box-text">
                                    ${cmdProduit.produitAcheteDto.description}
                                </div>
                            </div>
                        </div>
                        <div class="cmd-grid-cel cmd-col-2 cmd-border-right cmd-height cmd-box-sizing">
                            <div class="cmd-bold cmd-text-align-center cmd-box-title">
                                <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                            </div>
                            <div class="cmd-text-align-right cmd-box-text">
                                ${cmdProduit.produitAcheteDto.prixUnitaire}
                                <spring:message code="glb.devise"></spring:message>
                            </div>
                        </div>
                        <div class="cmd-grid-cel cmd-col-3 cmd-border-right cmd-height cmd-box-sizing">
                            <div class="cmd-bold cmd-text-align-center cmd-box-title">
                                <spring:message code="detailCommande.prd.quantite"></spring:message>
                            </div>
                            <div class="cmd-text-align-center cmd-box-text">${cmdProduit.quantite}</div>
                        </div>
                        <div class="cmd-grid-cel cmd-col-4 cmd-height">
                            <div class="cmd-bold cmd-text-align-center cmd-box-title">
                                <spring:message code="detailCommande.prd.pTotal"></spring:message>
                            </div>
                            <div class="cmd-text-align-right cmd-box-text">
                                ${cmdProduit.prixTotal}
                                <spring:message code="glb.devise"></spring:message>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </fieldset>
    </div>
    <div class="cmd-details cmd-height cmd-box-sizing">
        <div class="cmd-divise-3-hauteur cmd-box-sizing">
            <fieldset class="cmd-border cmd-fieldset cmd-height cmd-box-sizing">
                <legend class="cmd-fieldset-legend">
                    <spring:message code="detailCommande.adr.livraison"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div class="cmd-divise-3-hauteur cmd-box-sizing">
            <fieldset class="cmd-border cmd-fieldset cmd-height cmd-box-sizing">
                <legend class="cmd-fieldset-legend">
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div class="cmd-divise-3-hauteur cmd-box-sizing"></div>
    </div>
</div>