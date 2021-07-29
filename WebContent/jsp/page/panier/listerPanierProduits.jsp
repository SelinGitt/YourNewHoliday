<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:if test="${fn:length(listIdError) gt 0 }">
    <div class="background-error-block block-message-commun">
        <span class="fa fa-exclamation"></span> <span class="message"><spring:message
                code="pan00.message.erreur.verifier_produit" /></span>
    </div>
</c:if>

<div class="panier-title">
    <h1>
        <%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
        <spring:message code="pan00.titre" />
    </h1>
</div>

<div class="display-flex">
    <div>

        <%--  fieldset mon panier : tableau et bouton vider le panier --%>
        <fieldset class="panier-left overflow-auto">

            <legend class="panier-legend">
                <spring:message code="pan00.titre.fieldset.panier" />
            </legend>

            <%--  tableau --%>
            <table class="panier-bordure-1px" aria-label="tableau panier">
                <tbody>
                    <c:forEach items="${panierDto.mapPanier}" var="entry">

                        <tr>

                            <%-- encart produit : photo, nom, référence et description  --%>
                            <th class="panier-bordure-1px display-flex panier-th">
                                <div class="panier-div-image">
                                    <div class="panier-image-produit-container">
                                        <%--  photo --%>
                                        <a href="consulterProduit.do?idProduit=${entry.key.idProduitOriginal}&from=pan">
                                            <img class="panier-image-produit"
                                            src="displayImage.do?id=${entry.key.idProduitOriginal}&type=pdt"
                                            alt="${entry.key.destination}" />
                                        </a>
                                    </div>
                                </div>
                                <div class="panier-description-produit">
                                    <div>
                                        <%--  nom et référence --%>
                                        <p class="panier-titre-produit">${entry.key.nom}-${entry.key.reference}</p>
                                    </div>
                                    <%--  description --%>
                                    <div class="panier-description-produit-paragraphe">${entry.key.description}</div>
                                </div>
                            </th>

                            <%--  encart prix unitaire : label et valeur --%>
                            <td class="panier-bordure-1px panier-td text-align-center">
                                <%--  label --%>
                                <div class="panier-label display-flex justify-content-center">
                                    <h3 class="panier-antimarge-prix-unitaire">
                                        <spring:message code="pan00.prix.unitaire" />
                                    </h3>
                                </div> <%--  valeur --%>
                                <div class="panier-td-component justify-content-center display-flex">
                                    ${entry.key.prixUnitaire}
                                    <spring:message code="glb.devise" />
                                </div>
                            </td>

                            <%--  encart quantité : label, bouton -, saisie valeur produit, bouton + --%>
                            <td class="panier-bordure-1px panier-td text-align-center"><div>

                                    <%--  label --%>
                                    <div class="panier-label display-flex justify-content-center">
                                        <h3>
                                            <spring:message code="pan00.quantite" />
                                        </h3>
                                    </div>

                                </div>
                                <div class="panier-td-component justify-content-center display-flex">

                                    <%--  bouton - --%>
                                    <c:if test="${listIdError.contains(entry.key.idProduitOriginal) }">
                                        <button class="panier-boutons-plus-moins" type="button">-</button>
                                    </c:if>
                                    <c:if test="${!listIdError.contains(entry.key.idProduitOriginal) }">
                                        <a
                                            href="
                                            modifierQuantite.do?idProduit=${entry.key.idProduitOriginal}&quantite=-1
                                        ">
                                            <button type="button">-</button>
                                        </a>
                                    </c:if>

                                    <%--  saisie valeur produit  --%>
                                    <input class="panier-quantite text-align-center" type="text" readonly="readonly"
                                        id="panier-quantite" name="panier-quantite" value="${entry.value.quantite}"
                                        size="1">

                                    <%--  bouton + --%>
                                    <c:if test="${listIdError.contains(entry.key.idProduitOriginal) }">
                                        <button class="panier-boutons-plus-moins" type="button">+</button>
                                    </c:if>
                                    <c:if test="${!listIdError.contains(entry.key.idProduitOriginal) }">
                                        <a
                                            href="
                                            modifierQuantite.do?idProduit=${entry.key.idProduitOriginal}&quantite=1
                                        ">
                                            <button type="button">+</button>
                                        </a>
                                    </c:if>
                                </div></td>

                            <%--  encart supprimer : label et image --%>
                            <td class="panier-bordure-1px panier-td"><div>

                                    <%--  label --%>
                                    <div class="panier-label display-flex justify-content-center">
                                        <h3>
                                            <spring:message code="pan00.supprimer" />
                                        </h3>
                                    </div>

                                </div> <%--  image --%>
                                <div class="panier-td-component justify-content-center display-flex">
                                    <a href="supprimerProduitPanier.do?id=${entry.key.idProduitOriginal }"><img
                                        class="panier-responsive" src="img/commun/poubelle.jpg"
                                        alt="icone poubelle pour suppression" /></a>
                                </div></td>
                        </tr>
                        <tr>
                            <c:if test="${listIdError.contains(entry.key.idProduitOriginal) }">
                                <td><div class="text-color-rouge">
                                        <spring:message code="pan00.erreur.produit_indisponible" />
                                    </div></td>
                            </c:if>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>

            <%--  bouton vider le panier  --%>
            <div class="panier-buttons">
                <a href="viderPanier.do"><button type="button" class="panier-vider">
                        <spring:message code="pan00.vider.panier" />
                    </button></a>
            </div>
        </fieldset>


    </div>

    <div class="panier-right">
        <%-- Contenu commun avec pan_08 --%>
        <jsp:include page="maCommande.jsp">
            <jsp:param name="commande" value="pan_00" />
        </jsp:include>

        <%--  totaux : total avant remise, remise, total après remise, bouton valider le panier --%>
        <div class="panier-elements-a-droite">

            <%--  total avant remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.total.avant.remise" />
                </h3>
                <div id="total_avant_remise" class="prix panier-bordure-1px">${panierDto.prixTotalAffichage}
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%-- remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.remise" />
                </h3>
                <div id="remise" class="prix panier-bordure-1px">${panierDto.remiseAffichage }
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%--  total après remise --%>
            <div class="justify-content-space-between display-flex align-item-center">
                <h3>
                    <spring:message code="pan00.titre.fieldset.total.apres.remise" />
                </h3>
                <div id="total_apres_remise" class="prix panier-bordure-1px">${panierDto.prixApresRemiseAffichage }
                    <spring:message code="glb.devise" />
                </div>
            </div>
            <%--  bouton valider le panier --%>
            <div class="justify-content-center display-flex align-item-center">
                <a href="validerPanierProduits.do">
                    <button type="button" class="panier-valider">
                        <spring:message code="pan00.valider.panier" />
                    </button>
                </a>
            </div>
        </div>
    </div>
</div>