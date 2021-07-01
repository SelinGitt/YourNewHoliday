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
    <div class="panier-container-Adresse">

        <%-- formulaire Adresse de livraison--%>

            <%-- il faudra ajouter un modelAttribute--%>
            <form:form method="POST" modelAttribute="utilisateurDto" action="listerPanierAdresses.do" id="monFormulaire">
  <div class="panier-block-fieldSet">
                <fieldset class="fieldSetPan08">
                    <legend class="panier-legend">
                        <spring:message code="pan08.fieldSet.livraison" />
                    </legend>
                    <div class="panier-formulaire">
                        <div class="panier-formulaire-div">
                            <%-- mettre les path="exemple" par la suite --%>
                            <label for="nom"><spring:message code="pan08.label.nom" /></label>

                            <form:input class="panier-formulaire-input" id="livraison-nom"  path="adresse" /> 
                          
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
                        </div>
                 <input type="reset" value="Reset">
            </form:form>


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
    <%--  ma Commande  --%>
    <div class="panier-right">

        <%--  fieldset ma commande : nom, référence, prix unitaire, quantité et prix  --%>
        <fieldset class="overflow-auto panier-macommande">
            <legend class="panier-legend">
                <spring:message code="pan00.titre.fieldset.commande" />
            </legend>

            <c:forEach items="${panierDto.mapPanier}" var="entry">
                <%--  nom et référence --%>
                <div>
                    <h3>${entry.key.nom}-${entry.key.reference}</h3>
                </div>

                <%--  prix unitaire --%>
                <div class="display-flex justify-content-space-between panier-ligne-prix-unitaire">
                    <div class="display-flex justify-content-space-between panier-ligne-label">
                        <spring:message code="pan00.prix.unitaire.bis" />
                        <span><spring:message code="pan00.deuxpoints" /></span>
                    </div>
                    ${entry.key.prixUnitaire}
                    <spring:message code="glb.devise" />
                </div>

                <%--  quantité --%>
                <div class="display-flex justify-content-space-between panier-ligne-quantite">
                    <div class="display-flex justify-content-space-between panier-ligne-label">
                        <spring:message code="pan00.quantite.bis" />
                        <span><spring:message code="pan00.deuxpoints" /></span>
                    </div>
                    <span>${entry.value}</span>
                </div>

                <%--  prix  --%>
                <div class="display-flex justify-content-space-between panier-ligne-prix-unitaire">
                    <div class="display-flex justify-content-space-between panier-ligne-label">
                        <spring:message code="pan00.prix.bis" />
                        <span><spring:message code="pan00.deuxpoints" /></span>
                    </div>
                    <%-- Affichage en dur provisoire pour visualiser l'alignement --%>
                    <%-- Cette valeur sera implémentée par la suite dans le panierDto --%>
                    <span>50,50 <spring:message code="glb.devise" />
                    </span>
                </div>
            </c:forEach>
        </fieldset>

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

    <%--  --%>
    <button onclick="informationsLivraison()">Utiliser mes informations personnelles</button>


    <button onclick="informationsFacturation()">Utiliser mes informations personnelles</button>

    <%-- Script js qui en fonction sur le bouton ou on clique donne des paths au elements --%>

</div>