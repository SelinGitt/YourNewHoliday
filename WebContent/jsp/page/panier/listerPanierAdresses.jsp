<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Titre de la Page --%>
<div class="panier-title">
    <h1>
        <spring:message code="pan08.titre" />
    </h1>
</div>

<%-- lien Retour --%>
<a class="lien-retour" href="listerPanierProduits.do"><spring:message code="pan08.lien.retour" /></a>

<form:form method="POST" action="validerPanier.do" modelAttribute="adresses"
    class="display-flex flex-direction-row panier-100">
    <%-- champ caché permettant la réinitialisation des données --%>
    <form:hidden path="defaultAdresse.nom" id="defaultNom" />
    <form:hidden path="defaultAdresse.prenom" id="defaultPrenom" />
    <form:hidden path="defaultAdresse.adresse" id="defaultAdresse" />
    <%-- container de facturation + livraison--%>
    <div class="panier-container-Adresse display-flex justify-content-center flex-direction-row">

        <%-- formulaire Adresse de livraison--%>
        <div class="panier-block-fieldSet">
            <div>

                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.livraison" />
                    </legend>
                    <div
                        class="panier-formulaire display-flex flex-wrap-wrap justify-content-center
                         flex-direction-column">
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="livraisonNom"><spring:message code="pan08.label.nom" /></label>
                            <form:input class="panier-formulaire-input" path="commandeAdresseLivraison.nom"
                                id="livraisonNom" />
                        </div>

                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="livraisonPrenom"><spring:message code="pan08.label.prenom" /></label>
                            <form:input class="panier-formulaire-input" path="commandeAdresseLivraison.prenom"
                                id="livraisonPrenom" />
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="livraisonAdresse"><spring:message code="pan08.label.adresse" /></label>
                            <form:textarea class="panier-formulaire-textarea textarea"
                                path="commandeAdresseLivraison.adresse" rows="12" id="livraisonAdresse" />
                        </div>
                    </div>
                    <%-- boutton reset formulaire --%>
                    <button class="panier-margin-left-10" onclick="informationsLivraison()">
                        <spring:message code="pan08.boutton.information" />
                    </button>
                </fieldset>
            </div>
        </div>

        <%-- formulaire Adresse de facturation--%>
        <div class="panier-block-fieldSet">
            <div class="panier-margin-left-3em" id="FormulaireFacturation">
                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.facturation" />
                    </legend>
                    <div
                        class="panier-formulaire display-flex 
                    flex-wrap-wrap justify-content-center flex-direction-column">
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="facturationNom"><spring:message code="pan08.label.nom" /></label>
                            <form:input class="panier-formulaire-input" path="commandeAdresseFacturation.nom"
                                id="facturationNom" />
                        </div>

                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="facturationPrenom"><spring:message code="pan08.label.prenom" /></label>
                            <form:input class="panier-formulaire-input" path="commandeAdresseFacturation.prenom"
                                id="facturationPrenom" />
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="facturationAdresse"><spring:message code="pan08.label.adresse" /></label>
                            <form:textarea class="panier-formulaire-textarea textarea"
                                path="commandeAdresseFacturation.adresse" rows="12" id="facturationAdresse" />
                        </div>
                    </div>
                    <button class="panier-margin-left-15" onclick="informationsFacturation()">
                        <spring:message code="pan08.boutton.information" />
                    </button>
                </fieldset>
            </div>
        </div>

    </div>
    <%--  ma Commande  --%>
    <div class="panier-right">
        <%-- Contenu commun avec pan_00 --%>
        <jsp:include page="maCommande.jsp">
            <jsp:param name="commande" value="pan_08" />
        </jsp:include>

        <%--  totaux : total avant remise, remise, total après remise, bouton valider le panier --%>
        <div class="panier-elements-a-droite">

            <%--  total avant remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3 class="panier-div-prix">
                    <spring:message code="pan00.titre.fieldset.total.avant.remise" />
                </h3>
                <div id="total_avant_remise" class="prix panier-bordure-1px">${panierDto.prixTotalAffichage}
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%-- remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3 class="panier-div-prix">
                    <spring:message code="pan00.titre.fieldset.remise" />
                </h3>
                <div id="remise" class="prix panier-bordure-1px">${panierDto.remiseAffichage }
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%--  total après remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3 class="panier-div-prix">
                    <spring:message code="pan00.titre.fieldset.total.apres.remise" />
                </h3>
                <div id="total_apres_remise" class="prix panier-bordure-1px">${panierDto.prixApresRemiseAffichage }
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%--  bouton valider le panier --%>
            <div class="justify-content-center display-flex align-item-center">
                <button type="submit" class="panier-valider">
                    <spring:message code="pan00.valider.panier" />
                </button>
            </div>
        </div>
    </div>
</form:form>

