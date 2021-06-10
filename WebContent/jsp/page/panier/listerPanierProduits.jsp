<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
    <%-- Titre de la page fr/en : "Panier"/"Shopping cart" --%>
    <spring:message code="pan00.titre" />
</h1>

<div class="panier-corps">
    <div>
        <fieldset class="panier-left panier-ascenceur">
            <legend>
                <h2>Mon Panier</h2>
            </legend>
            <table class="panier-tab">
                <tbody>
                    <c:forEach items="${utilisateur.panierDto.mapPanier}" var="entry">
                        <tr>
                            <td class="panier-tab-bordure panier-produit">
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
                                </div> ${entry.key.prixUnitaire}</td>
                            <td class="panier-tab-bordure panier-quantite"><div>
                                    <h3>Quantité</h3>
                                </div>
                                <div class="panier-gestion-quantite">
                                    <button type="button">-</button>
                                    <span><input class="panier-quantite" type="text" id="panier-quantite" name="panier-quantite"
                                   size="1"    value=${entry.value}></span>
                                    <button type="button">+</button>
                                </div></td>
                            <td class="panier-tab-bordure"><div>
                                    <h3>Supprimer</h3>
                                </div> <img class="panier-responsive" src="img/commun/poubelle.jpg"
                                alt="icone poubelle pour suppression" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="panier-vider">
                <button type="button">Vider le panier</button>
            </div>
        </fieldset>
    </div>
    <div class="panier-right">
        <fieldset class="panier-ascenceur panier-macommande">
            <legend>
                <h2>Ma Commande</h2>
            </legend>
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
            <div class="panier-ligne-chiffre">
                <h3>Total avant remise</h3>
                <input type="text" id="total_avant_remise" name="total_avant_remise" maxlength="13">
            </div>
            <div class="panier-ligne-chiffre">
                <h3>Remise</h3>
                <input type="text" id="remise" name="remise" maxlength="13">
            </div>
            <div class="panier-ligne-chiffre">
                <h3>Total après remise</h3>
                <input type="text" id="total_après_remise" name="total_après_remise" maxlength="13">
            </div>
            <div class="panier-valider">
                <button type="button">Valider le panier</button>
            </div>

        </div>
    </div>
</div>



