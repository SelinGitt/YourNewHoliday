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
            <%-- il faudra ajouter un modelAttribute--%>
            <form:form method="POST" action="listerPanierAdresses.do">
                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.livraison" />
                    </legend>
                    <div class="panier-formulaire display-flex flex-wrap-wrap justify-content-center flex-direction-column">
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <%-- mettre les path="exemple" par la suite --%>
                            <label for="nom"><spring:message code="pan08.label.nom" /></label> <input
                                class="panier-formulaire-input" type="text" name="nom" id="nom">
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="prenom"><spring:message code="pan08.label.prenom" /></label> <input
                                class="panier-formulaire-input" type="text" id="prenom" name="prenom">
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                            <textarea class="panier-formulaire-textarea" id="adresse" 
                            name="adresse" rows="12"></textarea>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>

        <%-- formulaire Adresse de facturation--%>
        <div class="panier-block-fieldSet">
            <%-- il faudra ajouter un modelAttribute--%>
            <form:form method="POST" action="listerPanierAdresses.do" class="panier-margin-left-3em">
                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.facturation" />
                    </legend>
                    <div class="panier-formulaire display-flex flex-wrap-wrap justify-content-center flex-direction-column">
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <%-- mettre les path="exemple" par la suite --%>
                            <label for="nom"><spring:message code="pan08.label.nom" /></label> <input
                                class="panier-formulaire-input" type="text" name="nom" id="nom">
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="prenom"><spring:message code="pan08.label.prenom" /></label> <input
                                class="panier-formulaire-input" type="text" id="prenom" name="prenom">
                        </div>
                        <div class="panier-formulaire-div display-flex flex-direction-column">
                            <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                            <textarea class="panier-formulaire-textarea" id="adresse" 
                            name="adresse" rows="12"></textarea>
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