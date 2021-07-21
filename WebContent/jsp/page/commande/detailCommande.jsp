<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="CMD_00-commande">
    <spring:message code="detailCommande.titre.text" />${commande.reference}
</h1>
<div class="CMD_04-bouton-retour-margin">
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
                                    <a href="#"><img
                                        src="displayImage.do?id=${cmdProduit.produitAcheteDto.idDeLOriginal}&type=pdt"
                                        alt="${cmdProduit.produitAcheteDto.destination} :
                                             ${cmdProduit.produitAcheteDto.cheminDeLImage}"
                                        class="CMD_04-img"></a>
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
                <div class="CMD_04-livraison-infos">
                    <div class="CMD_04-livraison-info-element  display-flex">
                        <div class="CMD_04-livraison-info-element-titre">Nom</div>
                        <div class="CMD_04-livraison-info-element-contenue">Meunier</div>
                    </div>
                    <div class="CMD_04-livraison-info-element  display-flex">
                        <div class="CMD_04-livraison-info-element-titre">Prénom</div>
                        <div class="CMD_04-livraison-info-element-contenue">Pierre</div>
                    </div>
                    <div class="CMD_04-livraison-info-element  display-flex">
                        <div class="CMD_04-livraison-info-element-titre">Adresse</div>
                        <div class="CMD_04-livraison-info-element-contenue">457 rue du faubourg de Douai 33000
                            Bordeaux</div>
                    </div>
                </div>
            </fieldset>
        </div>
        <div class="CMD_04-divise-3-hauteur CMD_04-box-sizing">
            <fieldset class="CMD_04-border CMD_04-fieldset CMD_04-height CMD_04-box-sizing">
                <legend class="CMD_04-fieldset-legend">
                    <spring:message code="detailCommande.adr.fct"></spring:message>
                </legend>
                <div class="CMD_04-livraison-infos">
                    <div class="CMD_04-livraison-info-element display-flex">
                        <div class="CMD_04-livraison-info-element-titre">Nom</div>
                        <div class="CMD_04-livraison-info-element-contenue">Meunier</div>
                    </div>
                    <div class="CMD_04-livraison-info-element  display-flex">
                        <div class="CMD_04-livraison-info-element-titre">Prénom</div>
                        <div class="CMD_04-livraison-info-element-contenue">Pierre</div>
                    </div>
                    <div class="CMD_04-livraison-info-element  display-flex">
                        <div class="CMD_04-livraison-info-element-titre">Adresse</div>
                        <div class="CMD_04-livraison-info-element-contenue">457 rue du faubourg de Douai 33000
                            Bordeaux</div>
                    </div>
                </div>
            </fieldset>
        </div>

        <%--  totaux : total avant remise, remise, total après remise --%>
        <div class="CMD_04-elements-a-droite">

            <%--  total avant remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>Total avant remise</h3>
                <div class="CMD_04-border-prix-avant-remise">
                    <div class="text-align-center CMD_04-padding-prix">1 000,00</div>
                </div>
            </div>

            <%-- remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>Remise</h3>
                <div class="CMD_04-border-prix-avant-remise">
                    <div class="text-align-center CMD_04-padding-prix">480,00</div>
                </div>
            </div>

            <%--  total après remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>Total après remise</h3>
                <div class="CMD_04-border-prix-avant-remise">
                    <div class="text-align-center CMD_04-padding-prix">520,00</div>
                </div>
            </div>

        </div>
        <div class="CMD_04-divise-3-hauteur CMD_04-box-sizing"></div>
    </div>
</div>