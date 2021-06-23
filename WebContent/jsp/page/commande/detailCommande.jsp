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
        <fieldset class="commande-bordure commande-fieldset">
            <legend class="commande-fieldset-legend">
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div class="commande-grille">
                <c:forEach items="${commande.listCommandeProduitDto}" var="commandeProduit">
                    <div class="commande-bordure commande-ligne">
                        <div class="commande-grille-cellule">
                            <div>
                                <img src="file://${commandeProduit.produitAcheteDto.cheminDeLImage}"
                                    alt="${commandeProduit.produitAcheteDto.destination}">
                            </div>
                            <div>
                                <p>
                                    ${commandeProduit.produitAcheteDto.nom}
                                    <spring:message code="detailCommande.tiret"></spring:message>
                                    ${commandeProduit.produitAcheteDto.reference}
                                </p>
                                <p>${commandeProduit.produitAcheteDto.description}</p>
                            </div>
                        </div>
                        <div class="commande-grille-cellule">
                            <p>
                                <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                            </p>
                            <p>
                                ${commandeProduit.produitAcheteDto.prixUnitaire}
                                <spring:message code="glb.devise"></spring:message>
                            </p>
                        </div>
                        <div class="commande-grille-cellule">
                            <p>
                                <spring:message code="detailCommande.prd.quantite"></spring:message>
                            </p>
                            <p>${commandeProduit.quantite}</p>
                        </div>
                        <div class="commande-grille-cellule">
                            <p>
                                <spring:message code="detailCommande.prd.pTotal"></spring:message>
                            </p>
                            <p>
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
            <fieldset class="commande-bordure commande-fieldset">
                <legend class="commande-fieldset-legend">
                    <spring:message code="detailCommande.adr.livraison"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div>
            <fieldset class="commande-bordure commande-fieldset">
                <legend class="commande-fieldset-legend">
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div></div>
    </div>
</div>