<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
    <spring:message code="detailCommande.titre.text" />${commande.reference}
</h1>
<div>
    <a href="listerCommande.do">
        <button>
            <spring:message code="detailCommande.btn.retour" />
        </button>
    </a>
</div>
<div>
    <div>
        <fieldset>
            <legend>
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div>
                <c:forEach items="${commande.listCommandeProduitDto}" var="commandeProduit">
                    <div>
                        <div>
                            <img src="file://${commandeProduit.produitAcheteDto.cheminDeLImage}" alt="image">
                        </div>
                        <div>
                            <p>
                                ${commandeProduit.produitAcheteDto.nom}
                                <spring:message code="detailCommande.tiret"></spring:message>
                                ${commandeProduit.produitAcheteDto.reference}
                            </p>
                            <p>${commandeProduit.produitAcheteDto.description}</p>
                        </div>
                        <div>
                            <p>
                                <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                            </p>
                            <p>
                                ${commandeProduit.produitAcheteDto.prixUnitaire}
                                <spring:message code="glb.devise"></spring:message>
                            </p>
                        </div>
                        <div>
                            <p>
                                <spring:message code="detailCommande.prd.quantite"></spring:message>
                            </p>
                            <p>${commandeProduit.quantite}</p>
                        </div>
                        <div>
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
    <div>
        <div>
            <fieldset>
                <legend>
                    <spring:message code="detailCommande.adr.livraison"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div>
            <fieldset>
                <legend>
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
            </fieldset>
        </div>
        <div></div>
    </div>
</div>