<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
    <%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
    <spring:message code="pan00.titre" />
</h1>

<div class="display-flex">
    <div>

        <%--  fieldset mon panier : tableau et bouton vider le panier --%>
        <fieldset class="panier-left overflow-auto">

            <legend>
                <spring:message code="pan00.titre.fieldset.panier" />
            </legend>

            <%--  tableau --%>
            <table class="panier-bordure-1px" aria-label="tableau panier">
                <tbody>
                    <c:forEach items="${panierDto.mapPanier}" var="entry">
                        <tr>

                            <%-- encart produit : photo, nom, référence et description  --%>
                            <th class="panier-tab-ligne panier-bordure-1px display-flex">
                                <div>
                                    <%--  photo --%>
                                    <img class="panier-responsive panier-image-produit"
                                        src="img/panier/produitSample.jpg" alt="image produit" />
                                </div>
                                <div>
                                    <div>
                                        <%--  nom et référence --%>
                                        <h2>${entry.key.nom}-${entry.key.reference}</h2>
                                    </div>
                                    <%--  description --%>
                                    <div>${entry.key.description}</div>
                                </div>
                            </th>

                            <%--  encart prix unitaire : label et valeur --%>
                            <td class="panier-tab-ligne panier-bordure-1px panier-prix-unitaire"><div>

                                    <%--  label --%>
                                    <div class="display-flex justify-content-center">
                                        <h3>
                                            <spring:message code="pan00.prix.unitaire" />
                                        </h3>
                                    </div>

                                </div> <%--  valeur --%>
                                <div class="justify-content-center display-flex">
                                    ${entry.key.prixUnitaire}
                                    <spring:message code="glb.devise" />
                                </div></td>

                            <%--  encart quantité : label, bouton -, saisie valeur produit, bouton + --%>
                            <%--  rendu d'affichage uniquement pour l'instant --%>
                            <%--  TODO : sera à modifier avec form:form, form:input, form:button par la suite --%>
                            <%--  Ne pas oublier de déclarer la taglib --%>
                            <td class="panier-tab-ligne panier-bordure-1px panier-quantite text-align-center"><div>

                                    <%--  label --%>
                                    <div class="display-flex justify-content-center">
                                        <h3 class="panier-quantite-label">
                                            <spring:message code="pan00.quantite" />
                                        </h3>
                                    </div>

                                </div>
                                <div class="display-flex">

                                    <%--  bouton - --%>
                                    <button type="button">-</button>

                                    <%--  saisie valeur produit  --%>
                                    <input class="panier-quantite text-align-center" type="text" id="panier-quantite"
                                        name="panier-quantite" value="${entry.value}" size="1">

                                    <%--  bouton + --%>
                                    <button type="button">+</button>
                                </div></td>

                            <%--  encart supprimer : label et image --%>
                            <td class="panier-tab-ligne panier-bordure-1px panier-td-delete"><div>

                                    <%--  label --%>
                                    <div class="panier-supprimer display-flex justify-content-center">
                                        <h3>
                                            <spring:message code="pan00.supprimer" />
                                        </h3>
                                    </div>

                                </div> <%--  image --%>
                                <div class="justify-content-center display-flex">
                                    <a href="?action=supprimer_produit&id=${entry.key.id }"><img
                                        class="panier-responsive" src="img/commun/poubelle.jpg"
                                        alt="icone poubelle pour suppression" /></a>
                                </div></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%--  bouton vider le panier  --%>
            <div class="panier-vider flex-direction-row-reverse display-flex align-item-center">
                <button type="button">
                    <spring:message code="pan00.vider.panier" />
                </button>
            </div>
        </fieldset>

    </div>

    <div class="panier-right">

        <%--  fieldset ma commande : nom, référence, prix unitaire, quantité et prix  --%>
        <fieldset class="overflow-auto panier-macommande">
            <legend>
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
</div>