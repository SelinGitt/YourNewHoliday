<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Titre de la Page --%>
<h1>
    <spring:message code="pan08.titre" />
</h1>

<%-- lien Retour --%>
<a class="panier-retour" href="listerPanierProduits.do"><spring:message code="pan08.lien.retour" /></a>

<div class=" display-flex flex-direction-row panier-100">
    <%-- container de facturation + livraison--%>
    <div class="panier-container-Adresse display-flex justify-content-center flex-direction-row">

        <%-- formulaire Adresse de livraison--%>
        <div class="panier-block-fieldSet">
            <form:form method="POST" modelAttribute="CommandeAdresseLivraison" action="listerPanierAdresses.do"
                id="FormulaireLivraison">

                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.livraison" />
                    </legend>
                    <div
                        class="panier-formulaire display-flex flex-wrap-wrap justify-content-center
                         flex-direction-column">
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="nom"><spring:message code="pan08.label.nom" /></label>
                            <form:input class="panier-formulaire-input" path="nom" />
                        </div>

                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="prenom"><spring:message code="pan08.label.prenom" /></label>
                            <form:input class="panier-formulaire-input" path="prenom" />
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                            <form:textarea class="panier-formulaire-textarea" path="adresse" rows="12" />
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>

        <%-- formulaire Adresse de facturation--%>
        <div class="panier-block-fieldSet">
            <form:form method="POST" modelAttribute="CommandeAdresseFacturation" action="listerPanierAdresses.do"
                class="panier-margin-left-3em" id="FormulaireFacturation">
                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.facturation" />
                    </legend>
                    <div
                        class="panier-formulaire display-flex 
                    flex-wrap-wrap justify-content-center flex-direction-column">
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="nom"><spring:message code="pan08.label.nom" /></label>
                            <form:input class="panier-formulaire-input" path="nom" />
                        </div>

                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="prenom"><spring:message code="pan08.label.prenom" /></label>
                            <form:input class="panier-formulaire-input" path="prenom" />
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                            <form:textarea class="panier-formulaire-textarea" path="adresse" rows="12" />
                        </div>
                    </div>
                </fieldset>
            </form:form>
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
                <h3>
                    <spring:message code="pan00.titre.fieldset.total.avant.remise" />
                </h3>
                <input type="text" id="total_avant_remise" name="total_avant_remise" maxlength="13">
            </div>

            <%-- remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.remise" />
                </h3>
                <input type="text" id="remise" name="remise" maxlength="13">
            </div>

            <%--  total après remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.total.apres.remise" />
                </h3>
                <input type="text" id="total_après_remise" name="total_après_remise" maxlength="13">
            </div>

            <%--  bouton valider le panier --%>
            <div class="justify-content-center display-flex align-item-center">
                <button type="button">
                    <spring:message code="pan00.valider.panier" />
                </button>
            </div>
        </div>
    </div>
</div>

<%-- boutton reset formulaire --%>
<button class="panier-margin-left-10" onclick="informationsLivraison()">
    <spring:message code="pan08.boutton.information" />
</button>

<button class="panier-margin-left-15" onclick="informationsFacturation()">
    <spring:message code="pan08.boutton.information" />
</button>

