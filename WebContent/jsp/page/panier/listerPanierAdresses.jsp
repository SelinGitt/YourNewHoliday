<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- Titre de la Page --%>
<h1>
    <spring:message code="pan08.titre" />
</h1>

<%-- lien Retour --%>
<a class="panier-retour" href="listerPanierProduits.do"><spring:message code="pan08.lien.retour" /></a>

<%-- container de facturation + livraison--%>
<div class="panier-container-Adresse">

    <%-- formulaire Adresse de livraison--%>
    <div class="panier-block-fieldSet">
        <%-- il faudra ajouter un modelAttribute--%>
        <form:form method="POST" action="listerPanierAdresses.do">
            <fieldset class="fieldSetPan08">
                <legend class="panier-legend">
                    <spring:message code="pan08.fieldSet.livraison" />
                </legend>
                <div class="panier-formulaire">
                    <div class="panier-formulaire-div">
                        <%-- mettre les path="exemple" par la suite --%>
                        <label for="nom"><spring:message code="pan08.label.nom" /></label> <input
                            class="panier-formulaire-input" type="text" name="nom" id="nom">
                    </div>
                    <div class="panier-formulaire-div">
                        <label for="prenom"><spring:message code="pan08.label.prenom" /></label> <input
                            class="panier-formulaire-input" type="text" id="prenom" name="prenom">
                    </div>
                    <div class="panier-formulaire-div">
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
                <div class="panier-formulaire">
                    <div class="panier-formulaire-div">
                        <%-- mettre les path="exemple" par la suite --%>
                        <label for="nom"><spring:message code="pan08.label.nom" /></label> <input
                            class="panier-formulaire-input" type="text" name="nom" id="nom">
                    </div>
                    <div class="panier-formulaire-div">
                        <label for="prenom"><spring:message code="pan08.label.prenom" /></label> <input
                            class="panier-formulaire-input" type="text" id="prenom" name="prenom">
                    </div>
                    <div class="panier-formulaire-div">
                        <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                        <textarea class="panier-formulaire-textarea" id="adresse" name="adresse" rows="12"></textarea>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>
