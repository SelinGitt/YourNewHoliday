<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty confirmationMesssage}">
    <div class="background-validation-block block-message-commun">
        <span class="fa fa-check"></span> <span><spring:message code="${confirmationMesssage}" /> </span>
    </div>
</c:if>
<h1>
    <spring:message code="detailCommande.titre.text" />${commande.reference}
</h1>
<div>
    <a href="listerCommande.do">
        <button class="CMD_04-bouton-retour">
            <spring:message code="detailCommande.btn.retour" />
        </button>
    </a>
</div>
<div class="CMD_04-grid CMD_04-container CMD_04-box-sizing CMD_04-overflow">
    <div class="CMD_04-produits CMD_04-height CMD_04-box-sizing CMD_04-overflow">
        <fieldset class="CMD_04-border CMD_04-fieldset CMD_04-height CMD_04-box-sizing CMD_04-overflow">
            <legend class="CMD_04-fieldset-legend">
                <spring:message code="detailCommande.stitle.text"></spring:message>
            </legend>
            <div class="CMD_04-grid CMD_04-height CMD_04-box-sizing CMD_04-overflow">
                <div class="CMD_04-wrapper CMD_04-box-sizing">
                    <%-- liste des produits achetés --%>
                    <c:forEach items="${commande.listCommandeProduitDto}" var="cmdProduit">
                        <%-- un produit acheté --%>
                        <div class="CMD_04-border CMD_04-ligne CMD_04-box-sizing">
                            <%-- boite contenant les images, le titre du voyage --%>
                            <%-- et sa référence ainsi que ça description --%>
                            <div
                                class="CMD_04-grid-cel CMD_04-col-1 CMD_04-border-right CMD_04-grid
                                       CMD_04-img-grid CMD_04-height CMD_04-box-sizing">
                                <%-- image --%>
                                <div class="CMD_04-col-1 CMD_04-height CMD_04-grid">
                                    <c:url value="consulterProduit.do" var="destination">
                                        <c:param name="idProduit" 
                                        value="${cmdProduit.produitAcheteDto.idDeLOriginal}" />
                                        <c:param name="from" value="detail" />
                                        <c:param name="paramValue" value="${commande.reference}" />
                                    </c:url>
                                    <a href="${destination}"> <img
                                        src="displayImage.do?id=${cmdProduit.produitAcheteDto.idDeLOriginal}&type=pdt"
                                        alt="${cmdProduit.produitAcheteDto.destination} :
                                             ${cmdProduit.produitAcheteDto.cheminDeLImage}"
                                        class="CMD_04-img">
                                    </a>
                                </div>
                                <%-- titre du voyage et sa description --%>
                                <div class="CMD_04-col-2 CMD_04-height">
                                    <div
                                        class="CMD_04-bold CMD_04-text-align-left
                                               CMD_04-box-title CMD_04-title-text-color">
                                        ${cmdProduit.produitAcheteDto.nom}
                                        <spring:message code="detailCommande.tiret"></spring:message>
                                        ${cmdProduit.produitAcheteDto.reference}
                                    </div>
                                    <div class="CMD_04-text-align-justify CMD_04-box-text">
                                        ${cmdProduit.produitAcheteDto.description}</div>
                                </div>
                            </div>
                            <%-- boite prix unitaire --%>
                            <div
                                class="CMD_04-grid-cel CMD_04-col-2 CMD_04-border-right
                                       CMD_04-height CMD_04-box-sizing">
                                <div class="CMD_04-bold CMD_04-text-align-center CMD_04-box-title">
                                    <spring:message code="detailCommande.prd.pUnitaire"></spring:message>
                                </div>
                                <div class="CMD_04-text-align-right CMD_04-box-text CMD_04-grid CMD_04-box-padding">
                                    ${cmdProduit.produitAcheteDto.prixUnitaire}
                                    <spring:message code="glb.devise"></spring:message>
                                </div>
                            </div>
                            <%-- boite quantité de produits acheté --%>
                            <div
                                class="CMD_04-grid-cel CMD_04-col-3 CMD_04-border-right
                                       CMD_04-height CMD_04-box-sizing">
                                <div class="CMD_04-bold CMD_04-text-align-center CMD_04-box-title">
                                    <spring:message code="detailCommande.prd.quantite"></spring:message>
                                </div>
                                <div
                                    class="CMD_04-text-align-center CMD_04-box-text
                                           CMD_04-grid CMD_04-box-padding">${cmdProduit.quantite}</div>
                            </div>
                            <%-- boite prix total --%>
                            <div
                                class="CMD_04-grid-cel CMD_04-col-4
                                       CMD_04-border-right-transparent CMD_04-height CMD_04-box-sizing">
                                <div class="CMD_04-bold CMD_04-text-align-center CMD_04-box-title">
                                    <spring:message code="detailCommande.prd.pTotal"></spring:message>
                                </div>
                                <div class="CMD_04-text-align-right CMD_04-box-text CMD_04-grid CMD_04-box-padding">
                                    ${cmdProduit.prixTotal}
                                    <spring:message code="glb.devise"></spring:message>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </fieldset>
    </div>
    <div class="CMD_04-details CMD_04-height CMD_04-box-sizing">
        <div class="CMD_04-divise-3-hauteur CMD_04-box-sizing">
            <fieldset class="CMD_04-border CMD_04-fieldset CMD_04-height CMD_04-box-sizing">
                <legend class="CMD_04-fieldset-legend">
                    <spring:message code="detailCommande.adr.livraison"></spring:message>
                </legend>
                <div class="CMD_04-adresse-grid CMD_04-box-sizing">
                    <div class="CMD_04-col-1 CMD_04-bold CMD_04-adresse-margin">
                        <spring:message code="detailCommande.nom.livraison"></spring:message>
                    </div>
                    <div class="CMD_04-col-2 CMD_04-adresse-margin">${commande.adresseLivraison.nom}</div>
                    <div class="CMD_04-col-1 CMD_04-bold CMD_04-adresse-margin">
                        <spring:message code="detailCommande.prenom.livraison"></spring:message>
                    </div>
                    <div class="CMD_04-col-2 CMD_04-adresse-margin">${commande.adresseLivraison.prenom}</div>
                    <div class="CMD_04-col-1 CMD_04-bold CMD_04-adresse-margin">
                        <spring:message code="detailCommande.adresseLiv"></spring:message>
                    </div>
                    <div class="CMD_04-col-2 CMD_04-adresse-margin">${commande.adresseLivraison.adresse}</div>
                </div>
            </fieldset>
        </div>
        <div class="CMD_04-divise-3-hauteur CMD_04-box-sizing">
            <fieldset class="CMD_04-border CMD_04-fieldset CMD_04-height CMD_04-box-sizing">
                <legend class="CMD_04-fieldset-legend">
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
                <div class="CMD_04-adresse-grid CMD_04-box-sizing">
                    <div class="CMD_04-col-1 CMD_04-bold CMD_04-adresse-margin">
                        <spring:message code="detailCommande.nom.fct"></spring:message>
                    </div>
                    <div class="CMD_04-col-2 CMD_04-adresse-margin">${commande.adresseFacturation.nom}</div>
                    <div class="CMD_04-col-1 CMD_04-bold CMD_04-adresse-margin">
                        <spring:message code="detailCommande.prenom.fct"></spring:message>
                    </div>
                    <div class="CMD_04-col-2 CMD_04-adresse-margin">${commande.adresseFacturation.prenom}</div>
                    <div class="CMD_04-col-1 CMD_04-bold CMD_04-adresse-margin">
                        <spring:message code="detailCommande.adresseFact"></spring:message>
                    </div>
                    <div class="CMD_04-col-2 CMD_04-adresse-margin">${commande.adresseFacturation.adresse}</div>
                </div>
            </fieldset>
        </div>
        <%--  totaux : total avant remise, remise, total après remise, bouton valider le panier --%>
        <div class="CMD_04-divise-3-hauteur CMD_04-box-sizing">

            <%--  total avant remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.total.avant.remise" />
                </h3>
                <div id="total_avant_remise" class="prix panier-bordure-1px">${commande.prixTotalAvantRemise}
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%-- remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.remise" />
                </h3>
                <div id="remise" class="prix panier-bordure-1px">${remise }
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%--  total après remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.total.apres.remise" />
                </h3>
                <div id="total_apres_remise" class="prix panier-bordure-1px">${commande.prixTotalApresRemise }
                    <spring:message code="glb.devise" />
                </div>
            </div>
        </div>
    </div>
</div>