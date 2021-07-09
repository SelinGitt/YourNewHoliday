<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                            <th class="panier-tab-ligne panier-bordure-1px display-flex">
                                <div>
                                    <%--  photo --%>
                                    <a href="consulterProduit.do?idProduit=${entry.key.idProduitOriginal}"><img
                                        class="panier-responsive panier-image-produit"
                                        src="displayImage.do?id=${entry.key.idProduitOriginal}&type=pdt"
                                        alt="${entry.key.destination}" /></a>

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
                                    <a href="modifierQuantite.do?idProduit=${entry.key.idProduitOriginal}&quantite=-1">
                                        <button type="button">-</button>
                                    </a>

                                    <%--  saisie valeur produit  --%>
                                    <input class="panier-quantite text-align-center" type="text" readonly="readonly"
                                        id="panier-quantite" name="panier-quantite" value="${entry.value.quantite}"
                                        size="1">

                                    <%--  bouton + --%>
                                    <a href="modifierQuantite.do?idProduit=${entry.key.idProduitOriginal}&quantite=1">
                                        <button type="button">+</button>
                                    </a>
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
                                    <a href="supprimerProduitPanier.do?id=${entry.key.idProduitOriginal }"><img
                                        class="panier-responsive" src="img/commun/poubelle.jpg"
                                        alt="icone poubelle pour suppression" /></a>
                                </div></td>
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
                    <button type="button">
                        <spring:message code="pan00.valider.panier" />
                    </button>
                </a>
                <div class="panier-buttons">
                    <button type="button" class="panier-valider">
                        <spring:message code="pan00.valider.panier" />
                    </button>
                </div>
            </div>
        </div>
    </div>