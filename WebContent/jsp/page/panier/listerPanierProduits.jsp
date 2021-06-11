<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
    <%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
    <spring:message code="pan00.titre" />
</h1>

<div class="panier-display-flex">
    <div>
        <fieldset class="panier-left panier-overflow-auto">
            <%--  TODO Q2 : Couleur et taille factorisation ? --%>
            <legend>Mon Panier</legend>
            <table class="panier-tab">
                <tbody>
                    <c:forEach items="${utilisateur.panierDto.mapPanier}" var="entry">
                        <tr>
                            <td class="panier-tab-bordure panier-display-flex">
                                <div>
                                    <img class="panier-responsive panier-image-produit"
                                        src="img/panier/produitSample.jpg" alt="image produit" />
                                </div>
                                <div>
                                    <div>
                                        <h2>${entry.key.nom}-${entry.key.reference}</h2>
                                    </div>
                                    <div>${entry.key.description}</div>
                                </div>
                            </td>
                            <td class="panier-tab-bordure panier-prix-unitaire"><div>
                                    <h3>Prix unitaire</h3>
                                </div>
                                <div class="panier-justify-content-center panier-display-flex">
                                    ${entry.key.prixUnitaire}</div></td>
                            <td class="panier-tab-bordure panier-quantite"><div>
                                    <h3>Quantité</h3>
                                </div>
                                <div class="panier-display-flex">
                                    <button type="button">-</button>
                                    <span><input class="panier-quantite" type="text" id="panier-quantite"
                                        name="panier-quantite" size="1" value=${entry.value}></span>
                                    <button type="button">+</button>
                                </div></td>
                            <td class="panier-tab-bordure"><div>
                                    <div class="panier-supprimer">
                                        <h3>Supprimer</h3>
                                    </div>
                                </div>
                                <div class="panier-justify-content-center panier-display-flex">
                                    <img class="panier-responsive" src="img/commun/poubelle.jpg"
                                        alt="icone poubelle pour suppression" />
                                </div></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="panier-vider panier-display-flex panier-align-item-center">
                <button type="button">Vider le panier</button>
            </div>
        </fieldset>
    </div>
    <div class="panier-right">
        <fieldset class="panier-overflow-auto panier-macommande">
            <legend>Ma Commande</legend>
            <c:forEach items="${utilisateur.panierDto.mapPanier}" var="entry">
                <div>
                    <h3>${entry.key.nom}-${entry.key.reference}</h3>
                </div>
                <div>Prix unitaire : ${entry.key.prixUnitaire}</div>
                <div>Quantité : ${entry.value}</div>

                <div>Prix :</div>
            </c:forEach>
        </fieldset>
        <div class="panier-elements-a-droite">
            <div class="panier-ligne-chiffre panier-display-flex panier-align-item-center">
                <h3>Total avant remise</h3>
                <input type="text" id="total_avant_remise" name="total_avant_remise" maxlength="13">
            </div>
            <div class="panier-ligne-chiffre panier-display-flex panier-align-item-center">
                <h3>Remise</h3>
                <input type="text" id="remise" name="remise" maxlength="13">
            </div>
            <div class="panier-ligne-chiffre panier-display-flex panier-align-item-center">
                <h3>Total après remise</h3>
                <input type="text" id="total_après_remise" name="total_après_remise" maxlength="13">
            </div>
            <div class="panier-valider panier-display-flex panier-align-item-center">
                <button type="button">Valider le panier</button>
            </div>

        </div>
    </div>
</div>



